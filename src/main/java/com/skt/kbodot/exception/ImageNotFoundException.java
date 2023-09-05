package com.skt.kbodot.exception;

public class ImageNotFoundException extends RuntimeException {
    public ImageNotFoundException(Integer imageId) {
        super("Image with ID " + imageId + " not found");
    }
}
