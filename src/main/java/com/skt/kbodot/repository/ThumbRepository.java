package com.skt.kbodot.repository;

import com.skt.kbodot.domain.Thumb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThumbRepository extends JpaRepository<Thumb, Long> {
}
