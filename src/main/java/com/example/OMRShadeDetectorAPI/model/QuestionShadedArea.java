package com.example.OMRShadeDetectorAPI.model;

import com.example.OMRShadeDetectorAPI.util.LabelAxis;

public class QuestionShadedArea extends ShadedArea{
    public String[] Answers;
    public int Score;

    public QuestionShadedArea(String sectionTitle, Rectangle rect, int rowNo, String[] label, LabelAxis labelAxis, String[] answers){
        super(sectionTitle, rect, rowNo, label, labelAxis);
        Answers = answers;
    }

}