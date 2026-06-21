package org.feedapi.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // 보통은 임의의 난수를 생성해서 키값으로 사용함
    // 토큰 생성 시 서명에 들어갈 값
    private final String SECRET_KEY = "my-secret-key-my-secret-key-my-secret-key";

    // String 형태의 secret key를 JWT 서명용 Key 객체로 변환
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    // 토큰 생성
    public String createToken(String userId){
        return Jwts.builder()
                .subject(userId) // 토큰 내부에 들어갈 값
                .issuedAt(new Date()) // 토큰 생성 일시
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 *60)) // 토큰 만료 시간
                .signWith(getSigningKey()) // 토큰 키값(서명)
                .compact(); // 생성
    }

    public String getTokenData(String token){
        Claims claims = Jwts.parser() // jwt 해석기
                .verifyWith((javax.crypto.SecretKey) getSigningKey()) // 토큰 서명 검증
                .build()
                .parseSignedClaims(token) // 잘못된 토큰이 오면 exception 발생(검증)
                .getPayload(); // 내부 데이터 가져옴

        return claims.getSubject();
    }

}
