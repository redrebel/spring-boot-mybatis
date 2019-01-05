package com.example.mybatis1.mapper.oracle;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select 1 from dual")
    int test();

}
