package com.mini.babmeokeon.controller;

import com.mini.babmeokeon.dto.ResponseDto;
import com.mini.babmeokeon.dto.SignUpRequestDto;
import com.mini.babmeokeon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;

    //회원가입
    @PostMapping("/api/signup")
    public ResponseDto<Object> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        return userService.signUp(signUpRequestDto);
    }

    //아이디 중복 체크
    @GetMapping("/api/checkId/{username}")
    public ResponseDto<Object> checkId(@PathVariable String username) {
        return userService.checkId(username);
    }

    //닉네임 중복 체크
    @GetMapping("/api/checkNickname/{nickname}")
    public ResponseDto<Object> checkNickname(@PathVariable String nickname) {
        return userService.checkNickname(nickname);
    }
}
