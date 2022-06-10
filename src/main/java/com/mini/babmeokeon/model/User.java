package com.mini.babmeokeon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name ="users")
@Entity
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

}
