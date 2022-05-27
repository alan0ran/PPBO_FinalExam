/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package _123200072;

/**
 *
 * @author Alan
 */

import Controller.MovieControl;
import Model.MovieModel;
import View.MovieView;

public class Main {
    public static void main(String[] args) {
        MovieView movieView = new MovieView();
        MovieModel movieModel = new MovieModel();
        MovieControl movieController = new MovieControl(movieModel, movieView);
    } 
}
