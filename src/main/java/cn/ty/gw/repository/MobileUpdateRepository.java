package cn.ty.gw.repository;

import cn.ty.gw.model.MobileUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileUpdateRepository extends JpaRepository<MobileUpdate, Integer>, JpaSpecificationExecutor<MobileUpdate> {

}
