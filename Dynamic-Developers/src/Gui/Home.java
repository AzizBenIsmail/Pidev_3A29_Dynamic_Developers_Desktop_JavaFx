/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class Home extends Application {
    
   
    @Override
    public void start(Stage primaryStage) {
        try {
      //  Parent root =FXMLLoader.load(getClass().getResource("MenuDynamicDevelopers.fxml"));
        Parent root =FXMLLoader.load(getClass().getResource("Back.fxml"));

            Scene scene = new Scene(root);
            primaryStage.getIcons().add(new Image("/image/logo.png"));
            primaryStage.setTitle("TRAVEL ME");
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
