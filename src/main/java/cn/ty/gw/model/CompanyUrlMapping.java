package cn.ty.gw.model;


import javax.persistence.*;

/**
 * 门户-经销商列表
 * @author caigx
 *
 */
@Entity
@Table(name = "company_url_mapping")
public class CompanyUrlMapping {

    @Id
    @Column(name="company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    @Column(name="company_no")
    private String companyNo;

    @Column(name="company_name")
    private String companyName;

    @Column(name="server_url")
    private String serverUrl;

    /**
     * datasource的jdbc的Url
     */
    @Column(name="datasource_url")
    private String datasourceUrl;

    @Column(name="datasource_db_name")
    private String datasourceDbName;

    @Column(name="datasource_username")
    private String datasourceUsername;

    @Column(name="datasource_password")
    private String datasourcePassword;

    @Column(name="server_version")
    private String serverVersion;


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    public void setDatasourceUrl(String datasourceUrl) {
        this.datasourceUrl = datasourceUrl;
    }

    public String getDatasourceDbName() {
        return datasourceDbName;
    }

    public void setDatasourceDbName(String datasourceDbName) {
        this.datasourceDbName = datasourceDbName;
    }

    public String getDatasourceUsername() {
        return datasourceUsername;
    }

    public void setDatasourceUsername(String datasourceUsername) {
        this.datasourceUsername = datasourceUsername;
    }

    public String getDatasourcePassword() {
        return datasourcePassword;
    }

    public void setDatasourcePassword(String datasourcePassword) {
        this.datasourcePassword = datasourcePassword;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }
}
