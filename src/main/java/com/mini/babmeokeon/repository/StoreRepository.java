package com.mini.babmeokeon.repository;

import com.mini.babmeokeon.dto.StoreResponseDto;
import com.mini.babmeokeon.model.Store;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByOrderByTimestampDesc();

    Page<Store> findPageBy(Pageable pageable);

    Slice<Store> findSliceByOrderByIdDesc(Pageable pageable);
    Page<Store> findPageByOrderByIdDesc(Pageable pageable);

    Slice<Store> findSliceBy(Pageable pageable);
}
