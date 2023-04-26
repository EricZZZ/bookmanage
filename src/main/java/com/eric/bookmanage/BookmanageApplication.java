package com.eric.bookmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.eric.bookmanage.domain.mapper")
public class BookmanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmanageApplication.class, args);
	}

}
