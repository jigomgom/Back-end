package com.mini.babmeokeon.dto;

import com.mini.babmeokeon.model.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDto {

   private String comment;


    public CommentResponseDto(Comment comment) {
        this.comment = comment.getComment();
    }
}
