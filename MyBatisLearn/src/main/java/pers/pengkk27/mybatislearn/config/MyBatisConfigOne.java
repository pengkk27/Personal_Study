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

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author 14811
 * @date 2022/4/17
 */
@Configuration
@MapperScan(basePackages = "pers.pengkk27.mybatislearn.repository.mapper",sqlSessionFactoryRef = "dataSqlSessionFactoryOne")
public class MyBatisConfigOne {

    @Primary
    @Bean("dataSourceOne")
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("dataSqlSessionFactoryOne")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceOne") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath:mapper/UserMapper.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean("dataTransactionManagerOne")
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSourceOne") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean("dataSqlSessionTemplateOne")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("dataSqlSessionFactoryOne") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
