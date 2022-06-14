package com.mini.babmeokeon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LikeCountDto {
    private boolean response;
    private String message;
    private int likeCount;

    public LikeCountDto(boolean response, String message, int likeCount) {
        this.response = response;
        this.message = message;
        this.likeCount = likeCount;
    }
}
