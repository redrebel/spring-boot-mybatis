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
@MapperScan(value="com.example.mybatis1.mapper.oracle", sqlSessionFactoryRef="oracleSqlSessionFactory")
public class OracleConfig {

    @Bean(name = "oracleDataSource")
    //@Primary
    @ConfigurationProperties(prefix = "datasources.oracle")
    public DataSource oracleDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oracleSqlSessionFactory")
    //@Primary
    public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource") DataSource oracleDataSource
        , ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(oracleDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="oracleSqlSessionTemplate")
    //@Primary
    public SqlSessionTemplate oracleSqlSessionTemplate(SqlSessionFactory oracleSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(oracleSqlSessionFactory);
    }
}
