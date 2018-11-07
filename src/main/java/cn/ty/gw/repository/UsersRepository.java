package cn.ty.gw.repository;

import cn.ty.gw.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> , JpaSpecificationExecutor<Users> {

    public List<Users> findByUsernameAndPassword(String username, String password);
}
