package com.skt.kbodot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoShortPlay {
    private Long videoId;
    private String title;
    private String videoPath;

    public VideoShortPlay(Long videoId, String title, String videoPath) {
        this.videoId = videoId;
        this.title = title;
        this.videoPath = videoPath;
    }
}
