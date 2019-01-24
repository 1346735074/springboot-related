package com.zto.dayun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.zto")
@MapperScan("com.zto.dayun.mapper")
@SpringBootApplication
public class DayunApplication {

	public static void main(String[] args) {
		SpringApplication.run(DayunApplication.class, args);
	}
}
