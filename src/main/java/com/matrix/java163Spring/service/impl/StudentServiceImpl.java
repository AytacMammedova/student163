package com.matrix.java163Spring.service.impl;

import com.matrix.java163Spring.mapper.StudentMapper;
import com.matrix.java163Spring.model.dto.StudentAddRequestDto;
import com.matrix.java163Spring.model.dto.StudentDto;
import com.matrix.java163Spring.model.entity.Student;
import com.matrix.java163Spring.model.entity.Course;
import com.matrix.java163Spring.repository.CourseRepository;
import com.matrix.java163Spring.repository.StudentRepository;
import com.matrix.java163Spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service("student")
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper studentMapper;
    //private final ModelMapper modelMapper;



    @Override
    public List<StudentDto> getStudentsList(){
        log.info("List of students");
        return  studentMapper.toStudentDtoList(studentRepository.findAll());
    }
    @Override
    public StudentDto getById(Integer id){
    //mapstruct
        return studentMapper.toStudentDto(studentRepository.findById(id).orElseThrow(IllegalArgumentException::new));
//        Student student=studentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
//        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto add( StudentAddRequestDto studentAddRequestDto){
        Student student=studentMapper.toStudent(studentAddRequestDto);

        return studentMapper.toStudentDto(studentRepository.save(student));
    }

    @Override
    public Student update( Student student){
        return studentRepository.save(student);
    }

    @Override
    public void delete(Integer id){
        log.info("Student deleted");
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentAgesBiggerThan(int age) {
        return studentRepository.getStudentAgesBiggerThan(age);
    }

    @Override
    public Student addCourseToStudent(Integer id, Integer courseId) {
        List<Course>courseList=null;
        Student student=studentRepository.findById(id).get();
        Course course=courseRepository.findById(courseId).get();
        courseList=student.getCourses();
        courseList.add(course);
        student.setCourses(courseList);
        return studentRepository.save(student);

    }
}
