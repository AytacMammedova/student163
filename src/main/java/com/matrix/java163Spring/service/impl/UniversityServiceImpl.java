package com.matrix.java163Spring.service.impl;

import com.matrix.java163Spring.model.entity.University;
import com.matrix.java163Spring.repository.UniversityRepository;
import com.matrix.java163Spring.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;
    @Override
    public List<University> getAll() {
        return universityRepository.findAll();
    }

    @Override
    public University getById(Integer id) {
        return universityRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public University add(University university) {
        return universityRepository.save(university);
    }

    @Override
    public University update(University university) {
        return universityRepository.save(university);
    }

    @Override
    public void delete(Integer id) {
        universityRepository.deleteById(id);
    }
}
