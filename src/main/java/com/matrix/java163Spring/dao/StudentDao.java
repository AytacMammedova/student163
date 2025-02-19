package com.matrix.java163Spring.dao;

import com.matrix.java163Spring.model.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> getStudentsList();
    public Student getById(Integer id);
    public Student add( Student student);
    public Student update( Student student);
    public void delete( Integer id);
}
