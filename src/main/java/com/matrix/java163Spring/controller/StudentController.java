package com.matrix.java163Spring.controller;

import com.matrix.java163Spring.model.dto.StudentAddRequestDto;
import com.matrix.java163Spring.model.dto.StudentDto;
import com.matrix.java163Spring.model.entity.Student;
import com.matrix.java163Spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
//    @Autowired
//    @Qualifier("student")
    private final StudentService studentService;

    @GetMapping()
    public List<StudentDto> getStudentsList(){
        return studentService.getStudentsList();
    }
    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable Integer id){
        return studentService.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto add(@RequestBody StudentAddRequestDto studentAddRequestDto){
        return studentService.add(studentAddRequestDto);
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

    @GetMapping("/age")
    public List<Student>getStudentAgesBiggerThan(@RequestParam int age) {
        return studentService.getStudentAgesBiggerThan(age);
    }
    @PostMapping("/{id}/course/{courseId}")
    public Student addCourseToStudent(@PathVariable Integer id, @PathVariable Integer courseId){
        return studentService.addCourseToStudent(id,courseId);
    }

}
