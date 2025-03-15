package com.matrix.java163Spring.repository;

import com.matrix.java163Spring.model.entity.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Integer> {

}
