package com.matrix.java163Spring.jwt;

import com.matrix.java163Spring.model.entity.security.User;
import io.jsonwebtoken.Claims;

public interface JwtService {
    String issueToken(User user);
    Claims verifyToken(String token);
}
