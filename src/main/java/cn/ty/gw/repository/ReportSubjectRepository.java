package cn.ty.gw.repository;

import cn.ty.gw.model.ReportSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportSubjectRepository extends JpaRepository<ReportSubject, String> {

    @Query("select distinct subjectNo from ReportSubject u where u.reportStatus = 1")
    public List<String> findDistinctSubjectNo();


    public List<ReportSubject> findBySubjectNoAndReportVersionAndReportStatus(String subjectNo, String reportVersion, Short reportStatus);

    /**
     * 查找通用的subject（reportVersion为空）
     *
     * @param subjectNo
     * @return
     */
    @Query("from ReportSubject u  where u.subjectNo =:subjectNo AND u.reportStatus = 1 AND ISNULL(u.reportVersion,'')='' ")
    public List<ReportSubject> findCommonSubject(@Param("subjectNo") String subjectNo);


    @Query(value = "select  distinct subject_no from report_subject a where not exists( select 1 from report_send_log  b where b.send_date=:sendDate and b.send_status =1 and b.subject_no =a.subject_no )  and a.report_status = 1", nativeQuery = true)
    public List<String> findFailSubjectNo(@Param("sendDate") String sendDate);

}
