/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a29.services;

import edu.connexion3a29.entities.Restaurant;
import edu.connexion3a29.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class RestaurantCrud {
     public void ajouter_restaurant(Restaurant r) {
        try {
            String requete1 = "INSERT INTO restaurants(Nom_Restaurant,Adresse_Restaurant,Num_Tel_Restaurant,Description_Restaurant) VALUES(?,?,?,?)";
            PreparedStatement pst = MyConnection.getinstance().getCnx().prepareStatement(requete1);
            pst.setString(1, r.getNom_Restaurant());
            pst.setString(2, r.getAdresse_Restaurant());
            pst.setInt(3, r.getNum_Tel_Restaurant());
            pst.setString(4, r.getDescription_Restaurant());
            pst.executeUpdate();
            System.out.println("Restaurant ajouté !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       public ObservableList<Restaurant> listerRestaurants() {
        ObservableList<Restaurant> myList = FXCollections.observableArrayList();
        try {

            String requete2 = "Select * FROM restaurants";
            Statement st = MyConnection.getinstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while (rs.next()) {
                Restaurant rec = new Restaurant();
                rec.setId(rs.getInt(1));
                rec.setNom_Restaurant(rs.getString("Nom_Restaurant"));
                rec.setAdresse_Restaurant(rs.getString("Adresse_Restaurant"));
                rec.setNum_Tel_Restaurant(rs.getInt("Num_Tel_Restaurant"));
                rec.setDescription_Restaurant(rs.getString("Description_Restaurant"));
                myList.add(rec);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return myList;
    }
           public void supprimer_restaurant(Restaurant R) {

        try {
            String requete3 = "DELETE FROM restaurants WHERE id=" + R.getId();
            Statement st = MyConnection.getinstance().getCnx().createStatement();

            st.executeUpdate(requete3);
            System.out.println("Restaurant supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
//                 public void supprimer_restaurant(int id) {
//
//        try {
//            String requete3 = "DELETE FROM restaurants WHERE id=" + id;
//            Statement st = MyConnection.getinstance().getCnx().createStatement();
//
//            st.executeUpdate(requete3);
//            System.out.println("Restaurant supprimé !");
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//
//    }

    public void modifier_restaurant(Restaurant r, String Nom_Restaurant, String Adresse_Restaurant,int Num_Tel_Restaurant ,String Description_Restaurant) {
        try {
            String requete4 = " UPDATE restaurants SET " + "  Nom_Restaurant= ?, Adresse_Restaurant = ? , Num_Tel_Restaurant  = ?,Description_Restaurant = ? WHERE id= " + r.getId();
            PreparedStatement pst = MyConnection.getinstance().getCnx().prepareStatement(requete4);
            pst.setString(1, Nom_Restaurant);
            pst.setString(2, Adresse_Restaurant);
            pst.setInt(3, Num_Tel_Restaurant);
            pst.setString(4, Description_Restaurant);
            pst.executeUpdate();
            System.out.println("Restaurant modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
//    }
//               public void modifier_restaurant(int id,String Nom_Restaurant, String Adresse_Restaurant,int Num_Tel_Restaurant ,String Description_Restaurant) {
//        try {
//            String requete4 = " UPDATE restaurants SET " + "  Nom_Restaurant= ?, Adresse_Restaurant = ? , Num_Tel_Restaurant  = ?,Description_Restaurant = ? WHERE id= "+ id;
//            PreparedStatement pst = MyConnection.getinstance().getCnx().prepareStatement(requete4);
//            pst.setString(1, Nom_Restaurant);
//            pst.setString(2, Adresse_Restaurant);
//            pst.setInt(3, Num_Tel_Restaurant);
//            pst.setString(4, Description_Restaurant);
//            pst.executeUpdate();
//            System.out.println("Restaurant modifié !");
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }
    
}
