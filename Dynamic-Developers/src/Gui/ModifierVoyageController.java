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
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierVoyageController implements Initializable {

    @FXML
    private ImageView ImageP;
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
    private DatePicker Datev;
    @FXML
    private ImageView Image;
    
    public String imagecomp;

    @FXML
    private Button AddImage;
    @FXML
    private Button Modifier;
    @FXML
    private TextField ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      /*  ServiceVoyage vs = new ServiceVoyage();
        try {
            FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("Voyage.fxml"));
          Stage prStage = new Stage();
            Parent root= loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);
            VoyageController VC = loader.getController();
            int id = Integer.parseInt(VoyageController.idxx);
            System.out.println(id);
            Destination.setText(vs.getDestinationID(id));
            Duree_Voyage.setText(vs.getduree_voyageID(id));
            Nom_Voyage.setText(vs.getnomID(id));
            Valabilite.setText(vs.getvalabiliteID(id));
            Prix.setText(String.valueOf(vs.getprixID(id)));

        } catch (Exception e) {
                
        }*/
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

    @FXML
    private void Modifier(ActionEvent event) throws IOException {

        String Destinationv = Destination.getText();
        String Nom_Voyagev = Nom_Voyage.getText();
        String Duree_Voyagev = Duree_Voyage.getText();
        LocalDate date = LocalDate.now();    
        String Valabilitev = Valabilite.getText();
        String Prixv=Prix.getText();
        String IDv = ID.getText();

        voyage v = new voyage(Integer.parseInt(IDv),Destinationv,Nom_Voyagev,Duree_Voyagev,null,Valabilitev,voyage.filename,Float.parseFloat(Prixv));
            
        ServiceVoyage ps = new ServiceVoyage();
            
            ps.ModifierVoyage(v);
            
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

    public void setDestination(String valeur) {
        this.Destination.setText(valeur);
    }

    public void setDuree_Voyage(String valeur) {
        this.Duree_Voyage.setText(valeur);
    }

    public void setNom_Voyage(String valeur) {
        this.Nom_Voyage.setText(valeur);
    }

    public void setValabilite(String valeur) {
        this.Valabilite.setText(valeur);
    }

    public void setID(String valeur) {
        this.ID.setText(valeur);
    }

    public void setPrix(String valeur) {
        this.Prix.setText(valeur);
    }


}
