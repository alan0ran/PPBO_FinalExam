/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Alan
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import Model.MovieModel;
import View.MovieView;

public class MovieControl {
    MovieModel movieModel;
    MovieView movieView;
    Object header[] = {"Title", "Plot", "Character", "Acting","Score"};

    public MovieControl(MovieModel movieModel, MovieView movieView) {
        this.movieModel = movieModel;
        this.movieView = movieView;
        
        if (movieModel.getMovieData()!=0) {
            String dataMovie[][] = movieModel.readMovie();
            movieView.table.setModel((new JTable(dataMovie, header)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "No Data");
        }
        
        movieView.btnAdd.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String title = movieView.getJudul();
                String plot = movieView.getAlur();
                String character = movieView.getPenokohan();
                String acting = movieView.getAkting();
                movieModel.insertMovie(title, plot, character, acting);
                String dataMovie[][] = movieModel.readMovie();
                movieView.table.setModel((new JTable(dataMovie, header)).getModel());
            }
        });
        
        movieView.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String title = movieView.getJudul();
                String plot = movieView.getAlur();
                String character = movieView.getPenokohan();
                String acting = movieView.getAkting();
                movieModel.updateMovie(title, plot, character, acting);
                String dataMovie[][] = movieModel.readMovie();
                movieView.table.setModel((new JTable(dataMovie, header)).getModel());
            }
        });
        
        movieView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String title = movieView.getJudul();
                
                movieModel.deleteMovie(title);
                String dataMovie[][] = movieModel.readMovie();
                movieView.table.setModel((new JTable(dataMovie, header)).getModel());
            }
        });
        
        movieView.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                movieView.setJudul();
                movieView.setAlur();
                movieView.setPenokohan();
                movieView.setAkting();
            }
        });
    }  
}