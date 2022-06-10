package com.mini.babmeokeon.service;

import com.mini.babmeokeon.dto.ResponseDto;
import com.mini.babmeokeon.dto.StoreRequestDto;
import com.mini.babmeokeon.dto.StoreResponseDto;
import com.mini.babmeokeon.model.Store;
import com.mini.babmeokeon.repository.StoreRepository;
import com.mini.babmeokeon.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    @Transactional
    public ResponseDto register(StoreRequestDto storeRequestDto, UserDetailsImpl userDetails) {
        String message;
        boolean response = false;
        if(storeRequestDto.getStoreName() == null){
            message = "맛집 이름을 입력해주세요.";
        }
        else if(storeRequestDto.getAddress()== null){
            message = "맛집 주소를 입력해주세요.";
        }
        else if(storeRequestDto.getComment()== null){
            message = "한줄평을 입력해주세요.";
        }
        else if(storeRequestDto.getMenu()== null){
            message = "맛집 대표메뉴를 입력해주세요.";
        }
        else if(storeRequestDto.getStars()== 0){
            message = "맛집 별점을 선택해주세요.";
        }
        else if(storeRequestDto.getImg_url()== null){
            message = "맛집 이미지를 등록해주세요.";
        }
        else{
            message = "성공";
            response = true;
            Store store = new Store(storeRequestDto, userDetails.getUser());
            storeRepository.save(store);
        }
        return new ResponseDto(response, message);


    }

    public ResponseDto getStore() {
        List<StoreResponseDto> storeList = new ArrayList<>();
        for(Store store:storeRepository.findAllByOrderByTimestampDesc()){
            storeList.add(new StoreResponseDto(store));
        }
        return new ResponseDto(true,"성공", storeList);
    }


}
