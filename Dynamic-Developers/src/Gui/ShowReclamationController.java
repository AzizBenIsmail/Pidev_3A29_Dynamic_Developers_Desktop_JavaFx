/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import API.MailerAPI;
import static API.MailerAPI.Mail;
import Entity.Reclamation;
import Service.ServiceReclamation;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * FXML Controller class
 *
 * @author Oumayma
 */
public class ShowReclamationController implements Initializable {

    @FXML
    private Button Reclamer;
    @FXML
    private ChoiceBox<String> type;
    @FXML
    private TextArea description;
    @FXML
    private TextField objet;
    @FXML
    private VBox tfrec;
    @FXML
    private Button Modifier;
     static Session sesh;
        static Properties prop = new Properties();

    
    public void initData(Reclamation r){
        
        type.getSelectionModel().select(r.getTypeR());
        description.setText(r.getDescriptionR());
        objet.setText(r.getObjet());
        System.out.println(r.getDescriptionR());
        Modifier.setOnMouseClicked(m->{
            
            ServiceReclamation serv=new ServiceReclamation();
      
         if (!(r.getDescriptionR().equals(""))){
         
          r.setDescriptionR(description.getText());
          r.setObjet(objet.getText());
          r.setTypeR(type.getValue()); 
          serv.modifier(r);
          refresh();
       }else{
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setContentText("Veuiller Selectionner La reclamation a modifier ");
                alert.showAndWait();
       }
            
            
        });
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      type.getItems().addAll("Technique","Dans un Voyage","Dans une Excursion","Dans un Restaurant");
      type.getSelectionModel().selectFirst();
        
       Modifier.setOnMouseClicked(m->{
            
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setContentText("Veuillez Selectionner La reclamation a modifier ");
               alert.showAndWait();
       
               });
           
     
        ServiceReclamation service=new ServiceReclamation();
        List<Reclamation> list = new ArrayList<Reclamation>();
        list=service.recuperer();
        System.out.print(list);
        
        for(Reclamation e : list)
        {  
           HBox lc = new HBox();
           
          // Button modif = new Button("modifier");
           FontAwesomeIconView modif = new FontAwesomeIconView(FontAwesomeIcon.PENCIL);
           modif.setFill(Color.GREEN);
           modif.setGlyphSize(25);
           modif.setCursor(Cursor.HAND);          
           lc.getChildren().add(modif);
           lc.setTranslateX(300);
           lc.setTranslateY(5);
           
           FontAwesomeIconView supp = new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT);
           supp.setFill(Color.RED);
           supp.setGlyphSize(25);
           supp.setCursor(Cursor.HAND);
           supp.setTranslateX(5);
           lc.getChildren().add(supp);
         
           
           HBox obj= new HBox();
           Label t=      new Label("    Type        : "+e.getTypeR());
           Label desc=   new Label("    Description : "+e.getDescriptionR());
           Label d=      new Label("    Date        : "+e.getDateR());
           Label objet1= new Label("    Objet       : "+e.getObjet());
           obj.getChildren().add(objet1);
           obj.getChildren().add(lc);
         
           supp.setOnMouseClicked(a->{
               service.Supprimer((int) e.getId());
               Parent root;
               try {
                   root = FXMLLoader.load(getClass().getResource("ShowReclamation.fxml"));
                    Scene scene = new Scene(root);
                   Stage stage = (Stage) ((Node) a.getSource()).getScene().getWindow();
                   stage.setScene(scene);
                   stage.show(); 
               } catch (IOException ex) {
                   Logger.getLogger(ShowPostController.class.getName()).log(Level.SEVERE, null, ex);
               }
           });
          
             modif.setOnMouseClicked(m->{
             Parent root;
               try {
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowReclamation.fxml"));
                   root = (Parent) loader.load();
                   ShowReclamationController controller = loader.getController();
             
                    controller.initData(e);
                   
                   System.out.println(loader.getController().toString());
                  
                   Stage stage=(Stage) ((Node) m.getSource()).getScene().getWindow();
                   stage.setScene(new Scene(root));
                   stage.show();
               } catch (IOException ex) {
                   Logger.getLogger(ShowPostController.class.getName()).log(Level.SEVERE, null, ex);
               }
              
           });
          
           Label type= new Label();
           Label objet= new Label();
           VBox rec = new VBox();
           rec.setBackground(new Background(new BackgroundFill(Color.rgb(190,210,255), new CornerRadii (10), new Insets(5))));
           rec.getChildren().add(objet);
           rec.getChildren().add(obj);
           rec.getChildren().add(d);
           rec.getChildren().add(t);
           rec.getChildren().add(desc);
           rec.getChildren().add(type);
          
          
           tfrec.getChildren().add(rec);
           //tfrec.setTranslateX(10);
          // tfrec.setTranslateY(10);
           
           
       
        }
    }  
    
    @FXML
    private void Redirect(ActionEvent event) {
        
       ServiceReclamation serv=new ServiceReclamation();
       Reclamation p = new Reclamation();
       if (!(description.getText().equals("")) && !(objet.getText().equals("")) ){
         
           
           String UN ="touiloumayma2017@gmail.com";
           String PW = "azertyuiop123456";  
           String mto = "touiloumayma2017@gmail.com";
            String msub = "Nouvelle Reclamation";
           String cTEXT ="Contenu du mail";
           MailerAPI.Mail(UN, PW, mto, msub, cTEXT);
           // Mail(UN,PW,mto, msub, cTEXT);
            
          p.setDescriptionR(description.getText());
          p.setObjet(objet.getText());
          p.setTypeR(type.getValue()); 
          serv.ajouter(p);
          
           
          
          refresh();
       }else{
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setContentText("Verifier vos données ");
                alert.showAndWait();
       }
    }

    private void refresh() {
         
        description.setText("");
        objet.setText("");
        tfrec.getChildren().clear();
        type.getItems().addAll("Technique","Dans un Voyage","Dans une Excursion","Dans un Restaurant");
        type.getSelectionModel().selectFirst();
      
        ServiceReclamation service=new ServiceReclamation();
        List<Reclamation> list = new ArrayList<Reclamation>();
        list=service.recuperer();
        System.out.print(list);
        
        for(Reclamation e : list)
        {  
           HBox lc = new HBox();
           
          // Button modif = new Button("modifier");
           FontAwesomeIconView modif = new FontAwesomeIconView(FontAwesomeIcon.PENCIL);
           modif.setFill(Color.GREEN);
           modif.setGlyphSize(25);
           modif.setCursor(Cursor.HAND);          
           lc.getChildren().add(modif);
           lc.setTranslateX(300);
           lc.setTranslateY(5);
           
           FontAwesomeIconView supp = new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT);
           supp.setFill(Color.RED);
           supp.setGlyphSize(25);
           supp.setCursor(Cursor.HAND);
           supp.setTranslateX(5);
           lc.getChildren().add(supp);
         
           
           HBox obj= new HBox();
           Label t=      new Label("    Type        : "+e.getTypeR());
           Label desc=   new Label("    Description : "+e.getDescriptionR());
           Label d=      new Label("    Date        : "+e.getDateR());
           Label objet1= new Label("    Objet       : "+e.getObjet());
           obj.getChildren().add(objet1);
           obj.getChildren().add(lc);
         
           supp.setOnMouseClicked(a->{
               service.Supprimer((int) e.getId());
               Parent root;
               try {
                   root = FXMLLoader.load(getClass().getResource("ShowReclamation.fxml"));
                    Scene scene = new Scene(root);
                   Stage stage = (Stage) ((Node) a.getSource()).getScene().getWindow();
                   stage.setScene(scene);
                   stage.show(); 
               } catch (IOException ex) {
                   Logger.getLogger(ShowPostController.class.getName()).log(Level.SEVERE, null, ex);
               }
           });
          
             modif.setOnMouseClicked(m->{
             Parent root;
               try {
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowReclamation.fxml"));
                   root = (Parent) loader.load();
                   ShowReclamationController controller = loader.getController();
             
                    controller.initData(e);
                   
                   System.out.println(loader.getController().toString());
                  
                   Stage stage=(Stage) ((Node) m.getSource()).getScene().getWindow();
                   stage.setScene(new Scene(root));
                   stage.show();
               } catch (IOException ex) {
                   Logger.getLogger(ShowPostController.class.getName()).log(Level.SEVERE, null, ex);
               }
              
           });
          
           Label type= new Label();
           Label objet= new Label();
           VBox rec = new VBox();
           rec.setBackground(new Background(new BackgroundFill(Color.rgb(190,210,255), new CornerRadii (10), new Insets(5))));
           rec.getChildren().add(objet);
           rec.getChildren().add(obj);
           rec.getChildren().add(d);
           rec.getChildren().add(t);
           rec.getChildren().add(desc);
           rec.getChildren().add(type);
          
          
           tfrec.getChildren().add(rec);
           //tfrec.setTranslateX(10);
          // tfrec.setTranslateY(10);
           
           
        }
    
}


}