package cn.ty.gw.service;

import cn.ty.common.ServiceException;
import cn.ty.gw.model.CompanyUrlMapping;
import cn.ty.gw.model.MobileUpdate;
import cn.ty.gw.model.ReportSubject;
import cn.ty.gw.repository.MobileUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@Transactional
public class MobileUpdateService {

    @Autowired
    private MobileUpdateRepository mobileUpdateRepository;

    public Page<MobileUpdate> findAll(Specification<MobileUpdate> spec, PageRequest pageRequest) {
        return mobileUpdateRepository.findAll(spec, pageRequest);
    }

    public MobileUpdate find(Integer id) {
        return mobileUpdateRepository.getOne(id);
    }

    public void saveOrUpdate(MobileUpdate update) {
        if (update.getId() == null) {
            update.setUpdateTime(new Timestamp(System.currentTimeMillis()));

            mobileUpdateRepository.save(update);
        } else {
            MobileUpdate formUpdate = find(update.getId());
            formUpdate.setCompanyNo(update.getCompanyNo());
            formUpdate.setCompanyName(update.getCompanyName());
            formUpdate.setTerminalType(update.getTerminalType());
            formUpdate.setVersionCode(update.getVersionCode());
            formUpdate.setVersionName(update.getVersionName());
            formUpdate.setUpdateContent(update.getUpdateContent());

            mobileUpdateRepository.saveAndFlush(formUpdate);
        }
    }

    public void delete(Integer id) {
        MobileUpdate update = find(id);
        if (update == null) {
            throw new ServiceException(String.format("安装包信息（%d）不存在", id));
        }
        mobileUpdateRepository.delete(update);
    }
}
