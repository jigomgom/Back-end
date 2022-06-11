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

    @PostMapping("/api/signup")
    public ResponseDto<Object> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        System.out.println("signup");
        return userService.signUp(signUpRequestDto);
    }

    @GetMapping("/api/checkId/{username}")
    public ResponseDto<Object> checkId(@PathVariable String username) {
        return userService.checkId(username);
    }

    @GetMapping("/api/checkNickname/{nickname}")
    public ResponseDto<Object> checkNickname(@PathVariable String nickname) {
        return userService.checkNickname(nickname);
    }
}
