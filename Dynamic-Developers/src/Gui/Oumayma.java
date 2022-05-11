/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
 * @author Oumayma
 */
public class Oumayma extends Application {
    
   
    @Override
    public void start(Stage primaryStage) {
        try {
          //Parent root =FXMLLoader.load(getClass().getResource("ShowPost.fxml"));
            Parent root =FXMLLoader.load(getClass().getResource("FXMLReclamationback.fxml"));
           //Parent root =FXMLLoader.load(getClass().getResource("ShowReclamation.fxml"));
            //Parent root =FXMLLoader.load(getClass().getResource("FXMLPostback.fxml"));
            Scene scene = new Scene(root);
            primaryStage.getIcons().add(new Image("/image/logo.png"));
            primaryStage.setTitle("TRAVEL ME");
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
