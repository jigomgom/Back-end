package com.mini.babmeokeon.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

import java.util.List;
@NoArgsConstructor
@Setter@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {
    private boolean response;
    private String message;
    private List<T> storeList;
    private Boolean isLast; // 마지막 페이지 여부
    private Long total; // 마지막 페이지 여부

    private UserInfoDto userInfo;

    public ResponseDto(boolean response, String message, UserInfoDto userInfo) {
        this.response = response;
        this.message = message;
        this.userInfo = userInfo;
    }

    public ResponseDto(boolean response) {
        this.response = response;
    }

    public ResponseDto(boolean response, String message) {
        this.response = response;
        this.message = message;
    }

    public ResponseDto(boolean response, String message, Page<T> storeList) {
        this.response = response;
        this.message = message;
        this.storeList = storeList.getContent();
        this.isLast = storeList.isLast();
        this.total = storeList.getTotalElements();
    }
}