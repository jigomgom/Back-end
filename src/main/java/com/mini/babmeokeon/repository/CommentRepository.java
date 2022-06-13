package com.mini.babmeokeon.repository;

import com.mini.babmeokeon.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllById(Long storeId);
}
