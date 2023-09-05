package com.skt.kbodot.repository;

import com.skt.kbodot.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
   //List<Video> findByTeamCodeAndDateOrderByDateDesc(String teamCode, LocalDate date);
    List<Video> findByTeamCodeAndDateOrderByDateDesc(String teamCode, Date date);

    List<Video> findByTeamCodeOrderByDateDesc(String teamCode);
    List<Video> findAllByOrderByDateDesc();
}
