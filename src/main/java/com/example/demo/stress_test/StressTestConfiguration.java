package com.example.demo.stress_test;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadFactory;

@Configuration
public class StressTestConfiguration {
    @Bean("stressTestThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor stressTestThreadPool() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadFactory(new SimpleThreadFactory("StressJobThread"));
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(Integer.MAX_VALUE);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    private static class SimpleThreadFactory implements ThreadFactory {
        private final String tName;
        public SimpleThreadFactory(String name) {
            this.tName = name;
        }
        public Thread newThread(@NotNull Runnable r) {
            return new Thread(r, tName);
        }
    }
}
