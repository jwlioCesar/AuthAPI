package com.authAPI.AuthAPI.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.authAPI.AuthAPI.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try {
            String token = JWT.create()
                    .withIssuer("auth-api")//emissor
                    .withSubject(user.getUsername())//define o assunto do token
                    .withExpiresAt(generateExpirationToken())//define a data de expiração do token
                    .sign(algorithm());//garante que o token não foi modificado por alguém não autorizado
            return token;

        }catch (JWTCreationException exception){
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String validateToken(String token){
        try {
            return JWT.require(algorithm())
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
            return "";
        }
    }

    public Instant generateExpirationToken(){//calcula e retorna a data de expiracao
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    private Algorithm algorithm(){
        return Algorithm.HMAC256(secret);
    }

}
