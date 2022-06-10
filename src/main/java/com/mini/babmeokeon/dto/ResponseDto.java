package com.mini.babmeokeon.dto;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Setter
public class ResponseDto{
    private boolean response;
    private String message;
    private List<StoreResponseDto> storeList;

    public ResponseDto(boolean response, String message) {
        this.response = response;
        this.message = message;
    }

    public ResponseDto(boolean response, String message, List<StoreResponseDto> storeList) {
        this.response = response;
        this.message = message;
        this.storeList = storeList;
    }
}