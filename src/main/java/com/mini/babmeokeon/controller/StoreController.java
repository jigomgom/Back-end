package com.mini.babmeokeon.controller;

import com.mini.babmeokeon.dto.ResponseDto;
import com.mini.babmeokeon.dto.StoreRequestDto;
import com.mini.babmeokeon.dto.StoreResponseDto;
import com.mini.babmeokeon.security.UserDetailsImpl;
import com.mini.babmeokeon.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping(value = {"/api/stores/{userid}", "/api/stores"})
    public ResponseDto<StoreResponseDto> getStore(@PathVariable(value = "userid", required = false) Long userId,
                                                  @RequestParam(value = "page",required = false, defaultValue="0") int page,
                                                  @RequestParam(value = "size",required = false, defaultValue="9") int size,
                                                  @RequestParam(value = "sortBy",required = false, defaultValue="id") String sortBy,
                                                  @RequestParam(value = "isAsc",required = false, defaultValue="false") boolean isAsc){



        return storeService.getStore(page,size,sortBy,isAsc,userId);
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
