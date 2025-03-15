package com.matrix.java163Spring.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.matrix.java163Spring.model.entity.Course;
import com.matrix.java163Spring.model.entity.University;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data

public class StudentDto {

    private String name;
    private String lastname;
    private int age;
    private UniversityDto university;
    private List<CourseDto> courses;


    @Data
    public static class UniversityDto {
        private String name;
    }
    @Data
    public static class CourseDto{
        private String name;
    }
}
