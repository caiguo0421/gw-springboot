package cn.ty.gw.repository;

import cn.ty.gw.model.ReportSendLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportSendLogRepository extends JpaRepository<ReportSendLog, String> {

    /**
     * 查找有效的记录
     * @param subjectNo
     * @return
     */
    @Query("from ReportSendLog u  where u.subjectNo =:subjectNo AND u.sendStatus = 1 AND u.sendDate =:sendDate ")
    public List<ReportSendLog> findEffectiveItem(@Param("subjectNo") String subjectNo, @Param("sendDate") String sendDate);


    public List<ReportSendLog> findBySendDate(String sendDate);
}
