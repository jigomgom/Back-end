package com.mini.babmeokeon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StoreRequestDto {
    private String storeName;
    private String address;
    private String menu;
    private String img_url;
    private int stars;
    private String comment;
}
