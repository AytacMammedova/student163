package com.matrix.java163Spring.repository;

import com.matrix.java163Spring.model.entity.University;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UniversityRepository extends JpaRepository<University,Integer> {
    @EntityGraph(attributePaths = "students")
    Optional<University>findById(Integer id);

}
