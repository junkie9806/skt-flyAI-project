package com.skt.kbodot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VideoShortResponse {
    private Long videoId;
    private String title;
    private String thumbPath;

    public VideoShortResponse(Long videoId, String title, String thumbPath) {
        this.videoId = videoId;
        this.title = title;
        this.thumbPath = thumbPath;
    }


}
