package com.skt.kbodot.exception;

public class VideoNotFoundException extends RuntimeException {
    public VideoNotFoundException(Integer videoId) {
        super("Video with ID " + videoId + " not found");
    }
}
