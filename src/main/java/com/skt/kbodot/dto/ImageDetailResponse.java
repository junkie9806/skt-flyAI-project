package com.skt.kbodot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ImageDetailResponse {
    private Long imageId;
    private List<String> originalPaths;
    private List<String> convertedPaths;
    private List<String> originalTags;
    private List<String> convertedTags;

    public ImageDetailResponse(Long imageId, List<String> originalPaths, List<String> convertedPaths, List<String> originalTags, List<String> convertedTags) {
        this.imageId = imageId;
        this.originalPaths = originalPaths;
        this.convertedPaths = convertedPaths;
        this.originalTags = originalTags;
        this.convertedTags = convertedTags;
    }

}
