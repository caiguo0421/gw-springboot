package cn.ty.gw.service;

import cn.ty.common.ServiceException;
import cn.ty.gw.model.Users;
import cn.ty.gw.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UsersRepository usersRepository;

    public Users login(String username, String password) {
        List<Users> usersList = usersRepository.findByUsernameAndPassword(username, password);
        if (usersList == null || usersList.size() == 0) {
            throw new ServiceException("用户名或密码不正确");
        }
        return usersList.get(0);
    }

    public Page<Users> findAll(Specification<Users> spec, Pageable pageable) {
        return usersRepository.findAll(spec, pageable);
    }

    public Users find(Integer id) {
        return usersRepository.getOne(id);
    }

    public void saveOrUpdate(Users user) {
        Users formUser = null;
        if (user.getUserId() == null) {
            formUser = user; //新增
        } else {
            formUser = find(user.getUserId());
        }

        formUser.setUsername(user.getUsername());
        formUser.setPassword(user.getPassword());
        usersRepository.saveAndFlush(formUser);
    }

    public void delete(Integer id) {
        Users user = find(id);
        if (user == null) {
            throw new ServiceException(String.format("用户（%d）不存在", id));
        }
        if ("admin".equalsIgnoreCase(user.getUsername())) {
            throw new ServiceException("admin不能删除");
        }
        usersRepository.delete(user);
    }
}
