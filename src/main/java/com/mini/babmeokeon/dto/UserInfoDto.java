package com.mini.babmeokeon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInfoDto {
    private Long id;
    private String nickname;
    private String icon_url;

    public UserInfoDto(Long id, String nickname, String icon_url) {
        this.id = id;
        this.nickname = nickname;
        this.icon_url = icon_url;
    }
}
