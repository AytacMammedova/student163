package com.matrix.java163Spring.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "university")
@Data
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ToString.Exclude
    @OneToMany(mappedBy = "university",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> students;

}
