package cn.ty.gw.repository;

import cn.ty.gw.model.CompanyUrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyUrlMappingRepository extends JpaRepository<CompanyUrlMapping, Integer> {

    public List<CompanyUrlMapping> findByDatasourceUrlIsNotNull();

}
