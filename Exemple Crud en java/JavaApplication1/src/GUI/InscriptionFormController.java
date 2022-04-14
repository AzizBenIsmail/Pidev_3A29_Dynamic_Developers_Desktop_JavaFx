/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Personne;
import Service.PersonneServise;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class InscriptionFormController implements Initializable {

    @FXML
    private TextField IDP;
    @FXML
    private TextField NomP;
    @FXML
    private TextField PrenomP;
    @FXML
    private TextField AgeP;
    @FXML
    private Button Save;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SaveP(ActionEvent event) {
        try {
            String id=IDP.getText();
            String Nom=NomP.getText();
            String Prenom=PrenomP.getText();
            String Age=AgeP.getText();
            Personne p = new Personne(Integer.parseInt(id),Integer.parseInt(Age),Nom,Prenom);
            
            PersonneServise ps = new PersonneServise();
            
            ps.Ajouter(p);
            
            //Redirection
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonneDetail.fxml"));
            Parent root = loader.load();
            PersonneDetailController pc = loader.getController();
            pc.setResid(id);
            pc.setResnom(Nom);
            pc.setResprenom(Prenom);
            pc.setResage(Age);
            
            IDP.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
    }
    
    
}
