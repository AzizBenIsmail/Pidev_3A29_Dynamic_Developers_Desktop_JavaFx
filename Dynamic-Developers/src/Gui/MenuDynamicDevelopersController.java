/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MenuDynamicDevelopersController implements Initializable {

    @FXML
    private ImageView ImageP;
    @FXML
    private Button Voyage;
    @FXML
    private Button ReserverVoyage;
    @FXML
    private Button Restaurant;
    @FXML
    private Button ReserverRestaurant;
    @FXML
    private Button Post;
    @FXML
    private Button Reclamation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Voyage(ActionEvent event) throws IOException {
 try {
/*
         Parent root = FXMLLoader.load(getClass().getResource("/Gui/Voyage.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
                      Destination.setVisible(true);
        arsignup.setVisible(false);
              stage.show();*/
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Voyage.fxml"));
            Parent root = loader.load();
            VoyageController pc = loader.getController();
            pc.setAdd();
            pc.setAddImage();
            pc.setCombox();
            pc.setDatev();
            pc.setDestination();
            pc.setDuree_Voyage();
            pc.setNom_Voyage();
            pc.setNomVoyagetext();
            pc.setModVoy();
            pc.setPrix();
            pc.StatV();
            pc.Nom_Voyage_Resrver(true);  
            pc.setSupprimerVoyage();
            pc.setURLImage();
            pc.setDestinationText();
            pc.setDureeVoyagetext();
            pc.setValabilitetext();
            pc.setPrixText();
            pc.setReserver(true);
            pc.setDateText();
            pc.setImagetext();
            pc.setReset();
            Voyage.getScene().setRoot(root);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @FXML
    private void ReserverVoyage(ActionEvent event) {
        try {

         Parent root = FXMLLoader.load(getClass().getResource("/Gui/Reservevoyage.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }


    @FXML
    private void ReserverRestaurant(ActionEvent event) throws IOException {
              Parent root = FXMLLoader.load(getClass().getResource("RestaurantReservation.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }


    @FXML
    private void Restaurant(ActionEvent event) throws IOException {
              Parent root = FXMLLoader.load(getClass().getResource("RestaurantC.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

    @FXML
    private void Post(ActionEvent event) throws IOException {
         Parent parent = FXMLLoader.load(getClass().getResource("/Gui/ShowPost.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                //stage.getIcons().add(new Image("/images/logo.png"));
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
    }

    @FXML
    private void Reclamation(ActionEvent event) throws IOException {
              Parent parent = FXMLLoader.load(getClass().getResource("/Gui/ShowReclamation.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                //stage.getIcons().add(new Image("/images/logo.png"));
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
    }
    }
    

