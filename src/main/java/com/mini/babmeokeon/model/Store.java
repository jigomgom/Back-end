package com.mini.babmeokeon.model;


import com.mini.babmeokeon.dto.StoreRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Store extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String menu;

    @ElementCollection
    @CollectionTable
    @Column(nullable = false)
    private List<String> img_url;

    @Column(nullable = false)
    private int stars;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private int likeCount=0;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Store(StoreRequestDto requestDto, User user){
        this.storeName = requestDto.getStoreName();
        this.address = requestDto.getAddress();
        this.menu = requestDto.getMenu();
        this.img_url = requestDto.getImg_url();
        this.stars = requestDto.getStars();
        this.comment = requestDto.getComment();
        this.user = user;
    }

    public void update(StoreRequestDto requestDto){
        this.storeName = requestDto.getStoreName();
        this.address = requestDto.getAddress();
        this.menu = requestDto.getMenu();
        this.img_url = requestDto.getImg_url();
        this.stars = requestDto.getStars();
        this.comment = requestDto.getComment();
    }
}
