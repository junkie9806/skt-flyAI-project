package com.skt.kbodot.controller;

import com.skt.kbodot.domain.Converted;
import com.skt.kbodot.domain.Original;
import com.skt.kbodot.dto.ConvertedPathDto;
import com.skt.kbodot.dto.ImageDetailResponse;
import com.skt.kbodot.dto.OriginalPathDto;
import com.skt.kbodot.service.ConvertedService;
import com.skt.kbodot.service.ImageService;
import com.skt.kbodot.service.OriginalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private OriginalService originalService;

    @Autowired
    private ConvertedService convertedService;


    //grid화면에 original이미지 삽입
/*


    // 이미지 목록 조회
    @GetMapping
    public ResponseEntity<?> getAllImages(@RequestParam(required = false) String teamCode,
                                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyyMMdd") Date date) {
        List<OriginalPathDto> originalPaths;

        if (teamCode != null && date != null) {
            originalPaths = imageService.findImages(teamCode, date);
        } else if (teamCode != null) {
            originalPaths = imageService.findImagesByTeamCode(teamCode);
        } else {
            originalPaths = imageService.findAllImages();
        }

        return new ResponseEntity<>(originalPaths, HttpStatus.OK);
    }

*/


    //grid 화면에 converted 이미지 삽입
    // 이미지 목록 조회
    @GetMapping
    public ResponseEntity<?> getAllImages(@RequestParam(required = false) String teamCode,
                                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyyMMdd") Date date) {
        List<ConvertedPathDto> ConvertedPaths;

        if (teamCode != null && date != null) {
            ConvertedPaths = imageService.findImages(teamCode, date);
        } else if (teamCode != null) {
            ConvertedPaths = imageService.findImagesByTeamCode(teamCode);
        } else {
            ConvertedPaths = imageService.findAllImages();
        }

        return new ResponseEntity<>(ConvertedPaths, HttpStatus.OK);
    }




    // 이미지 상세 조회
    @GetMapping("/{imageId}")
    public ResponseEntity<?> getImageDetail(@PathVariable Long imageId) {
        List<Original> originals = originalService.findByImageId(imageId);
        List<Converted> converteds = convertedService.findByImageId(imageId);

        List<String> originalPaths = originals.stream().map(Original::getOriginalPath).collect(Collectors.toList());
        List<String> convertedPaths = converteds.stream().map(Converted::getConvertedPath).collect(Collectors.toList());


        // Original과 Converted 클래스에 적절한 태그 정보가 있다고 가정
        List<String> originalTags = originals.stream().map(Original::getTag).collect(Collectors.toList());
        List<String> convertedTags = converteds.stream().map(Converted::getTag).collect(Collectors.toList());

        ImageDetailResponse response = new ImageDetailResponse(imageId,originalPaths, convertedPaths, originalTags, convertedTags);

        return ResponseEntity.ok(response);
    }
}

