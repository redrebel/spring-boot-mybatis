package com.example.mybatis1.mapper;

import com.example.mybatis1.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;


public interface CityMapper {
    @Select("select * from city where state = #{state}")
    City findByState(@Param("state") String state);
    //City findByState(String state);
}
