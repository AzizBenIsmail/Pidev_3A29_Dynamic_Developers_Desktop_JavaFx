/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.RestaurantReservation;
import Service.RestaurantReservationCrud;
import edu.connexion3a29.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class RestaurantReservationCController implements Initializable {

    @FXML
    private TextField nom_res1c;
    @FXML
    private TextField nom_c1c;
    @FXML
    private TextField nbr_pers1c;
    @FXML
    private DatePicker date_res1c;
    @FXML
    private Button btn_aj_reser;
    @FXML
    private Button btn_vider_reserc;
    @FXML
    private ImageView ImageP;
    @FXML
    private Button Menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        // TODO
    }    
     
   
            private boolean nom_resvalide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(nom_res1c.getText());
        if(m.find() && m.group().equals(nom_res1c.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez entrer un type validé !");
                alert.showAndWait();
           
            return false;            
        }
     }
               private boolean nom_cvalide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(nom_c1c.getText());
        if(m.find() && m.group().equals(nom_c1c.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez entrer un type validé !");
                alert.showAndWait();
           
            return false;            
        }
     }
       
                   private boolean nbr_persvalide(){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(nbr_pers1c.getText());
        if(m.find() && m.group().equals(nbr_pers1c.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez entrer un type validé !");
                alert.showAndWait();
           
            return false;            
        }
         
    }    

    @FXML
    private void ajouter_reser(ActionEvent event) throws IOException {
         RestaurantReservationCrud rc = new RestaurantReservationCrud();
             if(nom_resvalide()&& nom_cvalide()&& nbr_persvalide()){
        
        String var1=nom_res1c.getText();
        String var2=nom_c1c.getText();
        Date var3 = Date.valueOf(date_res1c.getValue());
        String var4=nbr_pers1c.getText();
        int var5=Integer.parseInt(var4);
        

       RestaurantReservation r =new RestaurantReservation();
        
      r.setNom_Restaurant(var1);
      r.setNom_Client(var2);
      r.setNbr_Personne(var5);
      r.setDate_Reservation(var3);        
      rc.ajouter_restaurantreservation(r);
      
      nom_res1c.clear();
      nom_c1c.clear();
      date_res1c.setValue(null);
      nbr_pers1c.clear();
              Parent root = FXMLLoader.load(getClass().getResource("RestaurantReservation.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
         Notifications notificationBuilder = Notifications.create()
                 .title("Information").text("Cher client votre réservation est ajoutée avec succès.").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                 .position(Pos.BASELINE_LEFT)
                 .onAction(new EventHandler<ActionEvent>() 
                 {
                        public void handle(ActionEvent Event)
                        {
                            System.out.println("clicked on");
                        }
                });
         notificationBuilder.darkStyle();
         notificationBuilder.show();
    }
    }

    @FXML
    private void vider_reserc(ActionEvent event) {
        nom_res1c.clear();
      nom_c1c.clear();
      date_res1c.setValue(null);
      nbr_pers1c.clear();
    }
        @FXML
    private void Menu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuDynamicDevelopers.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
