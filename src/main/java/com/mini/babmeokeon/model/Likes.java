package com.mini.babmeokeon.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Store store;

    @ManyToOne
    private User user;

    public Likes(Store store, User user) {
        this.store = store;
        this.user = user;
    }
}