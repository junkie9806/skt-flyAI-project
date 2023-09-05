package com.skt.kbodot.service;

import com.skt.kbodot.domain.Video;
import com.skt.kbodot.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> findAllVideos() {
        return videoRepository.findAllByOrderByDateDesc();
    }

    public List<Video> findVideosByTeamCode(String teamCode) {
        return videoRepository.findByTeamCodeOrderByDateDesc(teamCode);
    }



    public List<Video> findVideosByTeamCodeAndDate(String teamCode, String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date localDate = formatter.parse(date);
        return videoRepository.findByTeamCodeAndDateOrderByDateDesc(teamCode, localDate);
    }


    public Video findVideoById(Long videoId) {
        return videoRepository.findById(videoId).orElseThrow(() -> new IllegalArgumentException("Invalid video ID."));
    }
}
