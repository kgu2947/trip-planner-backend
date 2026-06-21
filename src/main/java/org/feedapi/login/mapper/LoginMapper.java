package org.feedapi.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.feedapi.login.dto.LoginDTO;
import org.feedapi.member.dto.JoinDTO;
import org.feedapi.notice.dto.NoticeDTO;

import java.util.List;

@Mapper
public interface LoginMapper {
    LoginDTO getMember(LoginDTO loginDTO);
}
