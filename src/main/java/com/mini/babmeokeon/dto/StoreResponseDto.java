package com.mini.babmeokeon.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StoreResponseDto {
    private Long id;
    private String storeName;
    private String address;
    private String nickname;
    private String menu;
    private String img_url;
    private int stars;
    private String comment;
    private int likeCount;
    private String timestamp;

}
