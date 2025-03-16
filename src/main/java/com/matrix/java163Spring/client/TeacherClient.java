package com.matrix.java163Spring.client;

import com.matrix.java163Spring.model.entity.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "teacher-service",url = "http://localhost:8081")
public interface TeacherClient {
    @GetMapping("/teachers")
    List<Teacher> getAll();
    @PostMapping("/teachers")
    Teacher add(@RequestBody Teacher teacher);

}
