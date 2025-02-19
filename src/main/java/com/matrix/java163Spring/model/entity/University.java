package com.matrix.java163Spring.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "university")
@Data
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}
