
package com.skt.kbodot.controller;

import com.skt.kbodot.domain.Video;
import com.skt.kbodot.dto.VideoShortPlay;
import com.skt.kbodot.dto.VideoShortResponse;
import com.skt.kbodot.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shorts")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public ResponseEntity<?> getAllVideos(@RequestParam(required = false) String teamCode,
                                          @RequestParam(required = false) String date) {
        List<Video> videos;
        try {
            if (teamCode != null && date != null) {
                videos = videoService.findVideosByTeamCodeAndDate(teamCode, date);
            } else if (teamCode != null) {
                videos = videoService.findVideosByTeamCode(teamCode);
            } else {
                videos = videoService.findAllVideos();
            }
            List<VideoShortResponse> response = videos.stream()
                    .map(video -> new VideoShortResponse(video.getVideoId(), video.getTitle(), video.getThumb().getThumbPath()))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>("날짜 형식이 잘못되었습니다. 올바른 형식은 yyyyMMdd입니다.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{videoId}")
    public ResponseEntity<?> getVideoById(@PathVariable Long videoId) {
        Video video = videoService.findVideoById(videoId);

        if (video != null) {
            VideoShortPlay response = new VideoShortPlay(video. getVideoId(), video.getTitle(), video.getVideoPath());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
