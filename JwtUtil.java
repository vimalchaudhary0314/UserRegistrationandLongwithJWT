package io.jwtusetologin.login.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    // ✅ MINIMUM 32 CHARACTERS (256 bits for HS256)
    private static final String SECRET =
            "my-super-secure-jwt-secret-key-256-bit-long!!";

    private static final SecretKey KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    // 🔐 TOKEN GENERATION
    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60)
                ) // 1 hour
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    // 🔍 TOKEN VALIDATION
    public String extractUsername(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(KEY)   // ✅ SAME KEY
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
