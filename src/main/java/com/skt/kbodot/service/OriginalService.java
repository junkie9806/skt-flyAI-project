package com.skt.kbodot.service;

import com.skt.kbodot.domain.Original;
import com.skt.kbodot.repository.OriginalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginalService {

    @Autowired
    private OriginalRepository originalRepository;

    public List<Original> findByImageId(Long imageId) {
        return originalRepository.findByImage_ImageId(imageId);
    }

}

