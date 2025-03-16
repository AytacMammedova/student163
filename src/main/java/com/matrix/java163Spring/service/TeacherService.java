package com.matrix.java163Spring.service;

import com.matrix.java163Spring.client.TeacherClient;
import com.matrix.java163Spring.model.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final WebClient webClient;
    private final TeacherClient teacherClient;
    public List<Teacher> getAll(){
//        ResponseEntity<List<Teacher>>teacher=webClient.get().uri("/teachers").retrieve().toEntityList(Teacher.class).block();
//        return teacher.getBody();
        return teacherClient.getAll();
    }public Teacher getById(Integer id){
        ResponseEntity<Teacher>teacher=webClient.get().uri("/teachers/"+id).retrieve().toEntity(Teacher.class).block();
        return teacher.getBody();
    }
    public Teacher add(Teacher teacher){
//        return webClient.post()
//                .uri("/teachers")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(teacher)
//                .retrieve()
//                .bodyToMono(Teacher.class).block();
        return teacherClient.add(teacher);

    }


}
