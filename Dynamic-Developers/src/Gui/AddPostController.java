/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Post;
import Service.ServicePost;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Oumayma
 */
public class AddPostController implements Initializable {
    
    Post p = new Post();
    @FXML
    private ComboBox<String> visibilite;
    @FXML
    private FontAwesomeIconView photo;
    @FXML
    private Button post;
    @FXML
    private TextArea description;
    @FXML
    private TextField hashtag;
    @FXML
    private Circle cir;
    @FXML
    ImageView imagep = null;
    @FXML
    private FontAwesomeIconView photo1;
    private String i ;
    byte [] post_image = null;
    @FXML
    private AnchorPane anchor;
    @FXML
    private ComboBox<String> local;
    @FXML
    private WebView webview;
    @FXML
    private Text username;
    
    @FXML
    private void addphoto(MouseEvent event) throws FileNotFoundException, IOException {
        
        FileChooser fc = new FileChooser();
        fc.setTitle("Ajouter une Image");
        fc.getExtensionFilters().addAll(
               new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File f = fc.showOpenDialog(null);
        String DBPath = "C:\\\\\\\\xampp\\\\\\\\htdocs\\\\\\\\Version-Integre\\\\\\\\public\\\\\\\\uploads\\\\\\\\"+f.getName();
        i=f.getName();
        p.setImageP(i);
        System.out.println(p.getImageP());
        if (f != null){
        BufferedImage bufferedImage = ImageIO.read(f);
        WritableImage image = SwingFXUtils.toFXImage(bufferedImage,null);
        ImageIO.write(bufferedImage, "jpg", new File(DBPath));
        imagep.setImage(image);
        FileInputStream fin =new FileInputStream(f);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte [1024];
        for (int readNum ;(readNum= fin.read(buf)) != -1 ;){
            bos.write(buf,0,readNum);
         post_image = bos.toByteArray();}
        } 
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       visibilite.getItems().addAll("public","anonymous");
        ServicePost service=new ServicePost();
       visibilite.getSelectionModel().selectFirst();
       username.setText(service.OneUser(SessionManager.getId()).getUserName());
       Image user = new Image("/image/profile-pic.png");
       cir.setFill(new ImagePattern(user)); 
       ObservableList<String> cities= FXCollections.observableArrayList();
       String[] locales1 = Locale.getISOCountries();
       for(String countrylist : locales1){
           Locale obj = new Locale("",countrylist);
           String[] city = {obj.getDisplayCountry()};
           for (int x=0;x<city.length;x++){
               cities.add(obj.getDisplayCountry());
           }
       }
       
      local.setItems(cities);
    }    

    @FXML
    private void Redirect(ActionEvent event) throws IOException {
        
       ServicePost serv=new ServicePost();
       if (!(description.getText().equals("")) && (hashtag.getText().equals("Voyage") || hashtag.getText().equals("Excursion")|| hashtag.getText().equals("Restaurant") ) ){
          p.setDescriptionP(description.getText());
          p.setHashtagP(hashtag.getText());
          p.setVisibilite(visibilite.getValue());
          p.setIdc(SessionManager.getId());
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
          LocalDateTime now = LocalDateTime.now();  
          String date= dtf.format(now);
          p.setDateP(date);
          System.out.println(i);
          p.setImageP(i);
          System.out.println(p.getImageP());
          serv.ajouter(p);
          Parent root = FXMLLoader.load(getClass().getResource("ShowPost.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
       }else{
          Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setContentText("Verifier vos données ");
                alert.showAndWait();
       }
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("ShowPost.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

   
    
}
