package com.example.mybatis1;

import com.example.mybatis1.mapper.mssql.CityMapper;
import com.example.mybatis1.mapper.oracle.UserMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mybatis1Application implements CommandLineRunner {

    final private CityMapper cityMapper;
    final private UserMapper userMapper;

    public Mybatis1Application (CityMapper cityMapper, UserMapper userMapper)
    {
        this.cityMapper = cityMapper;
        this.userMapper = userMapper;
    }

	public static void main(String[] args) {
		SpringApplication.run(Mybatis1Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cityMapper.findByState("CA"));

        System.out.println(this.userMapper.test());
    }
}
