/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Post;
import Service.ServicePost;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Oumayma
 */
public class UpdatePostController implements Initializable {
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
    private AnchorPane anchor;
    @FXML
    private Circle cir;
    @FXML
    private ImageView imagep;
    @FXML
    private FontAwesomeIconView photo1;
    @FXML
    private HBox hbox;
    private String i ;
    byte [] post_image = null;
    
    public UpdatePostController() {
    }
     void initData(Post d) {
     description.setText(d.getDescriptionP());
     hashtag.setText(d.getHashtagP());
     visibilite.getSelectionModel().select(d.getVisibilite());
     if (!(d.getImageP().equals("null"))){
           Image image = new Image("/image/"+d.getImageP());
          
     imagep.setImage(image);}
     }
    @FXML
    private void addphoto(MouseEvent event) throws IOException {
         FileChooser fc = new FileChooser();
        fc.setTitle("Ajouter une Image");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif"));
        File f = fc.showOpenDialog(null);
        String DBPath = "C:\\\\Users\\\\ASUS\\\\OneDrive\\\\Documents\\\\NetBeansProjects\\\\Dynamic-Developers\\\\src\\\\image\\\\"+f.getName();
        i=f.getName();
        p.setImageP(i);
        if (f != null){
        BufferedImage bufferedImage = ImageIO.read(f);
        WritableImage image = SwingFXUtils.toFXImage(bufferedImage,null);
        ImageIO.write(bufferedImage, "png", new File(DBPath));
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
       visibilite.getSelectionModel().selectFirst();
       Image user = new Image("/image/profile-pic.png");
       cir.setFill(new ImagePattern(user)); 
   

    }    
   
    @FXML
    private void Redirect(ActionEvent event) throws IOException {
        ServicePost serv=new ServicePost();
       
       if (!(description.getText().equals("")) && (hashtag.getText().equals("Voyage") || hashtag.getText().equals("Excursion")|| hashtag.getText().equals("Restaurant") ) ){
          p.setDescriptionP(description.getText());
          p.setHashtagP(hashtag.getText());
          p.setVisibilite(visibilite.getValue()); 
          serv.modifier(p);
           Parent root = FXMLLoader.load(getClass().getResource("ShowPost.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
       }else{
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
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
