package com.mini.babmeokeon.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

import java.util.List;
@NoArgsConstructor
@Setter@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T>{
    private boolean response;
    private String message;
    private List<T> storeList;
    private boolean isLast; // 마지막 페이지 여부

    public ResponseDto(boolean response) {
        this.response = response;
    }

    public ResponseDto(boolean response, String message) {
        this.response = response;
        this.message = message;
    }

    public ResponseDto(boolean response, String message, Slice<T> storeList) {
        this.response = response;
        this.message = message;
        this.storeList = storeList.getContent();
        this.isLast = storeList.isLast();
    }

}