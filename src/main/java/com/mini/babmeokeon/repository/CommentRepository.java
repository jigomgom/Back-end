package com.mini.babmeokeon.repository;

import com.mini.babmeokeon.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllById(Long storeId);


    List<Comment> findAllByStoreId(Long storeId);

}
