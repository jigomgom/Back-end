package com.mini.babmeokeon.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {
    private boolean response;
    private String message;
    private T data;

    public ResponseDto(boolean response, String message) {
        this.response = response;
        this.message = message;
    }

    public ResponseDto(boolean response) {
        this.response = response;
    }
}