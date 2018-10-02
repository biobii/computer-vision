/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise01;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 *
 * @author biobii
 */
public class ImageProcessing {

    private BufferedImage image;
    private int width, height;
    
    private String imageFile;

    private int finalGreen = 0;
    private int finalBlue = 0;
    private int finalRed = 0;

    public void pixel() {
        try {
            imageFile = "/home/biobii/Pictures/demo.jpeg";

            File input = new File(imageFile);
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            int count = 0;
            System.out.println("PIXEL: " + width + " x " + height);
            
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    count++;
                    Color c = new Color(image.getRGB(j, i));
                    
                    // calculate original RGB
                    finalRed += c.getRed();
                    finalGreen += c.getGreen();
                    finalBlue += c.getBlue();

                    int red = (int) (c.getRed() * 0.299);
                    int green =(int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() *0.114);
                    int sum = red + green + blue;
                    
                    Color newColor = new Color(sum, sum, sum);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }

            // output grayscale convert
            File output = new File("/home/biobii/Pictures/grayscale.jpg");
            ImageIO.write(image, "jpg", output);
            
            System.out.println("\n===== ORIGINAL =====");
            System.out.println("Red: " + finalRed / count);
            System.out.println("Green: " + finalGreen / count);
            System.out.println("Blue: " + finalBlue / count);
            
            // processing grayscale image
            image = ImageIO.read(output);
            count = 0;
            finalRed = 0;
            finalGreen = 0;
            finalBlue = 0;
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    count++;
                    Color c = new Color(image.getRGB(j, i));
                    
                    // calculate original RGB
                    finalRed += c.getRed();
                    finalGreen += c.getGreen();
                    finalBlue += c.getBlue();
                }
            }
            
            System.out.println("\n===== GRAYSCALE =====");
            System.out.println("Grayscale image created in => /home/biobii/Pictures/grayscale.jpg");
//            System.out.println("Red: " + finalRed / count);
//            System.out.println("Green: " + finalGreen / count);
//            System.out.println("Blue: " + finalBlue / count);
            System.out.println("Grayscale: " + 
                    ((finalRed / count) + (finalGreen / count) + (finalBlue / count)) / 3);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ImageProcessing pxl = new ImageProcessing();
        pxl.pixel();
    }
}
