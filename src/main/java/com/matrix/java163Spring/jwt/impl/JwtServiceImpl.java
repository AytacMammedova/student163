package com.matrix.java163Spring.jwt.impl;

import com.matrix.java163Spring.jwt.JwtService;
import com.matrix.java163Spring.model.entity.security.Authority;
import com.matrix.java163Spring.model.entity.security.User;
import io.jsonwebtoken.Claims;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class JwtServiceImpl implements JwtService {
    @Value("SXQgYWxsb3dzIGFuIGF0dGFja2VyIHRvIHBhcnRseSBjaXJjdW12ZW50IHRoZSBzYW1lIG9yaWdpbiBwb2xpY3ksIHdoaWNoIGlzIGRlc2lnbmVkIHRvIHByZXZlbnQgZGlmZmVyZW50IHdlYnNpdGVzIGZyb20gaW50ZXJmZXJpbmcgd2l0aCBlYWNoIG90aGVyLg==")
    private String issueKey;

    @PostConstruct
    public Key secretKey(){
        byte[] keyBytes= Decoders.BASE64.decode(issueKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String issueToken(User user){
        List<String> authorities=user
                .getAuthorities()
                .stream()
                .map(Authority::getAuthority)
                .toList();
        final JwtBuilder jwtBuilder= Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(Duration.ofSeconds(6000))))
                .addClaims(Map.of("roles",authorities))
                .setHeader(Map.of("type","JWT"))
                .signWith(secretKey(), SignatureAlgorithm.HS256);
        return jwtBuilder.compact();
    }



    @Override
    public Claims verifyToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
