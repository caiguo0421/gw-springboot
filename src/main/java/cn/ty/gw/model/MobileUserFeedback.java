package cn.ty.gw.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 手机用户反馈
 *
 * @author caigu
 */
@Entity
@Table(name = "mobile_user_feedback")
public class MobileUserFeedback {

    /**
     * Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 平台
     */
    @Column(name = "platform")
    private String platform;


    /**
     * 反馈内容
     */
    @Column(name = "feedback")
    private String feedback;


    /**
     * 反馈用户
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 反馈时间
     */
    @Column(name = "time")
    private Timestamp time;

    /**
     * 手机型号
     */
    @Column(name = "mobile_model")
    private String mobileModel;

    /**
     * 网络类型
     */
    @Column(name = "apn_type")
    private String apnType;

    /**
     * 程序版本
     */
    @Column(name = "version_name")
    private String versionName;

    /**
     * 反馈邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 用户名称
     */
    @Column(name = "company_name")
    private String companyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    public String getApnType() {
        return apnType;
    }

    public void setApnType(String apnType) {
        this.apnType = apnType;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
