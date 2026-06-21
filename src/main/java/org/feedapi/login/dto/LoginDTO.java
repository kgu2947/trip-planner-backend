package org.feedapi.login.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private String userId;
    private String userPassword;
    private String token;
}
