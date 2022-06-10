package com.mini.babmeokeon.service;

import com.mini.babmeokeon.dto.ResponseDto;
import com.mini.babmeokeon.dto.StoreRequestDto;
import com.mini.babmeokeon.dto.StoreResponseDto;
import com.mini.babmeokeon.model.Store;
import com.mini.babmeokeon.repository.StoreRepository;
import com.mini.babmeokeon.security.UserDetailsImpl;
import com.mini.babmeokeon.validator.StoreVaildator;
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
    public ResponseDto<Object> register(StoreRequestDto storeRequestDto, UserDetailsImpl userDetails) {
        String message = StoreVaildator.validateStoreInput(storeRequestDto);
        boolean response = false;
        if(message.equals("성공")){
            response = true;
            Store store = new Store(storeRequestDto, userDetails.getUser());
            storeRepository.save(store);
        }
        return new ResponseDto<>(response, message);


    }

    public ResponseDto<StoreResponseDto> getStore() {
        List<StoreResponseDto> storeList = new ArrayList<>();
        for(Store store:storeRepository.findAllByOrderByTimestampDesc()){
            storeList.add(new StoreResponseDto(store));
        }
        return new ResponseDto<>(true,"성공", storeList);
    }

    @Transactional
    public ResponseDto<Object> putStore(Long id, StoreRequestDto storeRequestDto, UserDetailsImpl userDetails) {
        String message = StoreVaildator.validateStoreInput(storeRequestDto);
        boolean response = false;
        Store store = storeRepository.findById(id).orElseThrow(()-> new NullPointerException("해당 맛집이 없습니다."));
        if(store.getUser() != userDetails.getUser()){
            message = "본인의 게시글이 아닙니다.";
        }
        else if(message.equals("성공")){
            response = true;
            store.update(storeRequestDto);
        }
        return new ResponseDto<>(response, message);
    }


    public ResponseDto<Object> deleteStore(Long id, UserDetailsImpl userDetails) {
        String message;
        boolean response = false;
        Store store = storeRepository.findById(id).orElseThrow(()-> new NullPointerException("해당 맛집이 없습니다."));
        if(store.getUser() != userDetails.getUser()){
            message = "본인의 게시글이 아닙니다.";
        }
        else {
            response = true;
            message = "성공";
            storeRepository.deleteById(id);
        }
        return new ResponseDto<>(response, message);
    }
}
