package com.eric.bookmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eric.bookmanage.common.tools.JwtUtils;

@SpringBootApplication
@MapperScan("com.eric.bookmanage.domain.mapper")
@EnableConfigurationProperties({ JwtUtils.class })
public class BookmanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmanageApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
