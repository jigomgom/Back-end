package com.mini.babmeokeon.repository;

import com.mini.babmeokeon.model.Likes;
import com.mini.babmeokeon.model.Store;
import com.mini.babmeokeon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes,Long> {


    Likes findBystoreAndUser(Store store, User user);

    Optional<Likes> findBystoreAndUserId(Store store, Long id);

    boolean existsByUserIdAndStoreId(Long userId, Long id);

    void deleteByStore(Store store);
}
