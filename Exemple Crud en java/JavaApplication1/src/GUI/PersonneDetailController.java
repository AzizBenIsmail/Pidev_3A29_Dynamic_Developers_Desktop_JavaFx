/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PersonneDetailController implements Initializable {

    @FXML
    private TextField resid;
    @FXML
    private TextField resnom;
    @FXML
    private TextField resprenom;
    @FXML
    private TextField resage;
    @FXML
    private DatePicker picker;
    @FXML
    private ImageView ImageP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //Date.valueOf(picker.getValue());
       
       //ImageP.setImage(new Image("‪C:/Users/ASUS/Downloads/2.png"));
    }    

    public void setResid(String valeur) {
        this.resid.setText(valeur);
    }

    public void setResnom(String valeur) {
        this.resnom.setText(valeur);
    }

    public void setResprenom(String valeur) {
        this.resprenom.setText(valeur);
    }

    public void setResage(String valeur) {
        this.resage.setText(valeur);
    }
    
}
