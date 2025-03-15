package com.matrix.java163Spring.repository;

import com.matrix.java163Spring.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select * from students where age>?1",nativeQuery = true)
    List<Student>getStudentAgesBiggerThan(int age);

}
