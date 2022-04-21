/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a29.gui;

import edu.connexion3a29.entities.RestaurantReservation;
import edu.connexion3a29.services.RestaurantReservationCrud;
import edu.connexion3a29.utils.MyConnection;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class RestaurantReservationController implements Initializable {

    @FXML
    private TextField nom_res1;
    @FXML
    private TextField nom_c1;
    @FXML
    private TextField nbr_pers1;
    @FXML
    private DatePicker date_res1;
    @FXML
    private Button btn_aj_reser;
    @FXML
    private Button btn_supp_reser;
    @FXML
    private Button btn_mod_reser;
    @FXML
    private Button btn_vider_reser;
    @FXML
    private TableView<RestaurantReservation> table_reser;
    @FXML
    private TableColumn< RestaurantReservation,  String> nom_ress1;
    @FXML
    private TableColumn< RestaurantReservation,  String> nom_cc1;
    @FXML
    private TableColumn< RestaurantReservation, Integer> nbr_perss1;
    @FXML
    private TableColumn< RestaurantReservation, Date> date_ress1;
    public ObservableList<RestaurantReservation> data=FXCollections.observableArrayList();
   int index=-1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
        // TODO
    }    
     ObservableList< RestaurantReservation> Restaurant ;
     MyConnection cnx = null;
     Statement st = null;
      RestaurantReservationCrud  rcd = new  RestaurantReservationCrud ();
     public void updateTable_r(){
        Restaurant= rcd.listerRestaurantReservations();
        table_reser.getItems().setAll(Restaurant);
    }
            private boolean nom_resvalide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(nom_res1.getText());
        if(m.find() && m.group().equals(nom_res1.getText())){
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
        Matcher m = p.matcher(nom_c1.getText());
        if(m.find() && m.group().equals(nom_c1.getText())){
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
        Matcher m = p.matcher(nbr_pers1.getText());
        if(m.find() && m.group().equals(nbr_pers1.getText())){
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
    private void ajouter_reser(ActionEvent event) {
          RestaurantReservationCrud rc = new RestaurantReservationCrud();
             if(nom_resvalide()&& nom_cvalide()&& nbr_persvalide()){
        
        String var1=nom_res1.getText();
        String var2=nom_c1.getText();
        Date var3 = Date.valueOf(date_res1.getValue());
        String var4=nbr_pers1.getText();
        int var5=Integer.parseInt(var4);
        

       RestaurantReservation r =new RestaurantReservation();
        
      r.setNom_Restaurant(var1);
      r.setNom_Client(var2);
      r.setNbr_Personne(var5);
      r.setDate_Reservation(var3);        
      rc.ajouter_restaurantreservation(r);
       updateTable_r();
      nom_res1.clear();
      nom_c1.clear();
      date_res1.setValue(null);
      nbr_pers1.clear();
    }
             }

    @FXML
    private void supprimer_reser(ActionEvent event) {
        RestaurantReservationCrud  rcd = new  RestaurantReservationCrud ();
           RestaurantReservation R= new RestaurantReservation();   
              R= table_reser.getSelectionModel().getSelectedItem();
              rcd.supprimer_RestaurantReservation(R);
              updateTable_r();
    }
    

    @FXML
    private void modifier_reser(ActionEvent event) {
                        if(nom_resvalide()&& nom_cvalide()&& nbr_persvalide()){  
       RestaurantReservationCrud rc = new RestaurantReservationCrud();
        String var1=nom_res1.getText();
        String var2=nom_c1.getText();
        String var4=nbr_pers1.getText();
        Date var3 = Date.valueOf(date_res1.getValue());
        int var5=Integer.parseInt(var4);
       RestaurantReservation r =new RestaurantReservation();
         r.setNom_Restaurant(var1);
      r.setNom_Client(var2);
      r.setNbr_Personne(var5);
      r.setDate_Reservation(var3);  
        r=table_reser.getSelectionModel().getSelectedItem();
        rc.modifier_RestaurantReservation(r,var1,var2,var5,var3);
        updateTable_r();
      nom_res1.clear();
      nom_c1.clear();
      date_res1.setValue(null);
      nbr_pers1.clear();
    }
    }

    @FXML
    private void vider_reser(ActionEvent event) {
      nom_res1.clear();
      nom_c1.clear();
      date_res1.setValue(null);
      nbr_pers1.clear();
    }

    @FXML
    private void getSelected(MouseEvent event) {
           index=table_reser.getSelectionModel().getSelectedIndex();
         if(index<=-1){
         return ;
     }
     nom_res1.setText(nom_ress1.getCellData(index).toString());
     nom_c1.setText(nom_cc1.getCellData(index).toString());
     nbr_pers1.setText(nbr_perss1.getCellData(index).toString());
     date_res1.setValue(date_ress1.getCellData(index).toLocalDate());
    }
     
        public void show(){
          try {
            String requete="SELECT * FROM restaurantsreservations"; 
            Statement st = MyConnection.getinstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
              data.add(new RestaurantReservation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                 
                 nom_ress1.setCellValueFactory(new PropertyValueFactory<RestaurantReservation,String>("Nom_Restaurant")); 
                 nom_cc1.setCellValueFactory(new PropertyValueFactory<RestaurantReservation,String>("nom_Client"));
                 nbr_perss1.setCellValueFactory(new PropertyValueFactory<RestaurantReservation,Integer>("Nbr_Personne"));
                 date_ress1.setCellValueFactory(new PropertyValueFactory<RestaurantReservation,Date>("Date_Reservation"));
                 table_reser.setItems(data);
      }
    
}
