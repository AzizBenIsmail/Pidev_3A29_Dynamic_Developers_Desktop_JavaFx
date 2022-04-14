/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Personne;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        String id=IDP.getText();
        String Nom=NomP.getText();
        String Prenom=PrenomP.getText();
        String Age=AgeP.getText();
        Personne p = new Personne(Integer.parseInt(id),Integer.parseInt(Age),Nom,Prenom);
        
    }
    
    
}
