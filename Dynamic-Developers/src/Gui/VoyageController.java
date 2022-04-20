/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.voyage;
import static Entity.voyage.filename;
import Service.Scontrole_Voyage;
import Service.ServiceVoyage;
import Util.MyDB;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import javafx.stage.StageStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class VoyageController implements Initializable {

    @FXML
    private ImageView ImageP;
    private TextField Voyage;
    @FXML
    private TableColumn<voyage,String> VDest;
    @FXML
    private TableColumn<voyage,String> VNom;
    @FXML
    private TableColumn<voyage,String> VDuree;
    @FXML
    private TableColumn<voyage,Date> Vdate;
    @FXML
    private TableColumn<voyage,String> VValibilite;
    @FXML
    private TableColumn<voyage,ImageView> Vimage;
    @FXML
    private TableColumn<voyage,Float> Vprix;
    @FXML
    private TableView<voyage> TableVoyage;
    @FXML
    private Button SupprimerVoyage;
    @FXML
    private Button Actualiser;
    @FXML
    private TableColumn<voyage,Integer> VID;
    @FXML
    private Button Bientot_disponible;
    @FXML
    private Button Disponible;
    @FXML
    private Button Non_Disponible;
    
    public static String idxx;
    
    voyage ss=new voyage();
    
    private Statement ste;
    private voyage v;
    String query = null;
    Connection connection = null ;
    Connection cnx=MyDB.getInsatnce().getConnection();
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    voyage VOY = null ;
    
ObservableList<voyage>  List = FXCollections.observableArrayList();
    @FXML
    private ImageView Image;
    @FXML
    private TextField Destination;
    @FXML
    private TextField Duree_Voyage;
    @FXML
    private TextField Nom_Voyage;
    @FXML
    private TextField Prix;
    @FXML
    private DatePicker Datev;
    @FXML
    private Button AddImage;
    @FXML
    private TextField URLImage;
    @FXML
    private Button Add;
    @FXML
    private Button ModVoy;
    @FXML
    private ComboBox<String> combox;
    @FXML
    private TextField Recherche;
    @FXML
    private Button PDF;
    @FXML
    private Button stat;
    ObservableList<voyage> list;
    @FXML
    private Button Map;
    @FXML
    private Button Notif;
    @FXML
    private Button Media;
    @FXML
    private Button stat1;
    @FXML
    private Button stat2;
    @FXML
    private Button reset;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("Disponible","Non Disponible","Bientot Disponible");
        combox.setItems(list);
        loadvoy();
        refresh();

};

    @FXML
    private void Liste_Voyage(javafx.scene.input.MouseEvent event) {
      
          try {
               voyage voy = TableVoyage.getSelectionModel().getSelectedItem();
               Destination.setText(voy.getDestination());
               Nom_Voyage.setText(voy.getNom_voyage());
               Duree_Voyage.setText(voy.getDuree_voyage());
              // java.sql.Date date = java.sql.Date.valueOf(Datev.getValue());
             //  Datev.set(voy.getDate());
               String c =  voy.getValabilite();
               combox.setValue(c);
               Prix.setText(String.valueOf(voy.getPrix()));               
               String path = voy.getImage();
               File file=new File(path);
               URLImage.setText(path);
               Image img = new Image(file.toURI().toString());
                Image.setImage(img);
           } catch (Exception e) {
               System.out.println(e.getMessage());
               
           }
    }
    public void delete()
    {
        ServiceVoyage SV = new ServiceVoyage();
       SV.SupprimerVoyage(TableVoyage.getSelectionModel().getSelectedItem().getID());
        System.out.println(TableVoyage.getSelectionModel().getSelectedItem().getID());
    }
    @FXML
    private void SupprimerVoyage(ActionEvent event) {
        delete();
        TableVoyage.getItems().removeAll(TableVoyage.getSelectionModel().getSelectedItem());
        System.out.println(TableVoyage);
        TableVoyage.refresh();
    }
    
    @FXML
    private void Actualiser(ActionEvent event) {
        loadvoy();
        refresh();
        }

    @FXML
    private void Bientot_disponible(ActionEvent event) {
 try {
            List.clear();
            
            query = "select * from voyage WHERE valabilite = 'Bientot Disponible'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                List.add(new  voyage(
                        resultSet.getInt("id"),
                        resultSet.getString("destination"),
                        resultSet.getString("nom_voyage"),
                        resultSet.getString("duree_voyage"),
                        resultSet.getDate("date"),
                        resultSet.getString("valabilite"),
                        resultSet.getString("image"),
                        resultSet.getFloat("prix")
                        )); 
               TableVoyage.setItems(List);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Disponible(ActionEvent event) {
                 try {
            List.clear();
            
            query = "select * from voyage WHERE valabilite = 'Disponible'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                List.add(new  voyage(
                        resultSet.getInt("id"),
                        resultSet.getString("destination"),
                        resultSet.getString("nom_voyage"),
                        resultSet.getString("duree_voyage"),
                        resultSet.getDate("date"),
                        resultSet.getString("valabilite"),
                        resultSet.getString("image"),
                        resultSet.getFloat("prix")
                        )); 
               TableVoyage.setItems(List);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Non_Disponible(ActionEvent event) {
       try {
            List.clear();
            
            query = "select * from voyage WHERE valabilite = 'Non Disponible'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                List.add(new  voyage(
                        resultSet.getInt("id"),
                        resultSet.getString("destination"),
                        resultSet.getString("nom_voyage"),
                        resultSet.getString("duree_voyage"),
                        resultSet.getDate("date"),
                        resultSet.getString("valabilite"),
                        resultSet.getString("image"),
                        resultSet.getFloat("prix")
                        )); 
               TableVoyage.setItems(List);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

  
    private void refresh() {
        try {
            List.clear();
            
            query = "select * from voyage";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                List.add(new  voyage(
                        resultSet.getInt("id"),
                        resultSet.getString("destination"),
                        resultSet.getString("nom_voyage"),
                        resultSet.getString("duree_voyage"),
                        resultSet.getDate("date"),
                        resultSet.getString("valabilite"),
                        resultSet.getString("image"),
                        resultSet.getFloat("prix")
                        )); 
                TableVoyage.setItems(List);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    private void clear() {

        Destination.setText(null);
        Nom_Voyage.setText(null);
        Duree_Voyage.setText(null);
        Datev.setValue(null);
        combox.setValue(null);
        URLImage.setText(null);
        Prix.setText(null);       
  
    }
    private void loadvoy() {
    voyage v=new voyage();
    connection= MyDB.getInsatnce().getConnection();
           VID.setCellValueFactory(new PropertyValueFactory<>("id"));
        VDest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        VNom.setCellValueFactory(new PropertyValueFactory<>("nom_voyage"));
        VDuree.setCellValueFactory(new PropertyValueFactory<>("duree_voyage"));
        Vdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        VValibilite.setCellValueFactory(new PropertyValueFactory<>("valabilite"));
        Vimage.setCellValueFactory(new PropertyValueFactory<>("image"));
        Vprix.setCellValueFactory(new PropertyValueFactory<>("prix"));    
    }

    @FXML
    private void AddImage(ActionEvent event) throws FileNotFoundException, IOException {
        Random rand = new Random();
        int x = rand.nextInt(1000);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        String DBPath = "C:\\\\xampp\\\\htdocs\\\\Version-Integre\\\\public\\\\uploads\\\\"  + x + ".jpg";
        if (file != null) {
            FileInputStream Fsource = new FileInputStream(file.getAbsolutePath());
            FileOutputStream Fdestination = new FileOutputStream(DBPath);
            BufferedInputStream bin = new BufferedInputStream(Fsource);
            BufferedOutputStream bou = new BufferedOutputStream(Fdestination);
            System.out.println(file.getAbsoluteFile());
            String path=file.getAbsolutePath();
            Image img = new Image(file.toURI().toString());
            Image.setImage(img);
            URLImage.setText(DBPath);
            int b = 0;
            while (b != -1) {
                b = bin.read();
                bou.write(b);
            }
            bin.close();
            bou.close();
            
        } else {
            System.out.println("error");

        }
    }

    @FXML
    private void Add(ActionEvent event) {
        
        String Destinationv = Destination.getText();
        String Nom_Voyagev = Nom_Voyage.getText();
        String Duree_Voyagev = Duree_Voyage.getText();
        //Date Datevoy= Date.valueOf(Datev.getValue());
        String Valabilitev = (String)combox.getValue();
        java.sql.Date date = java.sql.Date.valueOf(Datev.getValue());
        String Prixv=Prix.getText();
        System.out.println(date);
        Scontrole_Voyage sc= new Scontrole_Voyage();   
        ServiceVoyage ps = new ServiceVoyage();

        

        if( Destinationv.isEmpty()){           
            Alert alert =new Alert(Alert.AlertType.CONFIRMATION);            
            alert.setContentText("champs vides");
            alert.setTitle("Prolem");
        alert.setHeaderText(null);
            alert.showAndWait(); 
       } else if (! sc.isNumeric(Prixv)){
          Alert alert =new Alert(Alert.AlertType.CONFIRMATION);            
            alert.setContentText("Age doit étre un nombre");
            alert.showAndWait();   
        }
        else {
                   voyage v = new voyage(Destinationv,Nom_Voyagev,Duree_Voyagev,date,Valabilitev,URLImage.getText(),Float.parseFloat(Prixv));
            ps.AjouterVoyage(v);
             refresh();
             Alert alert =new Alert(Alert.AlertType.CONFIRMATION);   
             alert.setTitle("succes");
             alert.setHeaderText(null);
            alert.setContentText("Voyage ajouter");
            alert.showAndWait();
        }}                 

    @FXML
    private void ModVoy(ActionEvent event) {
                Scontrole_Voyage sc= new Scontrole_Voyage();   

        voyage voy=new voyage();
   ServiceVoyage sv = new ServiceVoyage();
   voy=TableVoyage.getSelectionModel().getSelectedItem();
   voy.setID(TableVoyage.getSelectionModel().getSelectedItem().getID());   
   voy.setDestination(Destination.getText());
   voy.setNom_voyage(Nom_Voyage.getText());
   voy.setDuree_voyage(Duree_Voyage.getText());
           java.sql.Date date = java.sql.Date.valueOf(Datev.getValue());
   voy.setDate(date);
   String Valabilite = (String)combox.getValue();
   voy.setValabilite(Valabilite);
   voy.setImage(URLImage.getText());
if (! sc.isNumeric(Prix.getText())){
          Alert alert =new Alert(Alert.AlertType.CONFIRMATION);            
            alert.setContentText("Age doit étre un nombre");
            alert.showAndWait();   
        }
        else {
       voy.setPrix(Float.parseFloat(Prix.getText()));
   sv.ModifierVoyage(voy);
   loadvoy(); 
   refresh();
             Alert alert =new Alert(Alert.AlertType.CONFIRMATION);   
             alert.setTitle("succes");
             alert.setHeaderText(null);
            alert.setContentText("Voyage Modifier Avec succ");
            alert.showAndWait();
        }

    }   
 
    @FXML
    private void Recherche(KeyEvent event) {
        
        ServiceVoyage bs=new ServiceVoyage(); 
        voyage b= new voyage();
        ObservableList<voyage>filter= bs.chercherTitreplat(Recherche.getText());
        populateTable(filter);
    }
     private void populateTable(ObservableList<voyage> branlist){
       TableVoyage.setItems(branlist);
   
       }

    @FXML
    private void PDF(MouseEvent event) throws SQLException {
        ServiceVoyage sv = new ServiceVoyage();
        ObservableList<voyage> list = sv.getvoyageList();
        try {
            OutputStream file = new FileOutputStream(new File("‪C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\Dynamic-Developers\\Voyage.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            Font font = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
            Paragraph pdfTitle = new Paragraph("Liste des Voyage", font);
            pdfTitle.setAlignment(Element.ALIGN_CENTER);    
            
            document.add(pdfTitle);
            document.add(new Chunk("\n"));
            PdfPTable table = new PdfPTable(7);
            table.setHeaderRows(1);
            table.addCell("Destination");
            table.addCell("Nom_Voyage");
            table.addCell("Duree_Voyage");
            table.addCell("date");
            table.addCell("Valabilite");
            table.addCell("Image");
            table.addCell("Prix");
            list.forEach((_item) -> {
                table.addCell(_item.getDestination());
            table.addCell(_item.getNom_voyage());
            table.addCell(_item.getDuree_voyage());
            table.addCell(String.valueOf(_item.getDate()));
            table.addCell(_item.getValabilite());
            table.addCell(_item.getImage());
            table.addCell(String.valueOf(_item.getPrix()));
            });
            document.add(table);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Success");
            alert.setContentText("Success!");
            document.close();
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Cannot export data!");
            alert.show();        }
    }

    @FXML
    private void OnStatClicked(ActionEvent event) {
        try {
                   
            Parent parent = FXMLLoader.load(getClass().getResource("/Gui/VoyageStatValabilite.fxml"));
            Scene scene = new Scene(parent);
            
            Stage stage = new Stage();
            //stage.getIcons().add(new Image("/images/logo.png"));
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Excel(ActionEvent event) throws IOException {
        Writer writer = null;
        
         try {
            //badel path fichier excel
            File file = new File("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\Dynamic-Developers\\Voyage.csv");
            writer = new BufferedWriter(new FileWriter(file));
            for (voyage ev : list) {

                String text = ev.getDestination()+"," +ev.getNom_voyage()+ "," + ev.getDuree_voyage()+ ","+ev.getDate()+","+ev.getValabilite()+","+ev.getImage()+","+ev.getPrix()+ "\n";
                System.out.println(text);
                writer.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {

            writer.flush();
             writer.close();
             Alert alert= new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("excel");
        alert.setHeaderText(null);
        alert.setContentText("!!!excel exported!!!");
        alert.showAndWait();
        }
    }

    @FXML
    private void Map(ActionEvent event) {
        Stage stage = new Stage ();
         
        final WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webEngine.load(getClass().getResource("/Gui/googleMaps.html").toString());
       
        // create scene
       // stage.getIcons().add(new Image("/Assets/logo.png"));
        stage.setTitle("localisation");
        Scene scene = new Scene(webView,1000,700, Color.web("#666970"));
        stage.setScene(scene);
        // show stage
        stage.show();

    }

    private void notiff()
    {
        ServiceVoyage sv = new ServiceVoyage();
        voyage v = new voyage();
                String Destinationv = Destination.getText();
        int y=sv.calculnb((Destination.getText()));
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("attention");
        tray.setMessage("il existe "+y+ " voyages a "+Destinationv+"");
tray.setNotificationType(NotificationType.INFORMATION);
tray.showAndDismiss(Duration.millis(2000));
    }
    @FXML
    private void notif(MouseEvent event) {
        notiff();
    }

    @FXML
    private void Media_Video(ActionEvent event) {
        if(TableVoyage.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Warnning");
            alert.setHeaderText("SELECT YOUR Voyage");
            Optional<ButtonType> result1 = alert.showAndWait();}
       else{
            try {
                Parent root;

                root = FXMLLoader.load(getClass().getResource("Media_Voyage.fxml"));

                Media.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    @FXML
    private void OnStat(ActionEvent event) {
                try {                               
            Parent parent = FXMLLoader.load(getClass().getResource("/Gui/VoyageStatPrix.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //stage.getIcons().add(new Image("/images/logo.png"));
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void OnStatClickedDestination(ActionEvent event) {
            try {                               
            Parent parent = FXMLLoader.load(getClass().getResource("/Gui/VoyageStat.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            //stage.getIcons().add(new Image("/images/logo.png"));
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());}
    }

    @FXML
    private void reset(ActionEvent event) {
                    clear();

    }
}
