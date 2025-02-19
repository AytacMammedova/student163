package com.matrix.java163Spring.service;

import com.matrix.java163Spring.model.entity.University;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UniversityService {
    List<University>getAll();
    University getById(Integer id);
    University add(University university);
    University update(University university);
    void delete(Integer id);
}
