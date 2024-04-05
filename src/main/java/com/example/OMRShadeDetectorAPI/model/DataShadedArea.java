package com.example.OMRShadeDetectorAPI.model;

import com.example.OMRShadeDetectorAPI.util.LabelAxis;

public class DataShadedArea extends ShadedArea{
    public String data;

    public DataShadedArea(String sectionTitle, Rectangle rect, int rowNo, String[] label, LabelAxis labelAxis){
        super(sectionTitle, rect, rowNo, label, labelAxis);
    }
    public String getData() {
        return data;
    }

    // Setter method for Data
    public void setData(String data) {
        this.data = data;
    }
}