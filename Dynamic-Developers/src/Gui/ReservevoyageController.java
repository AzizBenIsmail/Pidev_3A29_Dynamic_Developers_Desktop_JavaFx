/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReservevoyageController implements Initializable {

    @FXML
    private ImageView ImageP;
    @FXML
    private TableView<?> TableVoyage;
    @FXML
    private TableColumn<?, ?> VID;
    @FXML
    private TableColumn<?, ?> VDest;
    @FXML
    private TableColumn<?, ?> Vdate;
    @FXML
    private TableColumn<?, ?> VValibilite;
    @FXML
    private TableColumn<?, ?> Vimage;
    @FXML
    private Button Supprimerreservation;
    @FXML
    private Button Actualiser;
    @FXML
    private Button Add;
    @FXML
    private TextField Age;
    @FXML
    private DatePicker Datev;
    @FXML
    private Button Modreservation;
    @FXML
    private ComboBox<?> Travel_Class;
    @FXML
    private TextField Recherche;
    @FXML
    private ComboBox<?> VoyageCombox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Liste_Voyage(MouseEvent event) {
    }

    @FXML
    private void SupprimerVoyage(ActionEvent event) {
    }

    @FXML
    private void Actualiser(ActionEvent event) {
    }

    @FXML
    private void Add(ActionEvent event) {
    }

    @FXML
    private void ModVoy(ActionEvent event) {
    }

    @FXML
    private void Recherche(KeyEvent event) {
    }
    
}
