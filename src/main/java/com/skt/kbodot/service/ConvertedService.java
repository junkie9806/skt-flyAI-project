package com.skt.kbodot.service;

import com.skt.kbodot.domain.Converted;
import com.skt.kbodot.repository.ConvertedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvertedService {

    @Autowired
    private ConvertedRepository convertedRepository;

    public List<Converted> findByImageId(Long imageId) {
        return convertedRepository.findByImage_ImageId(imageId);
    }
}
