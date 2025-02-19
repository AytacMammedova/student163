package com.matrix.java163Spring.dao;

public interface SQLQueries {
    String SELECT_STUDENT_BY_ID="select id,name,surname,age from students where id=:id";
    String SELECT_STUDENTS="select *from students";
    String INSERT_STUDENT="insert into students (name,surname,age) values (:name,:surname,:age)";
    String UPDATE_STUDENT="update students set name=:name,surname=:surname,age=:age where id=:id ";
    String DELETE_STUDENT="delete from students where id=:id";
}
