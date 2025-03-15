package com.matrix.java163Spring.service.impl;

import com.matrix.java163Spring.model.entity.Course;
import com.matrix.java163Spring.repository.CourseRepository;
import com.matrix.java163Spring.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public List<Course> getAll() {
        log.info("List of courses");
        return  courseRepository.findAll();
    }

    @Override
    public Course getById(Integer id) {
        return courseRepository.findById(id).orElseThrow(IllegalStateException::new);
    }

    @Override
    public Course add(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void delete(Integer id) {
        courseRepository.deleteById(id);
    }
}
