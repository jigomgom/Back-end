package com.mini.babmeokeon.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
//    @JoinColumn(name= "USER_ID")
    private User user;

    public Likes(Store store, User user) {
        this.store = store;
        this.user = user;
    }
}