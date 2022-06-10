package com.mini.babmeokeon.controller;

import com.mini.babmeokeon.dto.ResponseDto;
import com.mini.babmeokeon.dto.StoreRequestDto;
import com.mini.babmeokeon.dto.StoreResponseDto;
import com.mini.babmeokeon.security.UserDetailsImpl;
import com.mini.babmeokeon.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

@RestController
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @PostMapping("/api/store")
    public ResponseDto<Object> register(@RequestBody StoreRequestDto storeRequestDto,
                                @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return storeService.register(storeRequestDto, userDetails);
    }

    @GetMapping("/api/stores")
    public ResponseDto<StoreResponseDto> getStore(){
        return storeService.getStore();
    }

    @PutMapping("/api/store/{id}")
    public ResponseDto<Object> putStore(@PathVariable Long id,
                                @RequestBody StoreRequestDto storeRequestDto,
                                @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return storeService.putStore(id, storeRequestDto, userDetails);
    }

    @DeleteMapping("/api/store/{id}")
    public ResponseDto<Object> deleteStore(@PathVariable Long id,
                                   @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return storeService.deleteStore(id, userDetails);
    }

}
