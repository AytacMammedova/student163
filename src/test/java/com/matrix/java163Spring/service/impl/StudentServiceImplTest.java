package com.matrix.java163Spring.service.impl;

import com.matrix.java163Spring.mapper.StudentMapper;
import com.matrix.java163Spring.model.dto.StudentAddRequestDto;
import com.matrix.java163Spring.model.dto.StudentDto;
import com.matrix.java163Spring.model.entity.Student;
import com.matrix.java163Spring.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private StudentMapper studentMapper;
    @Mock
    private StudentRepository studentRepository;
    private Student student;
    private Student student2;
    private StudentDto studentDto;
    private StudentDto studentDto2;
    private StudentAddRequestDto studentAddRequestDto;

    @BeforeEach
    void setUp() {
        student=new Student();
        student.setId(1);
        student.setName("Ali");
        student.setSurname("Aliyev");
        student.setAge(20);

        student2=new Student();
        student2.setId(2);
        student2.setName("Vusale");
        student2.setSurname("Musayeva");
        student2.setAge(22);

        studentDto=new StudentDto();
        studentDto.setName("Ali");
        studentDto.setLastname("Aliyev");
        studentDto.setAge(20);

        studentDto2=new StudentDto();
        studentDto2.setName("Vusale");
        studentDto2.setLastname("Musayeva");
        studentDto2.setAge(22);


        studentAddRequestDto=new StudentAddRequestDto();
        studentAddRequestDto.setName("Ali");
        studentAddRequestDto.setLastname("Aliyev");
        studentAddRequestDto.setAge(20);

    }

    @AfterEach
    void tearDown() {
        student=null;
        studentDto= null;
        studentAddRequestDto=null;

    }
    @Test
    void givenIdThenReturnOK(){
        //Arrange-neleri test edirik,neleri mocklayiriq
        when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));
        when(studentMapper.toStudentDto(student)).thenReturn(studentDto);

        //Act-test etmek
        StudentDto studentDto1=studentService.getById(1);

        //Assert
        assertThat(studentDto1.getName()).isEqualTo("Ali");

        //Verify
        verify(studentRepository,times(1)).findById(1);

    }
    @Test
    void givenStudentThenSaveThenOk(){
        //Arrange
        when(studentMapper.toStudent(studentAddRequestDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(student);
        when(studentMapper.toStudentDto(student)).thenReturn(studentDto);
        //Act
        StudentDto studentDto1=studentService.add(studentAddRequestDto);
        //Assert
        assertThat(studentDto1.getName()).isEqualTo("Ali");
        //Verify
        verify(studentMapper,times(1)).toStudent(studentAddRequestDto);
        verify(studentRepository,times(1)).save(any());
        verify(studentMapper,times(1)).toStudentDto(student);

    }

    @Test
    void givenStudentList(){
        List<Student>studentList=List.of(student, student2) ;
        List<StudentDto>studentDtoList=List.of(studentDto,studentDto2);
        when(studentRepository.findAll()).thenReturn(studentList);
        when(studentMapper.toStudentDtoList(studentList)).thenReturn(studentDtoList);

        List<StudentDto> studentDtoList1=studentService.getStudentsList();

        assertThat(studentDtoList1.getLast().getName()).isEqualTo("Vusale");
        verify(studentMapper,times(1)).toStudentDtoList(studentList);
        verify(studentRepository,times(1)).findAll();
    }

    @Test
    void deleteStudentThenOK(){
        Integer id=1;
        studentService.delete(id);
        verify(studentRepository,times(1)).deleteById(id);

    }




}