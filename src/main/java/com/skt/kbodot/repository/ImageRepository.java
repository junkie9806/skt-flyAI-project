package com.skt.kbodot.repository;

import com.skt.kbodot.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByTeamCodeOrderByDateDesc(String teamCode);


    List<Image> findByTeamCodeAndDateOrderByDateDesc(String teamCode, Date date);

}

