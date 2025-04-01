package com.matrix.java163Spring.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;


import java.util.Optional;

public interface AuthService {
    Optional<Authentication>getAuthentication(HttpServletRequest request);
}
