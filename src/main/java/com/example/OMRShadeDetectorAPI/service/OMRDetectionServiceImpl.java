package com.example.OMRShadeDetectorAPI.service;

import com.example.OMRShadeDetectorAPI.model.*;
import com.example.OMRShadeDetectorAPI.model.response.OMRDetectionResult;
import com.example.OMRShadeDetectorAPI.util.LabelAxis;
import com.example.OMRShadeDetectorAPI.util.MathFunctions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class OMRDetectionServiceImpl implements OMRDetectionService {

    @Override
    public OMRDetectionResult detectOMR(MultipartFile[] imagePaths) {
        OMRDetectionResult result = new OMRDetectionResult();

        for (   MultipartFile imagePath : imagePaths) {
            try {
                BufferedImage inputImage = ImageIO.read(imagePath.getInputStream());
                if (inputImage != null) {
                    MarkingScript script = new MarkingScript(inputImage, 100, 11, 11);
                    script.ShadedAreas.add(new QuestionShadedArea("1-35", new Rectangle(new Vector2(240, 48), new Vector2(301, 548)), 35, new String[]{"A", "B", "C", "D"}, LabelAxis.horizontal, new String[]{"B", "A", "C", "D", "A", "D", "D", "A", "C", "A", "A", "B", "C", "A", "A", "C", "A", "B", "A", "D", "C", "C", "A", "D", "D", "C", "C", "C", "A", "C", "C", "B", "B", "D", "D"}));
                    script.ShadedAreas.add(new QuestionShadedArea("36-50", new Rectangle(new Vector2(242, 561), new Vector2(300, 772)), 15, new String[]{"A", "B", "C", "D"}, LabelAxis.horizontal, new String[]{"C", "A", "C", "C", "B", "D", "D", "D", "A", "A", "A", "A", "C", "A", "C"}));
                    script.ShadedAreas.add(new QuestionShadedArea("51-85", new Rectangle(new Vector2(327, 50), new Vector2(385, 547)), 35, new String[]{"A", "B", "C", "D"}, LabelAxis.horizontal, new String[]{"C", "C", "D", "C", "A", "A", "B", "C", "D", "B", "C", "C", "C", "D", "A", "B", "B", "B", "D", "D", "B", "B", "C", "D", "B", "D", "A", "B", "A", "B", "C", "A", "C", "A", "C"}));
                    script.ShadedAreas.add(new QuestionShadedArea("86-100", new Rectangle(new Vector2(327, 560), new Vector2(385, 772)), 15, new String[]{"A", "B", "C", "D"}, LabelAxis.horizontal, new String[]{"D", "A", "C", "A", "B", "D", "B", "C", "D", "A", "D", "D", "C", "A", "C"}));
                    script.ShadedAreas.add(new QuestionShadedArea("101-135", new Rectangle(new Vector2(410, 50), new Vector2(470, 548)), 35, new String[]{"A", "B", "C", "D"}, LabelAxis.horizontal, new String[]{"D", "B", "B", "A", "A", "D", "D", "B", "A", "B", "B", "C", "C", "D", "D", "C", "A", "D", "C", "D", "C", "C", "B", "C", "D", "C", "D", "A", "B", "D", "C", "B", "D", "B", "B"}));
                    script.ShadedAreas.add(new QuestionShadedArea("136-150", new Rectangle(new Vector2(410, 560), new Vector2(470, 772)), 15, new String[]{"A", "B", "C", "D"}, LabelAxis.horizontal, new String[]{"C", "D", "D", "B", "D", "B", "B", "C", "A", "D", "A", "C", "C", "C", "C"}));
                    script.ShadedAreas.add(new QuestionShadedArea("151-185", new Rectangle(new Vector2(495, 50), new Vector2(555, 547)), 35, new String[]{"A", "B", "C", "D"}, LabelAxis.horizontal, new String[]{"B", "C", "A", "B", "B", "D", "D", "D", "B", "A", "D", "D", "A", "D", "D", "C", "B", "B", "D", "C", "B", "A", "C", "D", "A", "D", "D", "A", "C", "A", "B", "D", "C", "C", "C"}));
                    script.ShadedAreas.add(new QuestionShadedArea("186-200", new Rectangle(new Vector2(495, 561), new Vector2(555, 772)), 15, new String[]{"A", "B", "C", "D"}, LabelAxis.horizontal, new String[]{"A", "D", "C", "C", "B", "B", "D", "C", "C", "B", "B", "C", "C", "A", "B"}));
                    script.ShadedAreas.add(new DataShadedArea("Exam no", new Rectangle(new Vector2(57, 277), new Vector2(157, 417)), 7, new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"}, LabelAxis.vertical));

                    script.EvaluateShaded();
                    result.setTotalScore(script.TotalScore);
                    String examNumber = ((DataShadedArea) (script.getShadedAreas().get(8))).getData();
                    result.setExamNumber(examNumber);
                    result.setQuestionCount(script.ShadedAreas.get(0).getNumberOfOptions() + script.ShadedAreas.get(1).getNumberOfOptions() + script.ShadedAreas.get(2).getNumberOfOptions() + script.ShadedAreas.get(3).getNumberOfOptions() + script.ShadedAreas.get(4).getNumberOfOptions() + script.ShadedAreas.get(5).getNumberOfOptions() + script.ShadedAreas.get(6).getNumberOfOptions() + script.ShadedAreas.get(7).getNumberOfOptions());
                    System.out.println("Total score: " + script.TotalScore + "/" + (script.ShadedAreas.get(0).getNumberOfOptions() + script.ShadedAreas.get(1).getNumberOfOptions() + script.ShadedAreas.get(2).getNumberOfOptions() + script.ShadedAreas.get(3).getNumberOfOptions() + script.ShadedAreas.get(4).getNumberOfOptions() + script.ShadedAreas.get(5).getNumberOfOptions() + script.ShadedAreas.get(6).getNumberOfOptions() + script.ShadedAreas.get(7).getNumberOfOptions()));
                    System.out.println("Exam no: " + ((DataShadedArea) (script.ShadedAreas.get(8))).data);
//                    omrDetectionAlgo.display(script.BufferedImage);


                    System.out.println("Image loaded successfully: " + imagePath);
                }
            } catch (IOException e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        }
        return  result;

    }
    public static String[] shadeFinder(BufferedImage grayImage, int m, int n, int threshold, Rectangle rect, int rowNo, String[] label, LabelAxis labelAxis){

        if(rect.D.y >= grayImage.getHeight() && rect.D.x >= grayImage.getWidth()) return null;
        String[] output = new String[rowNo];

        for(int y = (int)rect.A.y ; y + n < rect.D.y; y++){
            for(int x = (int)rect.A.x; x + m < rect.D.x; x++){
                int ave = averagePixelValue(grayImage, m, n, x, y);

                // Area is shaded
                if (ave < threshold){
                    int rgb = 0;
                    rgb = (255<<24) | (255<<16);
                    SetPixels(grayImage, m, n, x, y, rgb);

                    switch (labelAxis) {
                        case horizontal:
                            // int outputIndex = (int)Lerp(rect.A.y, rect.D.y, y + n/2, 0, rowNo);
                            // int labelIndex = (int)Lerp(rect.A.x, rect.D.x, x + m/2, 0, label.length );
                            // System.out.println(outputIndex);

                            output[(int)MathFunctions.Lerp(rect.A.y, rect.D.y, y + n/2, 0, rowNo)] = label[(int)MathFunctions.Lerp(rect.A.x, rect.D.x, x + m/2, 0, label.length)];
                            break;

                        case vertical:
                            output[(int) MathFunctions.Lerp(rect.A.x, rect.D.x, x + m/2, 0, rowNo)] = label[(int)MathFunctions.Lerp(rect.A.y, rect.D.y, y + n/2, 0, label.length)];
                            break;
                    }
                    // System.out.println(ave);
                }
            }
        }

        // for(int i = 0; i < output.length;  i++)  System.out.println(output[i]);
        return output;
    }
    public static int averagePixelValue(BufferedImage img, int w, int h, int xpos, int ypos){
        int sum = 0;
        for (int j = ypos; j < ypos + h; j++) {
            for (int i = xpos; i < xpos + w; i++) {
                int redVal = ((int)img.getRGB(i, j) >> 16) & 0xFF;
                sum += redVal;
            }
        }
        return  sum/(w*h);
    }


    public static void SetPixels(BufferedImage img, int w, int h, int xpos, int ypos, int val){
        for (int j = ypos; j < ypos + h; j++) {
            for (int i = xpos; i < xpos + w; i++) {
                img.setRGB(i, j, val);
            }
        }
    }

}
