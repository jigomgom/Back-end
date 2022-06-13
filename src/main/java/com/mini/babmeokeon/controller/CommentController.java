package com.mini.babmeokeon.controller;

import com.mini.babmeokeon.dto.CommentRequestDto;
import com.mini.babmeokeon.dto.ResponseDto;
import com.mini.babmeokeon.model.Comment;
import com.mini.babmeokeon.security.UserDetailsImpl;
import com.mini.babmeokeon.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/api/comment/{storeId}")
    public ResponseDto<Object> createComment(@PathVariable Long storeId,
                                             @RequestBody CommentRequestDto commentRequestDto,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        return commentService.createComment(storeId,commentRequestDto,userDetails);
    }

    @GetMapping("/api/comment/{storeId}")
    public ResponseDto<Comment> readComment(@PathVariable Long storeId){
        return commentService.readComment(storeId);
    }

    @PutMapping("api/comment/{id}")
    public ResponseDto<Object> updateComment(@PathVariable Long id , @RequestBody CommentRequestDto commentRequestDto){
        return commentService.updateComment(id,commentRequestDto);
    }

    @DeleteMapping("api/comment/{id}")
    public ResponseDto<Object> deleteComment(@PathVariable Long id){
        return commentService.deleteComment(id);
    }
}
