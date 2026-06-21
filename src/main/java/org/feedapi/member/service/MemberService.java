package org.feedapi.member.service;

import org.feedapi.member.mapper.MemberMapper;
import org.feedapi.member.dto.JoinDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberMapper feedMapper;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberMapper feedMapper, PasswordEncoder passwordEncoder) {
        this.feedMapper = feedMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public int getIdCnt(String userId) {
        return feedMapper.getIdCnt(userId);
    }

    public void addMember(JoinDTO joinDTO) {
        joinDTO.setUserPassword(passwordEncoder.encode(joinDTO.getUserPassword()));
        feedMapper.addMember(joinDTO);
    }

}
