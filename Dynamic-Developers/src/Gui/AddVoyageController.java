/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.voyage;
import static Entity.voyage.filename;
import Service.ServiceVoyage;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.time.LocalDate;    
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddVoyageController implements Initializable {

    @FXML
    private ImageView ImageP;
    @FXML
    private Button Ajouer;
    @FXML
    private TextField Destination;
    @FXML
    private TextField Duree_Voyage;
    @FXML
    private TextField Nom_Voyage;
    @FXML
    private TextField Valabilite;
    @FXML
    private TextField Prix;
    @FXML
    private ImageView Image;
    @FXML
    private Button AddImage;

    public String imagecomp;
    @FXML
    private DatePicker Datev;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouter(ActionEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date myDate = Date.valueOf(Datev.getValue().toString());
        String Destinationv = Destination.getText();
        String Nom_Voyagev = Nom_Voyage.getText();
        String Duree_Voyagev = Duree_Voyage.getText();
        LocalDate date = LocalDate.now();    
        String Valabilitev = Valabilite.getText();
        String Prixv=Prix.getText();
        
        voyage v = new voyage(Destinationv,Nom_Voyagev,Duree_Voyagev,myDate,Valabilitev,voyage.filename,Float.parseFloat(Prixv));
            
        ServiceVoyage ps = new ServiceVoyage();
            
            ps.AjouterVoyage(v);
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Voyage.fxml"));
            try {
                            Parent root = loader.load();
           VoyageController ac = loader.getController();
                Destination.getScene().setRoot(root);
           Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
        alert.setHeaderText(null);
        alert.setContentText("!!!succes !!!");
        alert.showAndWait();

        } catch (Exception e) {
System.out.println(e.getMessage());
            System.out.println(e.getMessage());
              Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.show();
                System.err.println(e.getMessage());
        }
           
    }
    @FXML
    private void AddImage(ActionEvent event) {
        FileChooser f = new FileChooser();
        String img;

        File fc = f.showOpenDialog(null);
        if (f != null) {
            //System.out.println(fc.getName());
            img = fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            Image.setImage(i);
            imagecomp = fc.toString();
            System.out.println(imagecomp);
            int index = imagecomp.lastIndexOf('\\');
            if (index > 0) {
                filename = imagecomp.substring(index + 1);
            }

           voyage.filename = "C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\Dynamic-Developers\\src\\Img" + filename;
            //se.sendphp(fc.getAbsolutePath());
        }
        Image.setFitHeight(65);
        Image.setFitWidth(95);
        //..\img\google.png

        //C:\Users\splin\Documents\NetBeansProjects\FanArt\\com\esprit\img
        voyage.pathfile = fc.getAbsolutePath();
    }
    
}
