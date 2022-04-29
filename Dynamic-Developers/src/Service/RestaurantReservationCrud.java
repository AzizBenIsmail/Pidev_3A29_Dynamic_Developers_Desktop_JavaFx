/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.RestaurantReservation;
import edu.connexion3a29.utils.MyConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


/**
 *
 * @author ASUS
 */
public class RestaurantReservationCrud {
     public void ajouter_restaurantreservation(RestaurantReservation r) {
        try {
            String requete1 = "INSERT INTO resrrest(Nom_Restaurant,nom_Client,Nbr_Personne,Date_Reservation) VALUES(?,?,?,?)";
            PreparedStatement pst = MyConnection.getinstance().getCnx().prepareStatement(requete1);
            pst.setDate(4, r.getDate_Reservation());
            pst.setInt(3, r.getNbr_Personne());
            pst.setString(2, r.getNom_Client());
            pst.setString(1, r.getNom_Restaurant());
            pst.executeUpdate();
            System.out.println(" Reservation Restaurant ajouté !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       public ObservableList<RestaurantReservation> listerRestaurantReservations() {
        ObservableList<RestaurantReservation> myList = FXCollections.observableArrayList();
        try {

            String requete2 = "Select * FROM resrrest";
            Statement st = MyConnection.getinstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while (rs.next()) {
                RestaurantReservation rec = new RestaurantReservation();
                   rec.setId(rs.getInt(1));
                   rec.setNom_Restaurant(rs.getString("Nom_Restaurant"));
                   rec. setNom_Client(rs.getString("nom_Client"));
                   rec.setNbr_Personne(rs.getInt("Nbr_Personne"));
                   rec.setDate_Reservation(rs.getDate("Date_Reservation"));
              
              
                myList.add(rec);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return myList;
    }
           public void supprimer_RestaurantReservation(RestaurantReservation R) {

        try {
            String requete3 = "DELETE FROM resrrest WHERE id=" + R.getId();
            Statement st = MyConnection.getinstance().getCnx().createStatement();

            st.executeUpdate(requete3);
            System.out.println(" Reservation Restaurant  supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
//                 public void supprimer_RestaurantReservation(int id) {
//
//        try {
//            String requete3 = "DELETE FROM restaurantsreservations WHERE id=" + id;
//            Statement st = MyConnection.getinstance().getCnx().createStatement();
//
//            st.executeUpdate(requete3);
//            System.out.println("Reservation Restaurant supprimé !");
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//
//    }

    public void modifier_RestaurantReservation(RestaurantReservation r,String Nom_Restaurant, String nom_Client,int Nbr_Personne,Date Date_Reservation) {
        try {
            String requete4 = " UPDATE resrrest SET " + " Nom_Restaurant = ?,nom_Client=?, Nbr_Personne = ? ,Date_Reservation= ? WHERE id= " + r.getId();
            PreparedStatement pst = MyConnection.getinstance().getCnx().prepareStatement(requete4);
            pst.setString(1, Nom_Restaurant);
               pst.setString(2, nom_Client);
               pst.setInt(3, Nbr_Personne);
               pst.setDate(4, Date_Reservation);
            pst.executeUpdate();
            System.out.println("Reservation Restaurant modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
//               public void modifier_RestaurantReservation(int id,String Nom_Restaurant, String nom_Client,int Nbr_Personne,Date Date_Reservation) {
//        try {
//            String requete4 = " UPDATE restaurantsreservations SET " + " Nom_Restaurant = ?,nom_Client=?, Nbr_Personne = ? ,Date_Reservation= ?WHERE id= "+ id;
//            PreparedStatement pst = MyConnection.getinstance().getCnx().prepareStatement(requete4);
//               pst.setString(1, Nom_Restaurant);
//               pst.setString(2, nom_Client);
//               pst.setInt(3, Nbr_Personne);
//               pst.setDate(4, Date_Reservation);
//               pst.executeUpdate();
//            System.out.println("Reservation Restaurant modifié !");
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }
    
            
}
