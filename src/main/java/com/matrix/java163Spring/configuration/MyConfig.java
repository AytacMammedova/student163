package com.matrix.java163Spring.configuration;

import com.matrix.java163Spring.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MyConfig {
    @Bean
    public Student getStudentBeans(){
        Student student =new Student();
        student.setId(1);
        student.setName("Aytac");
        student.setSurname("Mammedova");
        return student;

    }
}
