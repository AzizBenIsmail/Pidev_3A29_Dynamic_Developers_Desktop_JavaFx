/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Restaurant;
import Service.RestaurantCrud;
import edu.connexion3a29.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class RestaurantController implements Initializable {

    @FXML
    private TextField nom_res;
    private TextField adresse_res;
    @FXML
    private TextField numt_res;
    @FXML
    private TextField descp_res;
    @FXML
    private Button btn_aj_res;
    @FXML
    private Button btn_supp_res;
    @FXML
    private Button btn_mod_res;
    @FXML
    private Button btn_vi_res;
    @FXML
    private TableView<Restaurant> table_res;
    @FXML
    private TableColumn<Restaurant, String> nom_ress;
    @FXML
    private TableColumn<Restaurant, String> adresse_ress;
    @FXML
    private TableColumn<Restaurant, Integer> numt_ress;
    @FXML
    private TableColumn<Restaurant, String> descp_ress;
    
     public ObservableList<Restaurant> data=FXCollections.observableArrayList();
      @FXML
    private Button btnGoToMp;
     int index=-1;
    @FXML
    private Label label;
    @FXML
    private ImageView ImageP;
    @FXML
    private Button Menu;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
        // TODO
    }    
   ObservableList<Restaurant> Restaurant ;
     MyConnection cnx = null;
     Statement st = null;
     RestaurantCrud  rcd = new RestaurantCrud ();
     public void updateTable_r(){
        Restaurant= rcd.listerRestaurants();
        table_res.getItems().setAll(Restaurant);
    }
            private boolean nom_resvalide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(nom_res.getText());
        if(m.find() && m.group().equals(nom_res.getText())){
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
               private boolean adresse_resvalide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(adresse_res.getText());
        if(m.find() && m.group().equals(adresse_res.getText())){
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
                private boolean descp_resvalide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(descp_res.getText());
        if(m.find() && m.group().equals(descp_res.getText())){
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
        private boolean num_telvalide(){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(numt_res.getText());
        if(m.find() && m.group().equals(numt_res.getText())){
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
         String localisation;
    
       
   Stage stage1;
    FXMLLoader loader;
      public void showMap(Stage stage) {
       
            // create web engine and view
         WebEngine webEngine = new WebEngine(
                getClass().getResource("/edu/connexion3a29/utils/googleMap.html").toString());
         WebView webView = new WebView();
         webView.getEngine().load("file:///C:/Users/HP/Desktop/ghofrane/dynamic_developpers/src/edu/connexion3a29/utils/googleMap.html");
        // create map type buttons
               
             stage = new Stage(StageStyle.UTILITY);
            stage.setScene(new Scene(webView));
            stage.show();
        
        final ToggleGroup mapTypeGroup = new ToggleGroup();
        final ToggleButton road = new ToggleButton("Road");
        road.setSelected(true);
        road.setToggleGroup(mapTypeGroup);
        final ToggleButton satellite = new ToggleButton("Retour");
        
        satellite.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                stage1 = new Stage(StageStyle.UTILITY);
                   loader= new FXMLLoader(getClass().getResource("Restaurant.fxml"));
                    loader.setController(new RestaurantController());
                 try {
                     stage1.setScene(new Scene(loader.load()));
                 } catch (IOException ex) {
                     Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
                 }
            stage1.show();
                 
             }
         });
    
        stage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>(){
             @Override
             public void handle(WindowEvent event) {
                 System.out.println("close");
                 String adresse =webView.getEngine().executeScript("fullName").toString();
                 
                 
                 
                 
                 System.out.println("localisation = "+adresse);
                 label.setText(adresse);
             }
            
        });
       
        
     
        

   }
    
    @FXML
    private void ajouter_res(ActionEvent event) {
                 RestaurantCrud rc = new RestaurantCrud();
             if(nom_resvalide()&&descp_resvalide()&&num_telvalide()){
        
        String var1=nom_res.getText();
        String var2=label.getText();
        String var3=descp_res.getText();
        String var4=numt_res.getText();
        int var5=Integer.parseInt(var4);
        

       Restaurant r =new Restaurant();
        
      r.setNom_Restaurant(var1);
      r.setAdresse_Restaurant(var2);
      r.setNum_Tel_Restaurant(var5);
      r.setDescription_Restaurant(rc.bad_words(var3));        
      rc.ajouter_restaurant(r);
       updateTable_r();
      nom_res.clear();
       label.setText("");
      adresse_res.clear();
      descp_res.clear();
      numt_res.clear();
       
   } 
    }

    @FXML
    private void supprimer_res(ActionEvent event) {
           RestaurantCrud  rcd = new  RestaurantCrud ();
           Restaurant R= new Restaurant();   
              R= table_res.getSelectionModel().getSelectedItem();
              rcd.supprimer_restaurant(R);
              updateTable_r();
    }

    @FXML
    private void modifier_res(ActionEvent event) {
                if(nom_resvalide()&&descp_resvalide()&&num_telvalide()){   
       RestaurantCrud rc = new RestaurantCrud();
        String var1=nom_res.getText();
        String var2=label.getText();
        String var3=descp_res.getText();
        String var4=numt_res.getText();
        int var5=Integer.parseInt(var4);
       Restaurant r =new Restaurant();
        r.setNom_Restaurant(var1);
      r.setAdresse_Restaurant(var2);
      r.setNum_Tel_Restaurant(var5);
      r.setDescription_Restaurant(var3);
        r=table_res.getSelectionModel().getSelectedItem();
        rc.modifier_restaurant(r,var1,var2,var5,var3);
        updateTable_r();
         nom_res.clear();
      adresse_res.clear();
       label.setText("");
      descp_res.clear();
      numt_res.clear();
    }


}

    @FXML
    private void vider_res(ActionEvent event) {
          nom_res.clear();
      adresse_res.clear();
      descp_res.clear();
       label.setText("");
      numt_res.clear();
    }

    @FXML
    private void getSelected(MouseEvent event) {
        index=table_res.getSelectionModel().getSelectedIndex();
         if(index<=-1){
         return ;
     }
     nom_res.setText(nom_ress.getCellData(index).toString());
     label.setText(adresse_ress.getCellData(index).toString());
     descp_res.setText(descp_ress.getCellData(index).toString());
     numt_res.setText(numt_ress.getCellData(index).toString());
     
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
                 
                 nom_ress.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("Nom_Restaurant")); 
                 adresse_ress.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("Adresse_Restaurant"));
                 numt_ress.setCellValueFactory(new PropertyValueFactory<Restaurant,Integer>("Num_Tel_Restaurant"));
                 descp_ress.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("Description_Restaurant"));
                 table_res.setItems(data);
      }
      public void transferMessage(String loc ) {
       
       label.setText(loc);
   }

    public void start(Stage primaryStage) throws Exception {
    }

    @FXML
    private void GoToMap(ActionEvent event) {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     
        showMap(stage);
        
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
