package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>, QueryByExampleExecutor<Student> {

    List<Student> findByUserNameAndEventTimestampBetweenOrderByEventTimestampAsc(String userName, String fromDate, String toDate);

    List<Student> findByUserName(String userName);
}
