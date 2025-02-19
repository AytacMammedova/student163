package com.matrix.java163Spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Student {
    private int id;
    private String name;
    private String surname;
    private int age;
    private Integer university_id;
    public Student(){

    }
}
