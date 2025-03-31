package com.matrix.java163Spring.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matrix.java163Spring.Java163SpringApplication;
import com.matrix.java163Spring.model.dto.StudentAddRequestDto;
import com.matrix.java163Spring.model.dto.StudentDto;
import com.matrix.java163Spring.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;
    private StudentDto studentDto;
    private StudentAddRequestDto studentAddRequestDto;


    @BeforeEach
    void setUp() {
        studentDto = new StudentDto();
        studentDto.setName("Ali");
        studentDto.setLastname("Aliyev");
        studentDto.setAge(22);

        studentAddRequestDto=new StudentAddRequestDto();
        studentAddRequestDto.setName("Ali");
        studentAddRequestDto.setLastname("Aliyev");
        studentAddRequestDto.setAge(20);
    }

    @AfterEach
    void tearDown() {
        studentDto=null;
        studentAddRequestDto=null;
    }
    @Test
    void givenIdThenReturnStudentDtoThenOk()throws Exception{
        when(studentService.getById(anyInt())).thenReturn(studentDto);
        mockMvc.perform(get("/students/{id}",1)
                        .accept(APPLICATION_JSON)
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ali"))
                .andExpect(jsonPath("$.lastname").value("Aliyev"))
                .andExpect(jsonPath("$.age").value(22))
                .andDo(print());

        verify(studentService,times(1)).getById(anyInt());
    }
    @Test
    void givenStudentThenSaveThenOk() throws Exception {
        when(studentService.add(studentAddRequestDto)).thenReturn(studentDto);
        ObjectMapper objectMapper=new ObjectMapper();
        mockMvc.perform(post("/students")
                    .accept(APPLICATION_JSON)
                    .contentType(APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(studentAddRequestDto)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Ali"))
                .andExpect(jsonPath("$.lastname").value("Aliyev"))
                .andExpect(jsonPath("$.age").value(20))
                .andDo(print());
        verify(studentService,times(1)).add(studentAddRequestDto);
    }

}