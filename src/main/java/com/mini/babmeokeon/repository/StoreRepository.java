package com.mini.babmeokeon.repository;

import com.mini.babmeokeon.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByOrderByTimestampDesc();
}
