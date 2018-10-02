/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtering;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author biobii
 */
public class Batas extends Neighbor implements FilterContract {

    private String context = "batas";
    private BufferedImage image;
    private int width, height;

    public void filter(File file) {
        try {
            image = ImageIO.read(file);
            width = image.getWidth();
            height = image.getHeight();

            for (int row = 0; row < width; row++) {
                for (int col = 0; col < height; col++) {
                    int red = this.redProcess(context, image, row, col, width, height);
                    int green = this.greenProcess(context, image, row, col, width, height);
                    int blue = this.blueProcess(context, image, row, col, width, height);
                    
                    image.setRGB(row, col, new Color(red, green, blue).getRGB());
                }
            }

            this.output();
        } catch (Exception e) {
            System.out.println("Error:\t" + e.getMessage());
        }
    }

    public void output() {
        try {
            File output = new File("/home/biobii/Pictures/batas.jpg");
            ImageIO.write(image, "jpg", output);

            System.out.println("Filter Batas outputed!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
