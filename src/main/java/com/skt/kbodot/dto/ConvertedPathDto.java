package com.skt.kbodot.dto;


import lombok.Getter;
import lombok.Setter;


//grid 화면에 converted 이미지 삽입
@Getter @Setter
public class ConvertedPathDto {
    private long imageId;

    private String convertedPath;


    public ConvertedPathDto(long imageId, String convertedPath) {
        this.imageId = imageId;
        this.convertedPath = convertedPath;
    }



}
