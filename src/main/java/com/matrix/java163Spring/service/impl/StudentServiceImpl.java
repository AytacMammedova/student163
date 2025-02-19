package com.matrix.java163Spring.service.impl;

import com.matrix.java163Spring.dao.StudentDao;
import com.matrix.java163Spring.model.Student;
import com.matrix.java163Spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@Service("student")
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;
    @Override
    public List<Student> getStudentsList(){
        log.info("List of students");
        return studentDao.getStudentsList();
    }
    @Override
    public Student getById( Integer id){
        return studentDao.getById(id);
    }

    @Override
    public Student add( Student student){
        return studentDao.add(student);
    }

    @Override
    public Student update( Student student){
        return studentDao.update(student);
    }

    @Override
    public void delete(Integer id){
        log.info("Student deleted");
        studentDao.delete(id);
    }
}
