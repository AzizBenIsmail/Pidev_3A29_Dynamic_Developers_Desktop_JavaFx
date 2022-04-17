/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.voyage;
import static Entity.voyage.filename;
import Service.ServiceVoyage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    @FXML
    private Button Retour;
    @FXML
    private TextField URLImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouter(ActionEvent event) {
  
        String Destinationv = Destination.getText();
        String Nom_Voyagev = Nom_Voyage.getText();
        String Duree_Voyagev = Duree_Voyage.getText();
        Date Datevoy= Date.valueOf(Datev.getValue());
        String Valabilitev = Valabilite.getText();
        String Prixv=Prix.getText();
        System.out.println(Datevoy);

        voyage v = new voyage(Destinationv,Nom_Voyagev,Duree_Voyagev,Datevoy,Valabilitev,voyage.filename,Float.parseFloat(Prixv));
            
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
    private void AddImage(ActionEvent event) throws FileNotFoundException, IOException {
    Random rand = new Random();
        int x = rand.nextInt(1000);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", ".png", ".jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(null);
        String DBPath = "C:\\\\xampp\\\\htdocs\\\\Image-Java"  + x + ".jpg";
        if (file != null) {
            FileInputStream Fsource = new FileInputStream(file.getAbsolutePath());
            FileOutputStream Fdestination = new FileOutputStream(DBPath);
            BufferedInputStream bin = new BufferedInputStream(Fsource);
            BufferedOutputStream bou = new BufferedOutputStream(Fdestination);
            System.out.println(file.getAbsoluteFile());
            String path=file.getAbsolutePath();
            Image img = new Image(file.toURI().toString());
            Image.setImage(img);
           /* File File1 = new File(DBPath);
            Image img = new Image(File1.getAbsolutePath());
            image_event.setImage(img);*/
            URLImage.setText(DBPath);
            int b = 0;
            while (b != -1) {
                b = bin.read();
                bou.write(b);
            }
            bin.close();
            bou.close();
            
        } else {
            System.out.println("error");

        }
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
                         Parent root = FXMLLoader.load(getClass().getResource("Voyage.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
    
}
