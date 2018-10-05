/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtering;

import java.io.File;

/**
 *
 * @author biobii
 */
public class App {
    public static void main(String[] args) {
        String file = "/home/biobii/Pictures/bintik.png";
        File targetImage = new File(file);
        
        Median median = new Median();
        median.filter(targetImage);
        
        Mean mean = new Mean();
        mean.filter(targetImage);
        
        Batas batas = new Batas();
        batas.filter(targetImage);
    }
}
