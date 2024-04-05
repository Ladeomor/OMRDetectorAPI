package com.example.OMRShadeDetectorAPI.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OMRDetectionResult {
    private String examNumber;
    private int totalScore;
}
