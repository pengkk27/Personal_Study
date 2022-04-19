package pers.pengkk27.mybatislearn.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 14811
 * @date 2022/4/17
 */
@Configuration
public class DataSourceConfig {


    DataSource dataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }


    DataSource dataSourceTwo() {
        return DruidDataSourceBuilder.create().build();
    }
}
