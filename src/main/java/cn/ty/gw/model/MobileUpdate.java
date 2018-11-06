package cn.ty.gw.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 手机升级包
 */
@Entity
@Table(name = "mobile_update")
public class MobileUpdate {

    /**
     * Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    /**
     * 公司编码
     */
    @Column(name = "company_no")
    private String companyNo;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 更新url
     */
    @Column(name = "update_url")
    private String updateUrl;

    /**
     * 终端类型
     */
    @Column(name = "terminal_type")
    private String terminalType;

    /**
     * 版本号
     */
    @Column(name = "version_code")
    private Integer versionCode;

    /**
     * 版本名称
     */
    @Column(name = "version_name")
    private String versionName;

    /**
     * 升级说明
     */
    @Column(name = "update_content")
    private String updateContent;

    /**
     * 升级时间
     */
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 升级人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 文件大小
     */
    @Column(name = "file_size")
    private String fileSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}
