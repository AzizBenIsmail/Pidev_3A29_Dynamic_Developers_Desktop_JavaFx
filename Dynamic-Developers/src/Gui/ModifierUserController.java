/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.User;
import Service.UserCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierUserController implements Initializable {

    @FXML
    private TextField cinM;
        @FXML
    private TextField idUser;
    @FXML
    private TextField usernameM;
    @FXML
    private Button modifier_btn;
    @FXML
    private TextField numeroM;
    @FXML
    private TextField adresseM;
    @FXML
    private TextField email_signupM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void textfieldDesign1(MouseEvent event) {
    }

    @FXML
    private void textfieldDesign1(KeyEvent event) {
    }

       @FXML
    void ModifierU(ActionEvent event) {
         UserCRUD rec= new UserCRUD();
        
         Integer id=Integer.parseInt(idUser.getText());
         Integer cin=Integer.parseInt(cinM.getText());
         Integer num=Integer.parseInt(numeroM.getText());
         String username= usernameM.getText();
         String adresse= adresseM.getText();
         String email= email_signupM.getText();
         
         User R;
           R = new User(id,cin,username,num,adresse,email);
           rec.modifierUtilisateur(R);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Travel Me :: Success Message");
                alert.setHeaderText(null);
                alert.setContentText("Utilsateur modifié");
                alert.showAndWait();  
             

    }
    public void setText(User user)
    {
     
        String id =String.valueOf(user.getId());
        cinM.setText(id);
        String cin =String.valueOf(user.getCIN());
        cinM.setText(cin);
        usernameM.setText(user.getUserName());
        adresseM.setText(user.getAdresse());
        String num =String.valueOf(user.getNumero());
        numeroM.setText(num);
        email_signupM.setText(user.getEmail());
     
    }
     public void setTextFields(User R){
        idUser.setText(String.valueOf(R.getId()));
       cinM.setText(String.valueOf(R.getCIN()));
        usernameM.setText(R.getUserName());
        numeroM.setText(String.valueOf(R.getNumero()));
        adresseM.setText(R.getAdresse());
        email_signupM.setText(R.getEmail());
    }

    
}
