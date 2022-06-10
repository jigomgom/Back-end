package com.mini.babmeokeon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mini.babmeokeon.dto.SignUpRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name ="users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    public User(SignUpRequestDto signUpRequestDto) {
        this.username = signUpRequestDto.getUsername();
        this.nickname = signUpRequestDto.getNickname();
        this.password = signUpRequestDto.getPassword();
    }
}
