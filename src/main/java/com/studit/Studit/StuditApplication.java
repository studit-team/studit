package com.studit.Studit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class StuditApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuditApplication.class, args);
	}

	@Bean
	public CommandLineRunner testConnection(JdbcTemplate jdbcTemplate) {
		return args -> {
			try {
				String now = jdbcTemplate.queryForObject("SELECT NOW()", String.class);
				System.out.println("✅ DB 연결 성공! 현재 시간: " + now);
			} catch (Exception e) {
				System.err.println("❌ DB 연결 실패: " + e.getMessage());
			}
		};
	}

}
