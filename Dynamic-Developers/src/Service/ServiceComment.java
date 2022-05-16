/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Comment;
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
            String req = "insert into commentaire(client_id,commentaire,posts_id) values("+t.getIdClient()+ ",'" + t.getCommentaire()+"'," + t.getIdpost()+ ");";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Comment ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(Comment t) {
        try {
          
            String req = "update commentaire set commentaire=? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            ps.setString(1, t.getCommentaire());
            ps.setInt(2, (int) t.getId());
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
              
                p.setCommentaire(rs.getString("commentaire"));
         

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
     
      public boolean UserPost(int id ,int idc) {
        List<Comment> posts = new ArrayList<>();
        try {
            String req = "select * from commentaire where client_id = " + idc +" and id = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Comment p = new Comment();
                p.setId(rs.getInt("id"));
                
               posts.add(p);
            }
           // System.out.print(!posts.isEmpty());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (posts.size()==0)
            return false ;
        else 
            return true;
    }
 public User OneUser(int idu) {
           User u = new User();
        try {
            String req = "select * from user where id= "+idu;
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
