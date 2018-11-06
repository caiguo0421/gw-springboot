package cn.ty.gw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * 报表主题
 *
 * @author caigu
 */
@Entity
@Table(name = "report_subject")
public class ReportSubject {

    /**
     * 主题ID
     */
    @Id
    @Column(name = "subject_id")
    private String subjectId;

    /**
     * 主题编码
     */
    @Column(name = "subject_no")
    private String subjectNo;


    /**
     * 报表版本：和CompanyUrlMapping的serverVersion对应
     */
    @Column(name = "report_version")
    private String reportVersion;

    /**
     * 主题名称
     */
    @Column(name = "subject_name")
    private String subjectName;


    /**
     * 报表sql
     */
    @Column(name = "report_sql")
    private String reportSql;

    /**
     * 备注
     */
    @Column(name = "report_remark")
    private String reportRemark;


    /**
     * 状态 0：停用 1：在用
     */
    @Column(name = "report_status")
    private Short reportStatus;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    private Timestamp createTime;

    /**
     * 排序
     */
    @Column(name = "sort_no")
    private Short sortNo;


    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getReportVersion() {
        return reportVersion;
    }

    public void setReportVersion(String reportVersion) {
        this.reportVersion = reportVersion;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getReportSql() {
        return reportSql;
    }

    public void setReportSql(String reportSql) {
        this.reportSql = reportSql;
    }

    public String getReportRemark() {
        return reportRemark;
    }

    public void setReportRemark(String reportRemark) {
        this.reportRemark = reportRemark;
    }

    public Short getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Short reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Short getSortNo() {
        return sortNo;
    }

    public void setSortNo(Short sortNo) {
        this.sortNo = sortNo;
    }

    @Override
    public String toString() {
        return "ReportSubject{" +
                "subjectNo='" + subjectNo + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", reportVersion='" + reportVersion + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", reportStatus=" + reportStatus +
                '}';
    }
}
