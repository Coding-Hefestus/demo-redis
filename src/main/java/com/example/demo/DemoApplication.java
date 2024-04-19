package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.redis.om.spring.annotations.EnableRedisEnhancedRepositories;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@SpringBootApplication
@ComponentScan(
		basePackages = {"com.example.demo.*"},
		basePackageClasses = {DemoApplication.class})
@AllArgsConstructor
@EnableRedisEnhancedRepositories(basePackages = {"com.example.demo.*"})
public class DemoApplication implements CommandLineRunner {

	private final StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String from = String.valueOf(LocalDateTime.of(2024, 10, 11, 0, 0, 0).toInstant(ZoneOffset.UTC).toEpochMilli());
		String now = String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli());

		List<Student> test = studentRepository.findByUserNameAndEventTimestampBetweenOrderByEventTimestampAsc("test", from, now);
		System.out.println(test.size());
	}
}
