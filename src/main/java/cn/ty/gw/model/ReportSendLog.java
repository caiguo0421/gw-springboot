package cn.ty.gw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * 报表发送日志
 *
 * @author caigu
 */
@Entity
@Table(name = "report_send_log")
public class ReportSendLog {

    @Id
    @Column(name = "send_id")
    private String sendId;

    /**
     * 发送时间， YYYY_MM_DD
     */
    @Column(name = "send_date")
    private String sendDate;


    @Column(name = "subject_no")
    private String subjectNo;

    /**
     * 0:失败 1：成功
     */
    @Column(name = "send_status")
    private Short sendStatus;


    @Column(name = "error_log")
    private String errorLog;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    private Timestamp createTime;

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    public Short getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Short sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getErrorLog() {
        return errorLog;
    }

    public void setErrorLog(String errorLog) {
        this.errorLog = errorLog;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
