/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entity.User;
import Util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class UserCRUD {
    
    Connection cnx2;
    public UserCRUD(){
        cnx2 = MyConnection.getInstance().getCnx();
    }
   public void supprimerUtilisateur(User user) {
        try {
            String requete="delete from user where id=?";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setInt(1,user.getId());
            pst.executeUpdate();
           
            System.out.println("Utlisateur est supprimée");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }}
   public void modifierUtilisateur(User user) {
        try {
            String requete2="update user set cin=?,user_name=?,numero=?,email=?,adresse=? where id=?";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setInt(1, user.getCIN());
            pst.setString(2, user.getUserName());
            pst.setInt(3, user.getNumero());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getAdresse());
            pst.setInt(6, user.getId());
            pst.executeUpdate();
           
            System.out.println("Utlisateur est modifié");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }}
    
    
}
