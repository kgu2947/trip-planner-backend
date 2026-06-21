package org.feedapi.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.feedapi.member.dto.JoinDTO;

@Mapper
public interface MemberMapper {

    int getIdCnt(String userId);

    void addMember(JoinDTO joinDTO);

}
