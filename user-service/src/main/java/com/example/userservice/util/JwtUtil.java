package com.example.userservice.util;

import com.example.userservice.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "hepsiemlak-real-software-world-errors-debugs-infos-hard-secret-key";

    private static long EXPIRATION_TIME=3600000;

    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    private Claims getAllClaimsFromToken(String token) {
        //// @formatter:off
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        // @formatter:on
    }

    public String getUserName(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public Date getExpirationDate(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    public boolean isTokenExpired(String token) {
        return this.getExpirationDate(token).before(new Date());
    }

    public String generateToken(User user) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("userType", user.getUserType().toString());
        claims.put("email", user.getEmail());
        claims.put("id", user.getUserId());

        long now = System.currentTimeMillis();

        // @formatter:off

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setIssuer("emlakburada")
                .setExpiration( new Date(now + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        // @formatter:on
    }
}
