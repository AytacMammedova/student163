package com.matrix.java163Spring.service;

import com.matrix.java163Spring.model.dto.StudentAddRequestDto;
import com.matrix.java163Spring.model.dto.StudentDto;
import com.matrix.java163Spring.model.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public interface StudentService {
     List<StudentDto> getStudentsList();
     StudentDto getById(Integer id);
     StudentDto add( StudentAddRequestDto studentAddRequestDto);
     Student update( Student student);
     void delete( Integer id);
     List<Student>getStudentAgesBiggerThan(int age);
     Student addCourseToStudent(Integer id,Integer courseId);
}
