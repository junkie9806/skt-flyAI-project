package com.skt.kbodot.repository;

import com.skt.kbodot.domain.Converted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConvertedRepository extends JpaRepository<Converted, Long> {
    List<Converted> findByImage_ImageId(Long imageId);
}
