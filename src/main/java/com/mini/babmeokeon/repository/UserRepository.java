package com.mini.babmeokeon.repository;

import com.mini.babmeokeon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByNickname(String nickname);
}
