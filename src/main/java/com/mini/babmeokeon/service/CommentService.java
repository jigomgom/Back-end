package com.mini.babmeokeon.service;

import com.mini.babmeokeon.dto.CommentRequestDto;
import com.mini.babmeokeon.dto.CommentResponseDto;
import com.mini.babmeokeon.dto.ResponseDto;
import com.mini.babmeokeon.model.Comment;
import com.mini.babmeokeon.model.Store;
import com.mini.babmeokeon.model.User;
import com.mini.babmeokeon.repository.CommentRepository;
import com.mini.babmeokeon.repository.StoreRepository;
import com.mini.babmeokeon.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final StoreRepository storeRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, StoreRepository storeRepository) {
        this.commentRepository = commentRepository;
        this.storeRepository = storeRepository;
    }

    @Transactional
    public ResponseDto<Object> createComment(Long storeId, CommentRequestDto commentRequestDto, UserDetailsImpl userDetails) {
        User user = userDetails.getUser();

        Store store = storeRepository.findById(storeId).orElseThrow(
                ()-> new NullPointerException("게시물이 존재하지 않습니다.")
        );

        Comment comment = new Comment(user,store,commentRequestDto);

        commentRepository.save(comment);

        boolean response = true;
        String message = "댓글 작성 완료";

        return new ResponseDto<>(response, message);

    }

    public  ResponseDto<CommentResponseDto>  readComment(Long storeId) {
        List<CommentResponseDto> commentList = new ArrayList<>();
        List<Comment> comments = commentRepository.findAllByStoreId(storeId);
        for (Comment comment : comments) {
            commentList.add(new CommentResponseDto(comment));
        }
        return new ResponseDto<>(true, "성공", commentList);
    }

//
//        List<StoreResponseDto> storeList = new ArrayList<>();
//        for(Store store:storeRepository.findAllByOrderByTimestampDesc()){
//            storeList.add(new StoreResponseDto(store));
//        }
//        return new ResponseDto<>(true,"성공", storeList);


    public ResponseDto<Object> updateComment(Long id, CommentRequestDto commentRequestDto) {
       Comment comment = commentRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("댓글 없음")
        );
        comment.setComment(commentRequestDto.getComment());
        commentRepository.save(comment);
        boolean response = true;
        String message = "댓글 수정 완료";

        return new ResponseDto<>(response, message);
    }

    public ResponseDto<Object> deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("댓글 없음")
        );
        commentRepository.delete(comment);
        boolean response = true;
        String message = "댓글 삭제 완료";

        return new ResponseDto<>(response, message);
    }
}
