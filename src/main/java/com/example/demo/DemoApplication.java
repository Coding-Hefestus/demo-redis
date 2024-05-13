package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.redis.om.spring.RediSearchIndexer;
import com.redis.om.spring.annotations.EnableRedisEnhancedRepositories;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@SpringBootApplication
@ComponentScan(
		basePackages = {"com.example.demo.*"},
		basePackageClasses = {DemoApplication.class})
@AllArgsConstructor
@EnableRedisEnhancedRepositories(basePackages = {"com.example.demo.*"})
@RestController
@RequestMapping("test")
public class DemoApplication implements CommandLineRunner {

	private final StudentRepository studentRepository;
	private final RedisProperties redisProperties;
	private final RediSearchIndexer rediSearchIndexer;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/save")
	public String saveEntity(){
		Student s = studentRepository.save(Student.builder().userName("pera").build());
		System.out.println(s.getId().toString());
		return s.getId().toString();
	}

	@GetMapping("/get")
	public String getEntity(){
		System.out.println(studentRepository.findByUserName("pera"));
		return "a";
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
