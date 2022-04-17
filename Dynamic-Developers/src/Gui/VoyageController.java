/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.voyage;
import static Entity.voyage.filename;
import Service.ServiceVoyage;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
    @FXML
    private Button Modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceVoyage SV= new ServiceVoyage();
        TableVoyage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            VID.setText(String.valueOf(SV.listeVoyage().get(TableVoyage.getSelectionModel().getSelectedIndex()).getID()));
            VDest.setText(String.valueOf(SV.listeVoyage().get(TableVoyage.getSelectionModel().getSelectedIndex()).getDestination()));
            VNom.setText(String.valueOf(SV.listeVoyage().get(TableVoyage.getSelectionModel().getSelectedIndex()).getNom_voyage()));
            VDuree.setText(String.valueOf(SV.listeVoyage().get(TableVoyage.getSelectionModel().getSelectedIndex()).getDuree_voyage()));
            Vdate.setText(String.valueOf(SV.listeVoyage().get(TableVoyage.getSelectionModel().getSelectedIndex()).getDatevoy()));
            VValibilite.setText(String.valueOf(SV.listeVoyage().get(TableVoyage.getSelectionModel().getSelectedIndex()).getValabilite()));
            Vimage.setText(String.valueOf(SV.listeVoyage().get(TableVoyage.getSelectionModel().getSelectedIndex()).getImage()));
            Vprix.setText(String.valueOf(SV.listeVoyage().get(TableVoyage.getSelectionModel().getSelectedIndex()).getPrix()));
          
        };
        }); 
ObservableList<voyage> listV;
        try {
            listV=SV.getvoyageList();
        VID.setCellValueFactory(new PropertyValueFactory<>("id"));
        VDest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        VNom.setCellValueFactory(new PropertyValueFactory<>("nom_voyage"));
        VDuree.setCellValueFactory(new PropertyValueFactory<>("duree_voyage"));
        Vdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        VValibilite.setCellValueFactory(new PropertyValueFactory<>("valabilite"));
        Vimage.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<voyage, ImageView>, ObservableValue<ImageView>>() {
                @Override
                public ObservableValue<ImageView> call(TableColumn.CellDataFeatures<voyage, ImageView> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getImage());
                }
            }
);
        Vprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TableVoyage.setItems(listV);

        } catch (Exception e) {
        }
};

    @FXML
    private void Liste_Voyage(javafx.scene.input.MouseEvent event) {
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
        ObservableList<voyage> listV;
        try {
                    ServiceVoyage SV= new ServiceVoyage();
            listV=SV.getvoyageList();
        VID.setCellValueFactory(new PropertyValueFactory<>("id"));
        VDest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        VNom.setCellValueFactory(new PropertyValueFactory<>("nom_voyage"));
        VDuree.setCellValueFactory(new PropertyValueFactory<>("duree_voyage"));
        Vdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        VValibilite.setCellValueFactory(new PropertyValueFactory<>("valabilite"));
        Vimage.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<voyage, ImageView>, ObservableValue<ImageView>>() {
                @Override
                public ObservableValue<ImageView> call(TableColumn.CellDataFeatures<voyage, ImageView> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getImage());
                }
            }
);
        Vprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TableVoyage.setItems(listV);

        } catch (Exception e) {
        }
                TableVoyage.refresh();
    }

    @FXML
    private void Bientot_disponible(ActionEvent event) {
                ObservableList<voyage> listV;

        try {
                    ServiceVoyage SV= new ServiceVoyage();
            listV=SV.getvoyageBientot_Disponible();
        VID.setCellValueFactory(new PropertyValueFactory<>("id"));
        VDest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        VNom.setCellValueFactory(new PropertyValueFactory<>("nom_voyage"));
        VDuree.setCellValueFactory(new PropertyValueFactory<>("duree_voyage"));
        Vdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        VValibilite.setCellValueFactory(new PropertyValueFactory<>("valabilite"));
        Vimage.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<voyage, ImageView>, ObservableValue<ImageView>>() {
                @Override
                public ObservableValue<ImageView> call(TableColumn.CellDataFeatures<voyage, ImageView> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getImage());
                }
            }
);
        Vprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TableVoyage.setItems(listV);

        } catch (Exception e) {
        }
                TableVoyage.refresh();
    }

    @FXML
    private void Disponible(ActionEvent event) {
                ObservableList<voyage> listV;

        try {
                    ServiceVoyage SV= new ServiceVoyage();
            listV=SV.getvoyageDisponible();
        VID.setCellValueFactory(new PropertyValueFactory<>("id"));
        VDest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        VNom.setCellValueFactory(new PropertyValueFactory<>("nom_voyage"));
        VDuree.setCellValueFactory(new PropertyValueFactory<>("duree_voyage"));
        Vdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        VValibilite.setCellValueFactory(new PropertyValueFactory<>("valabilite"));
        Vimage.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<voyage, ImageView>, ObservableValue<ImageView>>() {
                @Override
                public ObservableValue<ImageView> call(TableColumn.CellDataFeatures<voyage, ImageView> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getImage());
                }
            }
);
        Vprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TableVoyage.setItems(listV);

        } catch (Exception e) {
        }
                TableVoyage.refresh();
    }

    @FXML
    private void Non_Disponible(ActionEvent event) {
                ObservableList<voyage> listV;
        try {
                    ServiceVoyage SV= new ServiceVoyage();
            listV=SV.getvoyageNon_Disponible();
        VID.setCellValueFactory(new PropertyValueFactory<>("id"));
        VDest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        VNom.setCellValueFactory(new PropertyValueFactory<>("nom_voyage"));
        VDuree.setCellValueFactory(new PropertyValueFactory<>("duree_voyage"));
        Vdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        VValibilite.setCellValueFactory(new PropertyValueFactory<>("valabilite"));
        Vimage.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<voyage, ImageView>, ObservableValue<ImageView>>() {
                @Override
                public ObservableValue<ImageView> call(TableColumn.CellDataFeatures<voyage, ImageView> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getImage());
                }
            }
);
        Vprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TableVoyage.setItems(listV);

        } catch (Exception e) {
        }
                TableVoyage.refresh();
    }

    @FXML
    private void Modifier(ActionEvent event)  throws IOException{

          FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierVoyage.fxml"));
    Parent root = loader.load();
    ModifierVoyageController vc = loader.getController();
    vc.setDestination(TableVoyage.getSelectionModel().getSelectedItem().getDestination());
            vc.setNom_Voyage(TableVoyage.getSelectionModel().getSelectedItem().getNom_voyage());
            vc.setDuree_Voyage(TableVoyage.getSelectionModel().getSelectedItem().getDuree_voyage());
            vc.setValabilite(TableVoyage.getSelectionModel().getSelectedItem().getValabilite());
          //  vc.setPrix(TableVoyage.getSelectionModel().getSelectedItem().getPrix());
                          Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
    
}
