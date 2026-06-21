package org.feedapi.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDTO {
    private Integer userNo;
    private String userId;
    private String userPassword;
    private String email;
    private String addr;

}
