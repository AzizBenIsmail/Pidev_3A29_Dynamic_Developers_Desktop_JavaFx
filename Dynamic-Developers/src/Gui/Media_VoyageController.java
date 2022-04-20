/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Media_VoyageController implements Initializable {

    @FXML
    private MediaView mediaview;
    @FXML
    private Slider volume;
    @FXML
    private Button play;
    @FXML
    private Button pause;
    @FXML
    private Button stop;
    private MediaPlayer mediaplayer;
    private Media media;
    public static String videoName;
    @FXML
    private Button Go_Back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
           String videoname = null;
           String path = new File("src/video/" + videoname + ".mp4").getAbsolutePath();
           File mediaFile = new File("C:\\Users\\ASUS\\Downloads\\Ciel et Nuages Zoom Virtuel Arrière-plan.mp4");
           Media media = new Media(mediaFile.toURI().toURL().toString());
            mediaplayer = new MediaPlayer(media);
            mediaview.setMediaPlayer(mediaplayer);
            volume.setValue(mediaplayer.getVolume() * 100);
            
             volume.valueProperty().addListener(new InvalidationListener() {
            

               @Override
               public void invalidated(Observable observable) {
                 mediaplayer.setVolume(volume.getValue() / 100);

               }

        });
      } catch (MalformedURLException ex) {
           System.out.println(ex.getMessage());
      }
    }    

    @FXML
    private void click(MouseEvent event) {
    }

    @FXML
    private void play(ActionEvent event) {
        mediaplayer.play();
    }

    @FXML
    private void pause(ActionEvent event) {
        mediaplayer.pause();
    }

    @FXML
    private void stop(ActionEvent event) {
        mediaplayer.seek(mediaplayer.getStartTime());
        mediaplayer.stop();
    }

    @FXML
    private void Go_Back_Home(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Voyage.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
    
}
