package com.market.place.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * jwt 생성 담당 서비스
 * */
@Slf4j
@Service
public class JwtProvider {
    private String SECRET_KEY = "WJDQUDDND19raey96";

    /**
     * JWT 토큰 생성
     * @param userId
     * @return
     */
    public String create(String userId) {
        // 토큰 기한은 현재부터 1일
        Date expireDate = Date.from(Instant.now()
                                    .plus(1, ChronoUnit.DAYS));
        return Jwts.builder().signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .setSubject(userId)
                .setIssuer("JBW SHOP")
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .compact();
    }

    public String getUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJwt(token)
                .getBody();
        return claims.getSubject();
    }
}
