package com.skt.kbodot.repository;

import com.skt.kbodot.domain.Original;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OriginalRepository extends JpaRepository<Original, Long> {
    List<Original> findByImage_ImageId(Long imageId);

}
