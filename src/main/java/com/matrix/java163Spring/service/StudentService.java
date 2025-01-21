package com.matrix.java163Spring.service;

import com.matrix.java163Spring.model.Student;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public interface StudentService {
    public List<Student> getStudentsList();
    public Student getById(Integer id, String name, String surname);
    public Student add( Student student);
    public Student update( Student student);
    public void delete( Integer id);
}
