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
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.function.Function;

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

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@GetMapping("/get")
	public String getEntity(){
		Function<FluentQuery.FetchableFluentQuery<Student>, Student> sortFunction =
				query ->
						query.sortBy(Sort.by("Event-Timestamp").descending()).firstValue();

		var matcher =
				ExampleMatcher.matching()
						.withMatcher(
								"userName", ExampleMatcher.GenericPropertyMatcher::exact);

		var student = Student.builder().userName("pera").build();

		//Student result = studentRepository.findFirstByPropertyOrderByEventTimestamp(student, matcher, sortFunction);
		List<Student> result = studentRepository.findByUserNameAndEventTimestampBetweenOrderByEventTimestampAsc("pera", "1611995400000", "1715851029021");
		System.out.println(result);
		return "a";
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
