package com.mini.babmeokeon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SignUpRequestDto {

    private String username;

    private String nickname;

    private String icon_url;

    private String password;

    private String passwordCheck;

}
