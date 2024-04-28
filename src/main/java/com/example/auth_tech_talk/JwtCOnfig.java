package com.example.auth_tech_talk;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtCOnfig {

    @Value("${secretKey}")
    private String key;


    @Bean
    public Algorithm algorithm() {
        return Algorithm.HMAC256(key);
    }

    @Bean
    public JWTVerifier jwtVerifier(Algorithm algorithm) {
        return JWT.require(algorithm).build();
    }
}
