/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.voyage;
import static Entity.voyage.filename;
import Service.Scontrole_Voyage;
import Service.ServiceVoyage;
import Util.MyDB;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class VoyageController implements Initializable {

    @FXML
    private ImageView ImageP;
    private TextField Voyage;
    @FXML
    private TableColumn<voyage,String> VDest;
    @FXML
    private TableColumn<voyage,String> VNom;
    @FXML
    private TableColumn<voyage,String> VDuree;
    @FXML
    private TableColumn<voyage,Date> Vdate;
    @FXML
    private TableColumn<voyage,String> VValibilite;
    @FXML
    private TableColumn<voyage,ImageView> Vimage;
    @FXML
    private TableColumn<voyage,Float> Vprix;
    @FXML
    private TableView<voyage> TableVoyage;
    @FXML
    private Button SupprimerVoyage;
    @FXML
    private Button Actualiser;
    @FXML
    private TableColumn<voyage,Integer> VID;
    @FXML
    private Button Bientot_disponible;
    @FXML
    private Button Disponible;
    @FXML
    private Button Non_Disponible;
    
    public static String idxx;
    @FXML
    private Button Modifier;
    @FXML
    private Button Ajouter;
    
    voyage ss=new voyage();
    
    private Statement ste;
    private voyage v;
    String query = null;
    Connection connection = null ;
    Connection cnx=MyDB.getInsatnce().getConnection();
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    voyage VOY = null ;
    
ObservableList<voyage>  List = FXCollections.observableArrayList();
    @FXML
    private ImageView Image;
    @FXML
    private TextField Destination;
    @FXML
    private TextField Duree_Voyage;
    @FXML
    private TextField Nom_Voyage;
    @FXML
    private TextField Prix;
    @FXML
    private DatePicker Datev;
    @FXML
    private Button AddImage;
    @FXML
    private TextField URLImage;
    @FXML
    private Button Add;
    @FXML
    private Button ModVoy;
    @FXML
    private ComboBox<String> combox;
    @FXML
    private TextField Recherche;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("Disponible","Non Disponible","Bientot Disponible");
        combox.setItems(list);
        loadvoy();
        refresh();

};

    @FXML
    private void Liste_Voyage(javafx.scene.input.MouseEvent event) {
      
          try {
               voyage voy = TableVoyage.getSelectionModel().getSelectedItem();
               Destination.setText(voy.getDestination());
               Nom_Voyage.setText(voy.getNom_voyage());
               Duree_Voyage.setText(voy.getDuree_voyage());
              // java.sql.Date date = java.sql.Date.valueOf(Datev.getValue());
              // Datev.set(voy.getDate());
               String c =  voy.getValabilite();
                 combox.setValue(c);
               Prix.setText(String.valueOf(voy.getPrix()));               
               String path = voy.getImage();
               File file=new File(path);
              Image img = new Image(file.toURI().toString());
                Image.setImage(img);
           } catch (Exception e) {
               System.out.println(e.getMessage());
               
           }
    }
    public void delete()
    {
        ServiceVoyage SV = new ServiceVoyage();
       SV.SupprimerVoyage(TableVoyage.getSelectionModel().getSelectedItem().getID());
        System.out.println(TableVoyage.getSelectionModel().getSelectedItem().getID());
    }
    @FXML
    private void SupprimerVoyage(ActionEvent event) {
        delete();
        TableVoyage.getItems().removeAll(TableVoyage.getSelectionModel().getSelectedItem());
        System.out.println(TableVoyage);
        TableVoyage.refresh();
    }
    
    @FXML
    private void Actualiser(ActionEvent event) {
        loadvoy();
        refresh();
        }

    @FXML
    private void Bientot_disponible(ActionEvent event) {
 try {
            List.clear();
            
            query = "select * from voyage WHERE valabilite = 'Bientot Disponible'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                List.add(new  voyage(
                        resultSet.getInt("id"),
                        resultSet.getString("destination"),
                        resultSet.getString("nom_voyage"),
                        resultSet.getString("duree_voyage"),
                        resultSet.getDate("date"),
                        resultSet.getString("valabilite"),
                        resultSet.getString("image"),
                        resultSet.getFloat("prix")
                        )); 
               TableVoyage.setItems(List);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Disponible(ActionEvent event) {
                 try {
            List.clear();
            
            query = "select * from voyage WHERE valabilite = 'Disponible'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                List.add(new  voyage(
                        resultSet.getInt("id"),
                        resultSet.getString("destination"),
                        resultSet.getString("nom_voyage"),
                        resultSet.getString("duree_voyage"),
                        resultSet.getDate("date"),
                        resultSet.getString("valabilite"),
                        resultSet.getString("image"),
                        resultSet.getFloat("prix")
                        )); 
               TableVoyage.setItems(List);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Non_Disponible(ActionEvent event) {
       try {
            List.clear();
            
            query = "select * from voyage WHERE valabilite = 'Non Disponible'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                List.add(new  voyage(
                        resultSet.getInt("id"),
                        resultSet.getString("destination"),
                        resultSet.getString("nom_voyage"),
                        resultSet.getString("duree_voyage"),
                        resultSet.getDate("date"),
                        resultSet.getString("valabilite"),
                        resultSet.getString("image"),
                        resultSet.getFloat("prix")
                        )); 
               TableVoyage.setItems(List);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

  
    private void refresh() {
        try {
            List.clear();
            
            query = "select * from voyage";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                List.add(new  voyage(
                        resultSet.getInt("id"),
                        resultSet.getString("destination"),
                        resultSet.getString("nom_voyage"),
                        resultSet.getString("duree_voyage"),
                        resultSet.getDate("date"),
                        resultSet.getString("valabilite"),
                        resultSet.getString("image"),
                        resultSet.getFloat("prix")
                        )); 
                TableVoyage.setItems(List);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    private void clear() {

        VDest.setText(null);
        VNom.setText(null);
        VDuree.setText(null);
        Vdate.setText(null);
        VValibilite.setText(null);
        Vimage.setText(null);
        Vprix.setText(null);       
  
    }
    private void loadvoy() {
    voyage v=new voyage();
    connection= MyDB.getInsatnce().getConnection();
           VID.setCellValueFactory(new PropertyValueFactory<>("id"));
        VDest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        VNom.setCellValueFactory(new PropertyValueFactory<>("nom_voyage"));
        VDuree.setCellValueFactory(new PropertyValueFactory<>("duree_voyage"));
        Vdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        VValibilite.setCellValueFactory(new PropertyValueFactory<>("valabilite"));
        Vimage.setCellValueFactory(new PropertyValueFactory<>("image"));
        Vprix.setCellValueFactory(new PropertyValueFactory<>("prix"));    
    }

    @FXML
    private void AddImage(ActionEvent event) throws FileNotFoundException, IOException {
        Random rand = new Random();
        int x = rand.nextInt(1000);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        String DBPath = "C:\\xampp\\htdocs\\Version-Integre\\public\\uploads\\"  + x + ".jpg";
        if (file != null) {
            FileInputStream Fsource = new FileInputStream(file.getAbsolutePath());
            FileOutputStream Fdestination = new FileOutputStream(DBPath);
            BufferedInputStream bin = new BufferedInputStream(Fsource);
            BufferedOutputStream bou = new BufferedOutputStream(Fdestination);
            System.out.println(file.getAbsoluteFile());
            String path=file.getAbsolutePath();
            Image img = new Image(file.toURI().toString());
            Image.setImage(img);
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
    private void Add(ActionEvent event) {
        
        String Destinationv = Destination.getText();
        String Nom_Voyagev = Nom_Voyage.getText();
        String Duree_Voyagev = Duree_Voyage.getText();
        //Date Datevoy= Date.valueOf(Datev.getValue());
        String Valabilitev = (String)combox.getValue();
        java.sql.Date date = java.sql.Date.valueOf(Datev.getValue());
        String Prixv=Prix.getText();
        System.out.println(date);
        Scontrole_Voyage sc= new Scontrole_Voyage();   
        ServiceVoyage ps = new ServiceVoyage();

        voyage v = new voyage(Destinationv,Nom_Voyagev,Duree_Voyagev,date,Valabilitev,URLImage.getText(),Float.parseFloat(Prixv));
        
        System.out.println(sc.isNumeric(Prixv));

        if( Destinationv.isEmpty()){           
            Alert alert =new Alert(Alert.AlertType.CONFIRMATION);            
            alert.setContentText("champs vides");
            alert.setTitle("Prolem");
        alert.setHeaderText(null);
            alert.showAndWait(); 
       } else if (sc.isNumeric(Prix.getText())){
          Alert alert =new Alert(Alert.AlertType.CONFIRMATION);            
            alert.setContentText("Age doit étre un nombre");
            alert.showAndWait();   
        }
        else {
            ps.AjouterVoyage(v);
             refresh();
             Alert alert =new Alert(Alert.AlertType.CONFIRMATION);   
             alert.setTitle("succes");
             alert.setHeaderText(null);
            alert.setContentText("Voyage ajouter");
            alert.showAndWait();
        }}                 

    @FXML
    private void ModVoy(ActionEvent event) {
        voyage voy=new voyage();
   ServiceVoyage sv = new ServiceVoyage();
   voy=TableVoyage.getSelectionModel().getSelectedItem();
   voy.setID(TableVoyage.getSelectionModel().getSelectedItem().getID());   
   voy.setDestination(Destination.getText());
   voy.setNom_voyage(Nom_Voyage.getText());
   voy.setDuree_voyage(Duree_Voyage.getText());
           java.sql.Date date = java.sql.Date.valueOf(Datev.getValue());
   voy.setDate(date);
   String Valabilite = (String)combox.getValue();
   voy.setValabilite(Valabilite);
   voy.setImage(URLImage.getText());
   voy.setPrix(Float.parseFloat(Prix.getText()));
  
   sv.ModifierVoyage(voy);
   loadvoy(); 
   refresh();
    }
 
    @FXML
    private void Recherche(KeyEvent event) {
        
        ServiceVoyage bs=new ServiceVoyage(); 
        voyage b= new voyage();
        ObservableList<voyage>filter= bs.chercherTitreplat(Recherche.getText());
        populateTable(filter);
    }
     private void populateTable(ObservableList<voyage> branlist){
       TableVoyage.setItems(branlist);
   
       }
    }
