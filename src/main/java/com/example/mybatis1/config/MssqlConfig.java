package com.example.mybatis1.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(value="com.example.mybatis1.mapper", sqlSessionFactoryRef="mssqlSqlSessionFactory")
public class MssqlConfig {
    @Bean(name="mssqlDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mssql")
    public DataSource mssqlDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mssqlSqlSessionFactory")
    @Primary
    public SqlSessionFactory mssqlSqlSessionFactory(@Qualifier("mssqlDataSource") DataSource mssqlDataSource,
            ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mssqlDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "mssqlSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate mssqlSqlSessionTemplate(SqlSessionFactory mssqlSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(mssqlSqlSessionFactory);
    }
}
