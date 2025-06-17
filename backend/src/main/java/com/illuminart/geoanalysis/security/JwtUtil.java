package com.illuminart.geoanalysis.security;

import com.illuminart.geoanalysis.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Секретный ключ для подписи токенов
    private final Key jwtSecret = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Время жизни токена — 24 часа
    @Getter
    private final long jwtExpirationMs = 24 * 60 * 60 * 1000;

    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // Email хранится в `subject`
    }

    public String generateJwtToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(jwtSecret)
                .compact();
    }
}
