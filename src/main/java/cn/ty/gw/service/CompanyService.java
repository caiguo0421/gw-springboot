package cn.ty.gw.service;

import cn.ty.common.ServiceException;
import cn.ty.gw.model.CompanyUrlMapping;
import cn.ty.gw.model.Users;
import cn.ty.gw.repository.CompanyUrlMappingRepository;
import cn.ty.gw.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
@Transactional
public class CompanyService {
    private Logger logger = LoggerFactory.getLogger(CompanyService.class);

    @Autowired
    private CompanyUrlMappingRepository companyUrlMappingRepository;

    public Page<CompanyUrlMapping> findAll(Specification<CompanyUrlMapping> spec, PageRequest pageable) {
        return companyUrlMappingRepository.findAll(spec, pageable);
    }

    public CompanyUrlMapping find(Integer id) {
        return companyUrlMappingRepository.getOne(id);
    }

    public void saveOrUpdate(CompanyUrlMapping company) {
        if (company.getCompanyId() == null) {//新增
            companyUrlMappingRepository.save(company);
        } else {
            CompanyUrlMapping formCompany = companyUrlMappingRepository.getOne(company.getCompanyId());
            formCompany.setCompanyNo(company.getCompanyNo());
            formCompany.setCompanyName(company.getCompanyName());
            formCompany.setServerUrl(company.getServerUrl());
            formCompany.setDatasourceUrl(company.getDatasourceUrl());
            formCompany.setDatasourceDbName(company.getDatasourceDbName());
            formCompany.setDatasourceUsername(company.getDatasourceUsername());
            formCompany.setDatasourcePassword(company.getDatasourcePassword());
            formCompany.setServerVersion(company.getServerVersion());
            companyUrlMappingRepository.saveAndFlush(formCompany);
        }
    }

    public void delete(Integer id) {
        CompanyUrlMapping company = find(id);
        if (company == null) {
            throw new ServiceException(String.format("经销商（%d）不存在", id));
        }
        companyUrlMappingRepository.delete(company);
    }
}
