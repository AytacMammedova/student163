package com.matrix.java163Spring.service.impl;

import com.matrix.java163Spring.model.Student;
import com.matrix.java163Spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service("student")
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudentsList(){
        Student student=new Student(1,"Aytac","Mammedova");
        Student student1=new Student(2,"Ali","Aliyev");
        Student student2=new Student(3,"Mehman","Abdullayev");
        Student student3=new Student(4,"khalil","Isgenderli");
        return List.of(student,student1,student2,student3);
    }
    @Override
    public Student getById(@PathVariable Integer id, @RequestParam String name,@RequestParam String surname){
        return new Student(id,"Aytac","Mammedova");
    }

    @Override
    public Student add(@RequestBody Student student){
        student.setId(5);
        return student;
    }

    @Override
    public Student update(@RequestBody Student student){
        return student;
    }

    @Override
    public void delete(@PathVariable Integer id){
        System.out.println("Student deleted");
    }
}
