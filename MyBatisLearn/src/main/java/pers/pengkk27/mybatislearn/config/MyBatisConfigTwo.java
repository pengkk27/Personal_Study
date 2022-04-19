package pers.pengkk27.mybatislearn.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author 14811
 * @date 2022/4/17
 */
@Configuration
@MapperScan(basePackages = "pers.pengkk27.mybatislearn.repository.mapper2",sqlSessionFactoryRef = "dataSqlSessionFactoryTwo")
public class MyBatisConfigTwo {
    @Primary
    @Bean("dataSourceTwo")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("dataSqlSessionFactoryTwo")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceTwo") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath:mapper2/BookMapper.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean("dataTransactionManagerTwo")
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSourceTwo") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean("dataSqlSessionTemplateTwo")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("dataSqlSessionFactoryTwo") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
