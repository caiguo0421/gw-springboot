package cn.ty.gw.repository;

import cn.ty.gw.model.CompanyUrlMapping;
import cn.ty.gw.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CompanyUrlMappingRepository extends JpaRepository<CompanyUrlMapping, Integer>,JpaSpecificationExecutor<CompanyUrlMapping> {

    public List<CompanyUrlMapping> findByDatasourceUrlIsNotNull();

}
