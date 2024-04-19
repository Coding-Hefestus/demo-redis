package com.example.demo;

import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestClass extends AbstractBaseEnhancedRedisTest{

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testEmpty(){
        System.out.println();
    }
}
