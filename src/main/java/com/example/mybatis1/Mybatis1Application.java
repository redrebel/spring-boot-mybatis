package com.example.mybatis1;

import com.example.mybatis1.mapper.CityMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mybatis1Application implements CommandLineRunner {

    final private CityMapper cityMapper;

    public Mybatis1Application (CityMapper cityMapper)
    {
        this.cityMapper = cityMapper;
    }

	public static void main(String[] args) {
		SpringApplication.run(Mybatis1Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cityMapper.findByState("CA"));
    }
}
