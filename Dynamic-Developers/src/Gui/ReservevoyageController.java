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
import java.lang.AutoCloseable;

import Service.ServiseReserVoy;
import Util.MyDB;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReservevoyageController implements Initializable {

    ObservableList<ReserverVoyage>  List = FXCollections.observableArrayList();
    
    @FXML
    private ImageView ImageP;
    @FXML
    private TableView<ReserverVoyage> TableVoyage;
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
    private ComboBox<String> Travel_ComboBox;
    @FXML
    private TextField Recherche;
    @FXML
    private ComboBox<String> VoyageCombox;
    @FXML
    private Button Clear;
 String query = null;
    Connection connection = null ;
    Connection cnx=MyDB.getInsatnce().getConnection();
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    @FXML
    private TableColumn<ReserverVoyage, String> Dest;
    @FXML
    private TableColumn<ReserverVoyage, Date> date;
    @FXML
    private TableColumn<ReserverVoyage, String> Rage;
    @FXML
    private TableColumn<ReserverVoyage, Integer> VID;
    @FXML
    private TableColumn<ReserverVoyage, String> Tra_class;
    @FXML
    private Button Menu;
    @FXML
    private Button Menu1;
    @FXML
    private Button Menu11;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("first class","economic Class","business class");
        Travel_ComboBox.setItems(list);
        loadvoy();
        refresh();
    }    
    
 private void refresh() {
        try {
            List.clear();
            
        String query ="select reservation_voyage.id,voyage.nom_voyage ,reservation_voyage.travel_class,reservation_voyage.date_reservation, reservation_voyage.age from reservation_voyage INNER JOIN voyage on reservation_voyage.voyage_id =voyage.id ";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
              List.add(new  ReserverVoyage(
                        resultSet.getInt("id"),
                        resultSet.getString("nom_voyage"),
                        resultSet.getDate("date_reservation"),
                        resultSet.getString("travel_class"),
                        resultSet.getInt("age")
                        )); 
               TableVoyage.setItems(List);
            }
        } catch (SQLException ex) {
    System.err.println("SQLException: " + ex.getMessage());
    System.err.println("SQLState: " + ex.getSQLState());
    System.err.println("VendorError: " + ex.getErrorCode()); 
        }      
    }

        private void loadvoy() {

            ServiseReserVoy v=new ServiseReserVoy();
            connection= MyDB.getInsatnce().getConnection();
            refresh();
            VID.setCellValueFactory(new PropertyValueFactory<>("id"));
            Dest.setCellValueFactory(new PropertyValueFactory<>("nom_voyage"));
            date.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
            Tra_class.setCellValueFactory(new PropertyValueFactory<>("travel_Class"));
            Rage.setCellValueFactory(new PropertyValueFactory<>("age"));
            VoyageCombox.setItems(FXCollections.observableArrayList(v.getAll()));
            System.out.println(Tra_class.getText());

        }
    @FXML
    private void SupprimerVoyage(ActionEvent event) {
                 if (!TableVoyage.getSelectionModel().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sur de vouloir supprimer la reservation du " + TableVoyage.getSelectionModel().getSelectedItem().getNom_voyage()+ " ?", ButtonType.YES, ButtonType.NO);
alert.showAndWait();

if (alert.getResult() == ButtonType.YES) {
    ServiseReserVoy r=new ServiseReserVoy();
    r.SupprimerReserverVoyage(TableVoyage.getSelectionModel().getSelectedItem().getId());
    };
    refresh();
    }
    }
        
    @FXML
    private void Liste_Voyage(MouseEvent event) {
         try {
               ReserverVoyage Res = TableVoyage.getSelectionModel().getSelectedItem();
               Dest.setText(Res.getNom_voyage());
               Age.setText(String.valueOf(Res.getAge()));
               String c =  Res.getNom_voyage();
               VoyageCombox.setValue(c);
               String B =  Res.getTravel_Class();
               Travel_ComboBox.setValue(B);
           } catch (Exception e) {
               System.out.println(e.getMessage());
               
           }
    }
    @FXML
    private void Add(ActionEvent event) {
        try {
            connection= MyDB.getInsatnce().getConnection();
            String Dest = (String)VoyageCombox.getValue();
            String Tra = (String)Travel_ComboBox.getValue();
            java.sql.Date date = java.sql.Date.valueOf(Datev.getValue());
            String Ag =Age.getText();
            ServiseReserVoy rec = new ServiseReserVoy();
            int IdVoy= rec.chercherVoy(Dest);

            Scontrole_Voyage sc= new Scontrole_Voyage();
//            int Age =Integer.valueOf(Rage.getText());
if( Tra.isEmpty()){
    Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
    alert.setContentText("Travel class vides");   
    alert.showAndWait();
    
}else
    if( Dest.isEmpty()){
    Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
    alert.setContentText("Travel class vides");   
    alert.showAndWait();  
} else if (! sc.isNumeric(Age.getText())){
    Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
    alert.setContentText("Age doit étre un nombre");
    alert.showAndWait();
}
else {
    int A=Integer.parseInt(Ag);
    ReserverVoyage re = new ReserverVoyage(IdVoy,Tra,date,A);
    System.out.println(re.toString());
    rec.AjouterReserverVoyage(re);
    refresh();
    Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
    alert.setContentText("Reservation ajouter");
    alert.showAndWait();
}
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
}      

    @FXML
    private void ModVoy(ActionEvent event) {

    }

    @FXML
    private void Recherche(KeyEvent event) {
    }

    @FXML
    private void Clear(ActionEvent event) {
    }
        @FXML
    private void Actualiser(ActionEvent event) {
        loadvoy();
        refresh();
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
