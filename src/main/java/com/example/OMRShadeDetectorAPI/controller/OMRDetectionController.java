package com.example.OMRShadeDetectorAPI.controller;

import com.example.OMRShadeDetectorAPI.model.response.OMRDetectionResult;
import com.example.OMRShadeDetectorAPI.service.OMRDetectionService;
import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController


public class OMRDetectionController {

    private final OMRDetectionService omrDetectionService;

    @Autowired
    public OMRDetectionController(OMRDetectionService omrDetectionService) {
        this.omrDetectionService = omrDetectionService;
    }

    @PostMapping("/omr/count")
    public OMRDetectionResult detectOMR(@RequestParam("images") MultipartFile[] imagePaths) {
        return omrDetectionService.detectOMR(imagePaths);
    }
}