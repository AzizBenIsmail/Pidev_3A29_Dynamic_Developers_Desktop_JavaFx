/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.ReserverVoyage;
import Entity.voyage;
import Service.Scontrole_Voyage;
import Service.ServiceVoyage;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReserverVoyageController implements Initializable {

    @FXML
    private ImageView ImageP;
    @FXML
    private TableView<ReserverVoyage> Tabelreservation;
    @FXML
    private TableColumn<ReserverVoyage,String> Voyage;
    @FXML
    private TableColumn<ReserverVoyage,Date> Date;
    @FXML
    private TableColumn<ReserverVoyage,Integer> Age;
    @FXML
    private Button Add;
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    @FXML
    private TextField age;
    @FXML
    private ComboBox<?> Trravel_class;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Add(ActionEvent event) {
          /* String Destinationv = Destination.getText();
        String Nom_Voyagev = Nom_Voyage.getText();
        String Duree_Voyagev = Duree_Voyage.getText();
        Date Datevoy= Date.valueOf(Datev.getValue());
      //  String Valabilitev = Valabilite.getText();
         String Valabilitev = (String)combox.getValue();

        String agev=age.getText();
        System.out.println(Datevoy);
        Scontrole_Voyage sc= new Scontrole_Voyage();   
        ServiceVoyage ps = new ServiceVoyage();

        voyage v = new voyage(Destinationv,Nom_Voyagev,Duree_Voyagev,Datevoy,Valabilitev,URLImage.getText(),Float.parseFloat(Prixv));
        
        System.out.println(sc.isNumeric(Prixv));

        if( Destinationv.isEmpty()){           
            Alert alert =new Alert(Alert.AlertType.CONFIRMATION);            
            alert.setContentText("champs vides");
            alert.showAndWait();
        }else if (! sc.isNumeric(Prix.getText())){
          Alert alert =new Alert(Alert.AlertType.CONFIRMATION);            
            alert.setContentText("Prixv doit étre un nombre");
            alert.showAndWait();   
        } 
        else {
            ps.AjouterVoyage(v);
             refresh();
             Alert alert =new Alert(Alert.AlertType.CONFIRMATION);            
            alert.setContentText("Voyage ajouter");
            alert.showAndWait();
        }*/
    }

    @FXML
    private void Modifier(ActionEvent event) {
    }

    @FXML
    private void Supprimer(ActionEvent event) {
    }
    
}
