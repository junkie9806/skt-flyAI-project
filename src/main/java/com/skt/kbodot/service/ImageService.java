package com.skt.kbodot.service;

import com.skt.kbodot.domain.Converted;
import com.skt.kbodot.domain.Image;
import com.skt.kbodot.domain.Original;
import com.skt.kbodot.dto.ConvertedPathDto;
import com.skt.kbodot.dto.OriginalPathDto;
import com.skt.kbodot.repository.ConvertedRepository;
import com.skt.kbodot.repository.ImageRepository;
import com.skt.kbodot.repository.OriginalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private OriginalRepository originalRepository;

    @Autowired
    private ConvertedRepository convertedRepository;



    // grid 화면에 original 이미지 삽입
    /*
    public List<OriginalPathDto> findImages(String teamCode, Date date) {
        List<Image> images = imageRepository.findByTeamCodeAndDateOrderByDateDesc(teamCode, date);
        return convertImagesToOriginalPathDtos(images);
    }

    public List<OriginalPathDto> findImagesByTeamCode(String teamCode) {
        List<Image> images = imageRepository.findByTeamCodeOrderByDateDesc(teamCode);
        return convertImagesToOriginalPathDtos(images);
    }

    public List<OriginalPathDto> findAllImages() {
        List<Image> images = imageRepository.findAll();
        return convertImagesToOriginalPathDtos(images);
    }

    private List<OriginalPathDto> convertImagesToOriginalPathDtos(List<Image> images) {
        List<OriginalPathDto> originalPaths = new ArrayList<>();
        for (Image image : images) {
            for (Original original : image.getOriginals()) {
                originalPaths.add(new OriginalPathDto(original.getOriginalId(),original.getOriginalPath()));
            }
        }
        return originalPaths;
    }

*/


    //grid화면에 converted 이미지 삽입
    public List<ConvertedPathDto> findImages(String teamCode, Date date) {
        List<Image> images = imageRepository.findByTeamCodeAndDateOrderByDateDesc(teamCode, date);
        return convertImagesToOriginalPathDtos(images);
    }

    public List<ConvertedPathDto> findImagesByTeamCode(String teamCode) {
        List<Image> images = imageRepository.findByTeamCodeOrderByDateDesc(teamCode);
        return convertImagesToOriginalPathDtos(images);
    }

    public List<ConvertedPathDto> findAllImages() {
        List<Image> images = imageRepository.findAll();
        return convertImagesToOriginalPathDtos(images);
    }

    private List<ConvertedPathDto> convertImagesToOriginalPathDtos(List<Image> images) {
        List<ConvertedPathDto> convertedPaths = new ArrayList<>();
        for (Image image : images) {
            for (Converted converted : image.getConverteds()) {
                convertedPaths.add(new ConvertedPathDto(converted.getConvertedId(),converted.getConvertedPath()));
            }
        }
        return convertedPaths;
    }

}
