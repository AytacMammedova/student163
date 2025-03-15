package com.matrix.java163Spring.dao.impl;

import com.matrix.java163Spring.dao.SQLQueries;
import com.matrix.java163Spring.dao.StudentDao;
import com.matrix.java163Spring.model.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public List<Student> getStudentsList() {
        return jdbcTemplate.query(SQLQueries.SELECT_STUDENTS,
                new MapSqlParameterSource(),
                new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student getById(Integer id) {
        return jdbcTemplate.queryForObject(SQLQueries.SELECT_STUDENT_BY_ID,
                new MapSqlParameterSource("id",id),
                new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student add(Student student) {
        jdbcTemplate.update(SQLQueries.INSERT_STUDENT,new BeanPropertySqlParameterSource(student));
        return student;
    }

    @Override
    public Student update(Student student) {
        jdbcTemplate.update(SQLQueries.UPDATE_STUDENT,new BeanPropertySqlParameterSource(student));
        return student;
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(SQLQueries.DELETE_STUDENT,new MapSqlParameterSource("id",id));
    }
}
