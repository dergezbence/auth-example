package com.example.auth_tech_talk;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final Algorithm algorithm;
    private final JWTVerifier verifier;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public String generateJwt(Object payload) {
        return JWT.create()
                .withClaim("userDetails", objectMapper.writeValueAsString(payload))
                .withExpiresAt(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .sign(algorithm);
    }

    @SneakyThrows
    public String decodeJwt(String jwtToken) {
        DecodedJWT decodedJWT = verifier.verify(jwtToken);
        return decodedJWT.getClaim("userDetails").asString();
    }
}
