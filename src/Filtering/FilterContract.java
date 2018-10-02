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
public interface FilterContract {
    public void filter(File image);
    public void output();
}
