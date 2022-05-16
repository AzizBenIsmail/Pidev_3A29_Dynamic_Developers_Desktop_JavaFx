/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Reclamation;
import Entity.User;
import Util.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Oumayma
 */
public class ServiceReclamation  {

    Connection cnx;

    public ServiceReclamation() {
        cnx = MyDB.getInsatnce().getConnection();
    }


    public void ajouter(Reclamation t) {
        try {
            String req = "insert into reclamation(client_id,objet,type_de_reclamation,description_reclamation,etat) values( " +t.getIdc()+",' " + t.getObjet()+ "','" + t.getTypeR()+ "','"
                    + t.getDescriptionR()+"','Non traité');";
          
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reclamation ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(Reclamation t) {
        try {
            String req = "update reclamation set objet=?,type_de_reclamation=?,description_reclamation=? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getObjet());
            ps.setString(2, t.getTypeR());
            ps.setString(3, t.getDescriptionR());
            ps.setInt(4, (int) t.getId());
            ps.executeUpdate();
            System.out.println("Reclamation modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void Supprimer(int id) {
    try
    { 
      Statement st = cnx.createStatement();
      String req = "DELETE FROM reclamation WHERE id = "+id+"";
                st.executeUpdate(req);      
      System.out.println("Reclamation supprimer avec succès...");
    } catch (SQLException ex) {
                System.out.println(ex.getMessage());        
              }
    }


    public List<Reclamation> recuperer() {
        List<Reclamation> reclamations = new ArrayList<>();
        try {
            String req = "select * from reclamation order by date DESC";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Reclamation p = new Reclamation();
                p.setId(rs.getInt(1));
                p.setObjet(rs.getString("objet"));
                p.setTypeR(rs.getString("type_de_reclamation"));
                p.setDescriptionR(rs.getString("description_reclamation"));
                p.setDateR(rs.getString("date"));
               reclamations.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reclamations;
    }
    
      public List<Reclamation> recupererUser(int idu) {
        List<Reclamation> reclamations = new ArrayList<>();
        try {
            String req = "select * from reclamation where client_id='"+idu+"' order by date DESC";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Reclamation p = new Reclamation();
                p.setId(rs.getInt(1));
                p.setObjet(rs.getString("objet"));
                p.setTypeR(rs.getString("type_de_reclamation"));
                p.setDescriptionR(rs.getString("description_reclamation"));
                p.setDateR(rs.getString("date"));
               reclamations.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reclamations;
    }
      
public ObservableList<Reclamation> getall() {
        ObservableList<Reclamation> reclamations = FXCollections.observableArrayList();
        try {
            String req = "select * from reclamation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Reclamation p = new Reclamation();
                p.setId(rs.getInt(1));
                p.setObjet(rs.getString("objet"));
                p.setTypeR(rs.getString("type_de_reclamation"));
                p.setDescriptionR(rs.getString("description_reclamation"));
                p.setDateR(rs.getString("date"));
                p.setEtat(rs.getString("etat"));
               reclamations.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reclamations;
    }
      public void traiter(Reclamation t) {
        try {
            String req = "update reclamation set etat=? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, "traité");
            
        
            ps.setInt(2, (int) t.getId());
            ps.executeUpdate();
            System.out.println("Reclamation modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

      }
      
      public User OneUser(int idu) {
           User u = new User();
        try {
            String req = "select * from user where id="+idu;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

           while (rs.next()) {
                u.setCIN(rs.getInt("cin"));
                u.setAdresse(rs.getString("adresse"));
                u.setEmail(rs.getString("email"));
                u.setId(idu);
                u.setNumero(rs.getInt("numero"));
                u.setRoles(rs.getString("roles"));
                u.setUserName(rs.getString("user_name"));
                System.out.println(u);
              
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u ;
    }
}