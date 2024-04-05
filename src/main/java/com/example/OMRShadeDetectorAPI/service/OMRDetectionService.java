package com.example.OMRShadeDetectorAPI.service;

import com.example.OMRShadeDetectorAPI.model.response.OMRDetectionResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OMRDetectionService {
//    OMRDetectionResult detectOMR(List<String> imagePaths);

    OMRDetectionResult detectOMR(MultipartFile[] imagePaths);
}
