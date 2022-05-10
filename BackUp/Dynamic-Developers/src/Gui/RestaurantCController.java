/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Restaurant;
import edu.connexion3a29.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class RestaurantCController implements Initializable {

    @FXML
    private TableView<Restaurant> table_res;
    @FXML
    private TableColumn<Restaurant, String> nom_ressc;
    @FXML
    private TableColumn<Restaurant, String> adresse_ressc;
    @FXML
    private TableColumn<Restaurant, Integer> numt_ressc;
    @FXML
    private TableColumn<Restaurant, String> descp_ressc;
     public ObservableList<Restaurant> data=FXCollections.observableArrayList();
    @FXML
    private Button Reserver;
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
        show();
    }    
      public void show(){
          try {
            String requete="SELECT * FROM rest"; 
            Statement st = MyConnection.getinstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
               data.add(new Restaurant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                nom_ressc.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("Nom_Restaurant")); 
                adresse_ressc.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("Adresse_Restaurant")); 
                numt_ressc.setCellValueFactory(new PropertyValueFactory<Restaurant,Integer>("Num_Tel_Restaurant"));
                descp_ressc.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("Description_Restaurant"));
                 table_res.setItems(data);
    }

    @FXML
    private void Reserver(ActionEvent event) throws IOException {
                      Parent root = FXMLLoader.load(getClass().getResource("RestaurantReservationC.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
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


