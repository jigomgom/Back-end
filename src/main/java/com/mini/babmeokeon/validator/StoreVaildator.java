package com.mini.babmeokeon.validator;

import com.mini.babmeokeon.dto.StoreRequestDto;

public class StoreVaildator {
    public static String validateStoreInput(StoreRequestDto storeRequestDto) {
        if (storeRequestDto.getStoreName() == null) {
            return "맛집 이름을 입력해주세요.";
        } else if (storeRequestDto.getAddress() == null) {
            return "맛집 주소를 입력해주세요.";
        } else if (storeRequestDto.getComment() == null) {
            return "한줄평을 입력해주세요.";
        } else if (storeRequestDto.getMenu() == null) {
            return "맛집 대표메뉴를 입력해주세요.";
        } else if (storeRequestDto.getStars() == 0) {
            return "맛집 별점을 선택해주세요.";
        } else if (storeRequestDto.getImg_url() == null) {
            return "맛집 이미지를 등록해주세요.";
        }
        return "성공";
    }
}
