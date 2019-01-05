package com.example.mybatis1.mapper.mssql;

import com.example.mybatis1.domain.City;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CityMapper {
    @Select("select * from city where state = #{state}")
    City findByState(@Param("state") String state);
    //City findByState(String state);
}
