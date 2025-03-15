package com.matrix.java163Spring.controller;

import com.matrix.java163Spring.model.entity.Teacher;
import com.matrix.java163Spring.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping
    public List<Teacher> getAll(){
        return teacherService.getAll();
    }
    @GetMapping("/{id}")
    public Teacher getById(@PathVariable Integer id){
        return teacherService.getById(id);
    }
    @PostMapping
    public Teacher add(Teacher teacher){
        return  teacherService.add(teacher);
    }

}
