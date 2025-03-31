package com.matrix.java163Spring.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.matrix.java163Spring.model.dto.StudentAddRequestDto;
import com.matrix.java163Spring.model.dto.StudentDto;
import com.matrix.java163Spring.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel ="spring")
public interface StudentMapper {
    @Mapping(source = "surname",target = "lastname")
    StudentDto toStudentDto(Student student);

    @Mapping(source="lastname",target = "surname")
    Student toStudent(StudentAddRequestDto studentAddRequestDto);

    @Mapping(source="lastname",target = "surname")
    List<StudentDto> toStudentDtoList(List<Student>studentList);





//fullName map etmek
//    @Mapping(source = "student",target = "fullname",qualifiedByName = "mapFullName")
//    StudentDto toStudentDto(Student student);
//    @Named("mapFullName")
//    default String mapFullName(Student student){
//        return student.getSurname()+" "+student.getName();
//    }
}
