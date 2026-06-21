package org.feedapi.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.feedapi.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request
                                    , HttpServletResponse response
                                    , FilterChain filterChain) throws ServletException, IOException {

        // 헤더에서 Authorization를 꺼냄
        String authHeader = request.getHeader("Authorization");

        //Bearer 즉 토큰 형식이 맞는지
        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            // Bearer 가 제거된 토큰 값 가져오기
            String token = authHeader.substring(7);

            try{
                // 토큰에서 데이터 가져옴
                String userId = jwtUtil.getTokenData(token);
                System.out.println("로그인 성공 : " + userId);
            }catch (Exception e){
                // 인증 실패 시 401 에러
                response.setStatus(401);
                return;
            }
        }

        // 필터 끝 다음으로
        // 없으면 여기서 끝남
        filterChain.doFilter(request, response);

    }
}
