package com.example.demo;

import com.redis.om.spring.annotations.EnableRedisEnhancedRepositories;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles({"it"})
@SpringBootTest( //
    classes = {AbstractBaseEnhancedRedisTest.Config.class},//
    properties = { "spring.main.allow-bean-definition-overriding=true",
            "spring.cloud.config.enabled: false"})
@TestPropertySource(properties = {"spring.config.location=classpath:vss_on.yaml"})
public abstract class AbstractBaseEnhancedRedisTest extends AbstractBaseOMTest {
  @Configuration
  @EnableRedisEnhancedRepositories(basePackages = {"com.demo.example.*"})
  @EnableRedisRepositories
  static class Config extends TestConfig {
  }
}
