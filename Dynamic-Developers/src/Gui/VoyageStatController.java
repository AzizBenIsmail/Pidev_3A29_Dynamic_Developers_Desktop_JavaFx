/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Util.MyDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class VoyageStatController implements Initializable {

    @FXML
    private PieChart voy_stat;
    private Statement st;
    private ResultSet rs;
    private Connection cnx;
        ObservableList<PieChart.Data>data=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cnx = MyDB.getInsatnce().getConnection();
       stat();
    }    

    private void stat() {
          try{
            String query ="select COUNT(*),reservation_voyage.travel_class from voyage INNER JOIN reservation_voyage on reservation_voyage.voyage_id =voyage.id GROUP BY travel_class;";
            PreparedStatement PreparedStatement = cnx.prepareStatement(query);
             rs = PreparedStatement.executeQuery();
             while (rs.next()){               
               data.add(new PieChart.Data(rs.getString("travel_class"),rs.getInt("COUNT(*)")));
            }  
             
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
        
         voy_stat.setTitle("**Statistiques nombres des types de reservation du Voyage**");
        voy_stat.setLegendSide(Side.LEFT);
        voy_stat.setData(data);
    }
    
}
