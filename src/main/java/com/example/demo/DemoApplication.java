package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.redis.om.spring.annotations.EnableRedisEnhancedRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@ComponentScan(
		basePackages = {"com.example.demo.*"},
		basePackageClasses = {DemoApplication.class})

@EnableRedisEnhancedRepositories(basePackages = {"com.example.demo.*"})
@EnableScheduling
@RestController
@RequestMapping("test")
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/get2")
	public String get2(){
		List<Student> pera = studentRepository.findByUserName("pera");
		System.out.println(pera);
		return "A";
	}




	@Override
	public void run(String... args) throws Exception {

	}

}
