package com.matrix.java163Spring.model.entity.security;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Authority implements GrantedAuthority {
    @Id
    private Integer id;
    private String authority;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

}
