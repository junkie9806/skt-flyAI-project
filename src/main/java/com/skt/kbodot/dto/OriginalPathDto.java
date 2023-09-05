package com.skt.kbodot.dto;

import lombok.Getter;
import lombok.Setter;


//grid화면에 original이미지 삽입
@Getter @Setter
public class OriginalPathDto {

    private long imageId;

    private String originalPath;


    public OriginalPathDto(long imageId, String originalPath) {
        this.imageId = imageId;
        this.originalPath = originalPath;
    }


}
