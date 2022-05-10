/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Comment;
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

/**
 *
 * @author Oumayma
 */
public class ServiceComment  {

    Connection cnx;

    public ServiceComment() {
        cnx = MyDB.getInsatnce().getConnection();
    }


    public void ajouter(Comment t) {
        try {
            String req = "insert into commentaire(client_id,objet,commentaire,posts_id) values(1,' " + t.getObjet()+ "','" + t.getCommentaire()+"','" + t.getIdpost()+ "');";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Comment ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(Comment t) {
        try {
          
            String req = "update commentaire set objet=?,commentaire=? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getObjet());
            ps.setString(2, t.getCommentaire());
            ps.setInt(3, (int) t.getId());
            ps.executeUpdate();
            System.out.println("Comment modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void Supprimer(int id) {
    try
    { 
      Statement st = cnx.createStatement();
      String req = "DELETE FROM commentaire WHERE id = "+id+"";
                st.executeUpdate(req);      
      System.out.println("Comment supprimer avec succès...");
    } catch (SQLException ex) {
                System.out.println(ex.getMessage());        
              }
    }


    public List<Comment> recuperer(int idp) {
        List<Comment> comments = new ArrayList<>();
        try {
            String req = "select * from commentaire where posts_id= "+idp;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Comment p = new Comment();
                p.setId(rs.getInt(1));
                p.setObjet(rs.getString("objet"));
                p.setCommentaire(rs.getString("commentaire"));
                p.setDatec(rs.getString("date_c"));
                p.setIdpost(idp);
               comments.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return comments;
    }
    
     public Comment detail(int id) {
        Comment p = new Comment();
        try {
            String req = "select * from commentaire where id ="+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
               
                p.setId(id);
                p.setObjet(rs.getString("objet"));
                p.setCommentaire(rs.getString("commentaire"));
         

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

}
