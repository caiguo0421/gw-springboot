package cn.ty.gw.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 手机异常信息反馈
 *
 * @author caigu
 */
@Entity
@Table(name = "mobile_exception")
public class MobileException {

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
     * 异常信息
     */
    @Column(name = "exception_msg")
    private String exceptionMsg;


    /**
     * 手机型号
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
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;


    /**
     * sdk版本号
     */
    @Column(name = "sdk_version_number")
    private Integer sdkVersionNumber;


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

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getSdkVersionNumber() {
        return sdkVersionNumber;
    }

    public void setSdkVersionNumber(Integer sdkVersionNumber) {
        this.sdkVersionNumber = sdkVersionNumber;
    }
}
