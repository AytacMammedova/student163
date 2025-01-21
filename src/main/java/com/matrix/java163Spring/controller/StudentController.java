package com.matrix.java163Spring.controller;

import com.matrix.java163Spring.model.Student;
import com.matrix.java163Spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    @Qualifier("student")
    private StudentService studentService;
    @GetMapping()
    public List<Student>getStudentsList(){
        return studentService.getStudentsList();
    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id, @RequestParam String name,@RequestParam String surname){
        return studentService.getById(id, name,surname);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student add(@RequestBody Student student){
        return studentService.add(student);
    }
    @PutMapping
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        studentService.delete(id);
    }


}
