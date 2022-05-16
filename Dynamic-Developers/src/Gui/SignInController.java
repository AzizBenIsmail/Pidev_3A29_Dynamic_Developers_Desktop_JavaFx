/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import Entity.User;
import java.io.IOException;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import utils.MyConnection;
import utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SignInController implements Initializable {

    @FXML
    private Label TravelMe;
    @FXML
    private TextField email_signin;
    @FXML
    private PasswordField password_signin;
    @FXML
    private Button login_btn;
    @FXML
    private Hyperlink create_acc;
    @FXML
    private Label TravelMe2;
    @FXML
    private TextField cin;
    @FXML
    private TextField username;
    @FXML
    private Button signup_btn;
    @FXML
    private Hyperlink login_acc;
    @FXML
    private AnchorPane signup_form;
    @FXML
    private AnchorPane login_form;
    @FXML
    private PasswordField confirm_password;
    @FXML
    private TextField numero;
    @FXML
    private PasswordField password_signup;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email_signup;
    @FXML
    private Hyperlink mdp_oub;

    /**
     * Initializes the controller class.
     */
    
    private Connection cnx;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;
    
     public void exit(){
        System.exit(0);
    }   
    public void textfieldDesign(){
        if (email_signin.isFocused()){
            email_signin.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            password_signin.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            
            
        }else if (password_signin.isFocused()){
            email_signin.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            password_signin.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
        } 
    }
     public void textfieldDesign1(){
     if(email_signup.isFocused()){
         email_signup.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            password_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            cin.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            username.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            adresse.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            numero.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            confirm_password.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
     } else if(password_signup.isFocused()){
         email_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            password_signup.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            cin.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            username.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            adresse.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            numero.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            confirm_password.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
     }  else if(cin.isFocused()){
         email_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            password_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            cin.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            username.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            adresse.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            numero.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            confirm_password.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
     } else if(username.isFocused()){
         email_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            password_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            cin.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            username.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            adresse.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            numero.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            confirm_password.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
     } else if(adresse.isFocused()){
         email_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            password_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            cin.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            username.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            adresse.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            numero.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            confirm_password.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
     } else if(numero.isFocused()){
         email_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            password_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            cin.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            username.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            adresse.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            numero.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            confirm_password.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
     }  else if(confirm_password.isFocused()){
         email_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            password_signup.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            cin.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            username.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            adresse.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            numero.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            confirm_password.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
     }
     
     }
    public void dropShadowEffect(){
        DropShadow original = new DropShadow(20,Color.valueOf("#ae44a5"));
        original.setRadius(30);
        TravelMe.setEffect(original);
        
        TravelMe2.setEffect(original);
        TravelMe.setOnMouseEntered((MouseEvent event)->{       
        DropShadow shadow = new DropShadow(60,Color.valueOf("#ae44a5"));
        TravelMe.setCursor(Cursor.HAND);
        TravelMe.setStyle("-fx-text-fill:#517ab5");
        TravelMe.setEffect(shadow);
        
    });
    TravelMe.setOnMouseExited((MouseEvent event)->{
        DropShadow shadow = new DropShadow(20,Color.valueOf("#ae44a5"));
        shadow.setRadius(30);
        TravelMe.setStyle("-fx-text-fill:#000");
        TravelMe.setEffect(shadow);
    });
    TravelMe2.setOnMouseEntered((MouseEvent event)->{       
        DropShadow shadow = new DropShadow(60,Color.valueOf("#ae44a5"));
        TravelMe2.setCursor(Cursor.HAND);
        TravelMe2.setStyle("-fx-text-fill:#517ab5");
        TravelMe2.setEffect(shadow);
        
    });
    TravelMe2.setOnMouseExited((MouseEvent event)->{
        DropShadow shadow = new DropShadow(20,Color.valueOf("#ae44a5"));
        shadow.setRadius(30);
        TravelMe2.setStyle("-fx-text-fill:#000");
        TravelMe2.setEffect(shadow);
    });
}
    public void changeForm(ActionEvent event){
        if(event.getSource() == create_acc){
            signup_form.setVisible(true);
             login_form.setVisible(false);
        }else if(event.getSource()==login_acc){
            login_form.setVisible(true);
            signup_form.setVisible(false);
        }
    }
    
    public boolean ValidationEmail(){ 
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9._]+([.][a-zA-Z0-9]+)+");
        Matcher match = pattern.matcher(email_signup.getText());
        
        if(match.find() && match.group().equals(email_signup.getText()))
        {
            return true;
        }else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Errore message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Email");
            alert.showAndWait();
            
            return false;
        }
    }
    
    public void login() throws IOException{
        if(email_signin.getText().equals("mohamedaziz.benismail@esprit.tn") && password_signin.getText().equals("adminadmin") )
        {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Travel Me :: Success Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Bienvenu Admin");
                     alert.showAndWait();
                     
                  Parent root = FXMLLoader.load(getClass().getResource("/Gui/Back.fxml"));
                     Scene scene;
                     
                    scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
      
                    stage.show();
        }else {
            
            String query2="select * from user where email=?  and password=?";
            cnx = MyConnection.getInstance().getCnx();
           try{
              PreparedStatement smt = cnx.prepareStatement(query2);
       
               smt.setString(1,email_signin.getText());
               smt.setString(2,password_signin.getText());
               ResultSet rs= smt.executeQuery();
               User p;
                if(rs.next()){
                     p=new User(rs.getInt("cin"),rs.getString("user_name"),rs.getInt("numero"),rs.getString("email"),rs.getString("adresse"),rs.getString("password"));
                     User.setCurrent_User(p);
                     SessionManager.getInstace(rs.getInt("id"),rs.getInt("cin"),rs.getString("user_name"),rs.getInt("numero"),rs.getString("email"),rs.getString("adresse"),rs.getString("roles"));
                     System.out.println(User.Current_User.getEmail());
                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Travel Me :: Success Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Vous etes connecté");
                     alert.showAndWait();
                    login_btn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/Gui/MenuDynamicDevelopers.fxml"));
                     Scene scene;
                    scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
      
                    stage.show();
                
                    
                }else{
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Travel Me :: Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Email/Password !!");
                alert.showAndWait();  
                }
          
      }catch(Exception ex){
           System.out.println(ex.getMessage());
      }

            
        }
         
    }
     @FXML
    public void  signUp(){
      
    cnx = MyConnection.getInstance().getCnx();
    String query="INSERT INTO user (cin, user_name, numero, email, adresse, password)"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
    
    try{
        
          if( username.getText().isEmpty()
                    | numero.getText().isEmpty()
                    | email_signup.getText().isEmpty()
                    | password_signup.getText().isEmpty()
                    | adresse.getText().isEmpty()
                    |cin.getText().isEmpty()
                    | confirm_password.getText().isEmpty()){
              
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Travel Me :: Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Entrer all blank fields !!");
                alert.showAndWait();
    
        
         
          }else if(confirm_password.getText().length() < 8 | confirm_password.getText()==password_signup.getText() ){
              
              Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Travel Me :: Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Password doit etre sup 8 caractéres !!");
                alert.showAndWait();
                
          }
          else{
               if(ValidationEmail()){
             PreparedStatement smt = cnx.prepareStatement(query);
        
            smt.setString(1, cin.getText());
            smt.setString(2, username.getText());
            smt.setString(3, numero.getText());
            smt.setString(4, email_signup.getText());
            smt.setString(5, adresse.getText());
            smt.setString(6, password_signup.getText());
            smt.executeUpdate();
             
                System.out.println("ajout avec succee");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Travel Me :: BIENVENNUE");
                alert.setHeaderText(null);
                alert.setContentText("Vous Etes Inscrit !!");
                alert.showAndWait();
                
                login_form.setVisible(true);
                signup_form.setVisible(false);
                
          }
        
            
          }}catch(SQLException ex){
         System.out.println(ex.getMessage());
    }
 }
    void sendPassword(){
        System.out.println("cxcccccccccccccccccc");
                String query2="select * from user where email=? ";
                String email1="empty";
                 try {
            PreparedStatement smt = cnx.prepareStatement(query2);
            smt.setString(1, email_signin.getText());
             ResultSet rs= smt.executeQuery();
                if(rs.next()){
                   email1=rs.getString("email");
                     System.out.println(email1);
                }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
                 sendMail(email1);
    }
    public void sendMail(String recepient){
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        String myAccountEmail = "travelme3a29@gmail.com";
        String passwordd = "Aymen2000abid@";
       
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail,passwordd);
            }
        });
        Message message =preparedMessage(session,myAccountEmail,recepient);
        try{
            Transport.send(message);
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("TravelMe :: Boite Mail");
                alert.setHeaderText(null);
                alert.setContentText("consulter votre boite mail !!");
                alert.showAndWait();  
           
        }catch(Exception ex){
            ex.printStackTrace();
           
        }
               
    }
     private Message preparedMessage(Session session, String myAccountEmail, String recepient){
         String query2="select * from user where email=?";
         String userEmail="null" ;
         String pass="empty";
        try {
            PreparedStatement smt = cnx.prepareStatement(query2);
            smt.setString(1, email_signin.getText());
             ResultSet rs= smt.executeQuery();
             System.out.println(rs);
                if(rs.next()){
                   pass=rs.getString("password");
                   userEmail=rs.getString("email");                }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.print("c est en cours");
        String text="Votre mot de pass est :"+pass+"";
        String object ="Recupération de mot de passe";
        Message message = new MimeMessage(session);
        try{
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
        message.setSubject(object);
        String htmlcode ="<h1> "+text+" </h1> <h2> <b> </b2> </h2> ";
        message.setContent(htmlcode, "text/html");
         System.out.println("Message envoyeer");
         
           System.out.println(pass);
           
        return message;
       
        }catch(MessagingException ex){
            ex.printStackTrace();
        }
    return null;
    }
     
    @FXML
    void sendPaswword_btn(ActionEvent event) {
        //sendMail(email_signin.getText());
       sendPassword();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dropShadowEffect();
    }    
    
}
