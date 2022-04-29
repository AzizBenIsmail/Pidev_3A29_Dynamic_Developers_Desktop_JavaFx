/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Restaurant;
import edu.connexion3a29.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class RestaurantCrud {
     public void ajouter_restaurant(Restaurant r) {
        try {
            String requete1 = "INSERT INTO rest(Nom_Restaurant,Adresse_Restaurant,Num_Tel_Restaurant,Description_Restaurant) VALUES(?,?,?,?)";
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

            String requete2 = "Select * FROM rest";
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
            String requete3 = "DELETE FROM rest WHERE id=" + R.getId();
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
            String requete4 = " UPDATE rest SET " + "  Nom_Restaurant= ?, Adresse_Restaurant = ? , Num_Tel_Restaurant  = ?,Description_Restaurant = ? WHERE id= " + r.getId();
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
    
     public String bad_words(String badWord) {

        List<String> badListW = Arrays.asList("zebi", "sorem","nayek","asba lik","zabour","9ahba","khahba");
        String badNew = "";
        List<String> newList = new ArrayList<>();
        for (String str : badListW) {
            if (badWord.contains(str)) {
                badNew += "" + str;
                if (str.length() >= 1) {
                    StringBuilder result = new StringBuilder();
                    result.append(str.charAt(0));
                    for (int i = 0; i < str.length() - 2; ++i) {
                        result.append("*");
                    }
                    result.append(str.charAt(str.length() - 1));
                    str = result.toString();
                    if (!str.isEmpty()) {
                        System.out.println("ATTENTION !! Vous avez écrit un gros mot  : " + result + " .C'est un avertissement ! Priére d'avoir un peu de respect ! Votre description sera envoyée comme suit :");
                        System.out.println(badWord.replace(badNew, "") + " ");
                    }
                }
            }
        }
        return (badWord.replace(badNew, "") + " ");
    }
    
}
