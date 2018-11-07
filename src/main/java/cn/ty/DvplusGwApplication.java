package cn.ty;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@ServletComponentScan//这行是为了避免扫描不到Druid的Servlet
public class DvplusGwApplication {

    public static void main(String[] args) {
        SpringApplication.run(DvplusGwApplication.class, args);
    }


    @Bean("duridDatasource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druidDataSource() { return new DruidDataSource(); }

}
