/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Reclamation;
import Service.ServiceReclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author MSI GF63
 */
public class FXMLReclamationbackController implements Initializable {

    @FXML
    private TableView<Reclamation> tftableview;
    @FXML
    private TableColumn<?, ?> tfobjet;
    @FXML
    private TableColumn<?, ?> tfdescription;
    @FXML
    private TableColumn<?, ?> tftype;
    @FXML
    private Button tfback;
    @FXML
    private TableColumn<?, ?> tfdate;
    @FXML
    private TableColumn<?, ?> tfetat;
    @FXML
    private Button tftraite;
     public static final String ACCOUNT_SID = "TWILIO_ACCOUNT_SID";
     public static final String AUTH_TOKEN = "TWILIO_AUTH_TOKEN";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceReclamation service=new ServiceReclamation();
        ObservableList<Reclamation> list = service.getall();
         tfobjet.setCellValueFactory(new PropertyValueFactory<>("Objet"));
          tfdescription.setCellValueFactory(new PropertyValueFactory<>("DescriptionR"));
          tftype.setCellValueFactory(new PropertyValueFactory<>("TypeR"));
          tfdate.setCellValueFactory(new PropertyValueFactory<>("DateR"));
          tfetat.setCellValueFactory(new PropertyValueFactory<>("etat"));
          tftableview.setItems(list);
    }    

    @FXML
    private void back(ActionEvent event) {
        //TODO
       
    }

    @FXML
    private void treat(ActionEvent event) {
        String msg ="Votre Reclamation est traite";
       
        

 
        ServiceReclamation service=new ServiceReclamation();
        Reclamation r=tftableview.getSelectionModel().getSelectedItem();
        service.traiter(r);
  
      
  
        refresh();
        
    }
    public void refresh(){
    ServiceReclamation service=new ServiceReclamation();
        ObservableList<Reclamation> list = service.getall();
         tfobjet.setCellValueFactory(new PropertyValueFactory<>("Objet"));
          tfdescription.setCellValueFactory(new PropertyValueFactory<>("DescriptionR"));
          tftype.setCellValueFactory(new PropertyValueFactory<>("TypeR"));
          tfdate.setCellValueFactory(new PropertyValueFactory<>("DateR"));
          tfetat.setCellValueFactory(new PropertyValueFactory<>("etat"));
          tftableview.setItems(list);
    }
}
