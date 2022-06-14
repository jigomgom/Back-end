package com.mini.babmeokeon.controller;

import com.mini.babmeokeon.dto.LikeCountDto;
import com.mini.babmeokeon.security.UserDetailsImpl;
import com.mini.babmeokeon.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikesController {

    private final LikesService likesService;
    @Autowired
    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }

    @PostMapping("/api/like/{storeId}")
    public LikeCountDto Likes(@PathVariable Long storeId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likesService.likes(storeId,userDetails);
    }

    @DeleteMapping("/api/unlike/{storeId}")
    private LikeCountDto unLikes(@PathVariable Long storeId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likesService.unLikes(storeId,userDetails);
    }
}
