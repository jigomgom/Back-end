package com.mini.babmeokeon.model;


import com.mini.babmeokeon.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;

    private String comment;


    public Comment(User user, Store store, CommentRequestDto commentRequestDto) {
        this.user = user;
        this.store = store;
        this.comment = commentRequestDto.getComment();
    }
}
