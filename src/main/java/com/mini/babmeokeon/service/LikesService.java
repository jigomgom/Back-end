package com.mini.babmeokeon.service;

import com.mini.babmeokeon.dto.LikeCountDto;
import com.mini.babmeokeon.dto.ResponseDto;
import com.mini.babmeokeon.model.Likes;
import com.mini.babmeokeon.model.Store;
import com.mini.babmeokeon.model.User;
import com.mini.babmeokeon.repository.LikesRepository;
import com.mini.babmeokeon.repository.StoreRepository;
import com.mini.babmeokeon.repository.UserRepository;
import com.mini.babmeokeon.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikesService {
    private final LikesRepository likesRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Autowired
    public LikesService(LikesRepository likesRepository, StoreRepository storeRepository, UserRepository userRepository) {
        this.likesRepository = likesRepository;
        this.storeRepository = storeRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public LikeCountDto likes(Long storeId, UserDetailsImpl userDetails) {
        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시글 입니다.")
        );
        User user = userRepository.findById(userDetails.getUser().getId()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저입니다.")
        );
        int likeCount = store.getLikeCount() + 1;

        store.setLikeCount(likeCount);
        storeRepository.save(store);

        Likes likes = new Likes(store, user);
        likesRepository.save(likes);

        String message = "좋아요 등록 성공";
        boolean response = true;

        return new LikeCountDto(response, message, likeCount);

    }


    @Transactional
    public LikeCountDto unLikes(Long storeId, UserDetailsImpl userDetails) {
        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시글 입니다.")
        );

        User user = userDetails.getUser();
        Likes likes = likesRepository.findBystoreAndUser(store,user);


        int likeCount = store.getLikeCount() - 1;

        store.setLikeCount(likeCount);
        storeRepository.save(store);


        likesRepository.delete(likes);

        String message = "좋아요 삭제 성공";
        boolean response = true;
        return new LikeCountDto(response, message, likeCount);

    }
}
