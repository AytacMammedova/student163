package com.matrix.java163Spring.controller;

import com.matrix.java163Spring.model.entity.University;
import com.matrix.java163Spring.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService universityService;
    @GetMapping
    public List<University> getAll(){
        return universityService.getAll();
    }
    @GetMapping("/{id}")
    public University getById(@PathVariable Integer id){
        return  universityService.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public University add(@RequestBody University university){
        return universityService.add(university);
    }
    @PutMapping
    public University update(@RequestBody University university){
        return universityService.update(university);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        universityService.delete(id);
    }

}
