package com.example.demo.repository;

import com.example.demo.entity.Student;
import com.redis.om.spring.repository.RedisEnhancedRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
//import com.redis.om.spring.repository.RedisEnhancedRepository;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.ExampleMatcher;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.data.repository.query.QueryByExampleExecutor;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;


//@Transactional(readOnly = true)
@Repository
public interface StudentRepository extends RedisEnhancedRepository<Student, Long>, QueryByExampleExecutor<Student> { //

//    List<Student> findByUserNameAndEventTimestampBetweenOrderByEventTimestampAsc(String userName, String fromDate, String toDate);
//
    List<Student> findByUserName(String userName);
//
//    default Student findFirstByPropertyOrderByEventTimestamp(
//            Student student,
//            ExampleMatcher exampleMatcher,
//            Function<FluentQuery.FetchableFluentQuery<Student>, Student> queryFunction) {
//        return findBy(Example.of(student, exampleMatcher), queryFunction);
//    }
}
