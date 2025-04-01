package com.matrix.java163Spring.service.impl;

import com.matrix.java163Spring.jwt.JwtService;
import com.matrix.java163Spring.service.AuthService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private static final String ROLE_CLAIM="roles";
    private static final String AUTH_HEADER="Authorization";
    private static final String BEARER="bearer";
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;


    @Override
    public Optional<Authentication> getAuthentication(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(AUTH_HEADER))
                .filter(this::isBearerAuth)
                .flatMap(this::getAuthenticationBearer);
    }

    private boolean isBearerAuth(String header) {
        return header.toLowerCase().startsWith(BEARER);
    }
    private Optional< Authentication> getAuthenticationBearer(String header) {
        String token=header.substring("Bearer".length()).trim();
        Claims claims=jwtService.verifyToken(token);
        log.info("claims parsed{}",claims);
        if(claims.getExpiration().before(new Date())){
            return Optional.empty();
        }
        return Optional.of(getAuthenticationBearer(claims));
    }
    private Authentication getAuthenticationBearer(Claims claims){
        List<?>roles=claims.get(ROLE_CLAIM,List.class);
        List<GrantedAuthority>authorityList=roles
                .stream()
                .map(auth->new SimpleGrantedAuthority(auth.toString()))
                .collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(userDetailsService.loadUserByUsername(claims.getSubject()),"",authorityList);
    }
}
