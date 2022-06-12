package com.mini.babmeokeon.service;

import com.mini.babmeokeon.dto.ResponseDto;
import com.mini.babmeokeon.dto.SignUpRequestDto;
import com.mini.babmeokeon.model.User;
import com.mini.babmeokeon.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public ResponseDto<Object> signUp(SignUpRequestDto signUpRequestDto) {
        String username = signUpRequestDto.getUsername();
        String password = signUpRequestDto.getPassword();
        String passwordCheck = signUpRequestDto.getPasswordCheck();
        String nickname = signUpRequestDto.getNickname();
        if (username == null || password == null || passwordCheck == null || nickname == null) {
            return new ResponseDto<>(false, "모두 입력해 주세요");
        }
        if (!username.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$")){
            return new ResponseDto<>(false, "이메일 형식이 아닙니다.");
        }
        if (password.length() < 8 || password.length() > 20 ) {
            return new ResponseDto<>(false,"비밀번호는 최소 8글자 이상, 20글자 이하로 작성해 주세요.");
        }
        if (!password.matches("^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,20}$")) {
            return new ResponseDto<>(false,"비밀번호는 영문 + 숫자로 작성해 주세요.");
        }
        if (!password.equals(passwordCheck)) {
            return new ResponseDto<>(false,"확인용 비밀번호가 일치하지 않습니다.");
        }
        if (nickname.length() < 4 || nickname.length() > 20 ) {
            return new ResponseDto<>(false,"닉네임은 최소 4글자 이상, 20글자 이하로 작성해 주세요.");
        }
        if (!nickname.matches("^[0-9a-zA-Z]{4,20}$")) {
            return new ResponseDto<>(false,"닉네임은 영문 + 숫자로 작성해 주세요.");
        }
        if (!this.checkId(username).isResponse()) {
            return new ResponseDto<>(false, "아이디 중복");
        }
        if (!this.checkNickname(nickname).isResponse()) {
            return new ResponseDto<>(false, "닉네임 중복");
        }
        signUpRequestDto.setPassword(passwordEncoder.encode(password));
        User user = new User(signUpRequestDto);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return new ResponseDto<>(false, "알수 없는 에러 " + e.getMessage());
        }

        return new ResponseDto<>(true, "회원가입 성공");
    }

    public ResponseDto<Object> checkId(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            if (!username.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$")){
                return new ResponseDto<>(false, "이메일 형식이 아닙니다.");
            }
            return new ResponseDto<>(true);
        }
        return new ResponseDto<>(false, "아이디 중복");
    }

    public ResponseDto<Object> checkNickname(String nickname) {
        User user = userRepository.findByNickname(nickname);
        if (user == null) {
            if (nickname.length() < 4 || nickname.length() > 20 ) {
                return new ResponseDto<>(false,"닉네임은 최소 4글자 이상, 20글자 이하로 작성해 주세요.");
            }
            if (!nickname.matches("^[0-9a-zA-Z]{4,20}$")) {
                return new ResponseDto<>(false,"닉네임은 영문 + 숫자로 작성해 주세요.");
            }
            return new ResponseDto<>(true);
        }
        return new ResponseDto<>(false, "닉네임 중복");
    }
}
