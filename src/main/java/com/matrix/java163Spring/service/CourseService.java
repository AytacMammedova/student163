package com.matrix.java163Spring.service;

import com.matrix.java163Spring.model.entity.Course;
import com.matrix.java163Spring.model.entity.University;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> getAll();
    Course getById(Integer id);
    Course add(Course course);
    Course update(Course course);
    void delete(Integer id);
}
