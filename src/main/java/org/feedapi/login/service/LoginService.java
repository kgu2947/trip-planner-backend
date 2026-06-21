package org.feedapi.login.service;

import org.feedapi.login.dto.LoginDTO;
import org.feedapi.login.dto.LoginDataDTO;
import org.feedapi.login.mapper.LoginMapper;
import org.feedapi.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LoginService {
    private final LoginMapper loginMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginService(LoginMapper loginMapper, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.loginMapper = loginMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginDataDTO tryLogin(LoginDTO loginDTO) {
        LoginDTO getUserInfo = loginMapper.getMember(loginDTO);

        if(getUserInfo == null) {
            return null;
        }
        if(!passwordEncoder.matches(loginDTO.getUserPassword()
                                          , getUserInfo.getUserPassword())) {
            return null;
        }

        LoginDataDTO loginDataDTO = new LoginDataDTO();

        // userId를 담은 jwt 토큰 생성
        String token = jwtUtil.createToken(getUserInfo.getUserId());
        loginDataDTO.setToken(token);
        loginDataDTO.setUserId(getUserInfo.getUserId());

        return loginDataDTO;
    }
}
