/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entity.Post;
import Entity.PostLike;
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
public class ServicePost  {

    Connection cnx;

    public ServicePost() {
        cnx = MyDB.getInsatnce().getConnection();
    }


    public boolean ajouter(Post t) {
        boolean a=false;
        try {
            String req = "insert into post(client_id,description_p,hashtag_p,visibilite,image_p) values("+t.getIdc()+",' " + t.getDescriptionP()+ "','" + t.getHashtagP()+ "','"
                    + t.getVisibilite()+ "','" +t.getImageP()+"');";
          
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Post ajoutée");
            a=true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
    
    public void modifier(Post t) {
        try {
            String req = "update post set description_p=?,hashtag_p=?,visibilite=? , image_p=? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getDescriptionP());
            ps.setString(2, t.getHashtagP());
            ps.setString(3, t.getVisibilite());
            ps.setInt(4, (int) t.getId());
            ps.setString(4, t.getImageP());
            ps.executeUpdate();
            System.out.println("Post modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void Supprimer(int id) {
    try
    { 
      Statement st = cnx.createStatement();
      String req = "DELETE FROM post WHERE id = "+id+"";
                st.executeUpdate(req);      
      System.out.println("post supprimer avec succès...");
    } catch (SQLException ex) {
                System.out.println(ex.getMessage());        
              }
    }


    public List<Post> recuperer() {
        List<Post> posts = new ArrayList<>();
        try {
            String req = "select * from post ORDER BY date_p DESC";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt(1));
                p.setDescriptionP(rs.getString("description_p"));
                p.setHashtagP(rs.getString("hashtag_p"));
                p.setVisibilite(rs.getString("visibilite"));
                p.setDateP(rs.getString("date_p"));
                p.setImageP(rs.getString("image_p"));
                p.setIdc(rs.getInt("client_id"));
               posts.add(p);
            }
            System.out.print(posts);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return posts;
    }
    
    public List<Post> recupererhashtag(String hashtag) {
        List<Post> posts = new ArrayList<>();
        try {
            String req = "select * from post where hashtag_p = '" + hashtag+"' ORDER BY date_p DESC";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt(1));
                p.setDescriptionP(rs.getString("description_p"));
                p.setHashtagP(rs.getString("hashtag_p"));
                p.setVisibilite(rs.getString("visibilite"));
                p.setDateP(rs.getString("date_p"));
                p.setImageP(rs.getString("image_p"));
                p.setIdc(rs.getInt("client_id"));
               posts.add(p);
            }
            System.out.print(posts);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return posts;
    }
    
    public List<PostLike> likes (int id){
        List<PostLike> posts = new ArrayList<>();
        try {
            String req = "select * from post_like where post_id =" +id+";";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                PostLike p = new PostLike();
                p.setId(rs.getInt("id"));
                p.setIdpost(rs.getInt("post_id"));
                p.setIduser(rs.getInt("client_id"));
                posts.add(p);
            }
            //System.out.print(posts);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return posts ; 
    }
    
     public List<PostLike> islikedbyuser(int idp,int idc) {
        
        List<PostLike> posts = new ArrayList<>();
        try {
            String req = "Select * from post_like where client_id= '"+idc+ "'and post_id ='"+idp+"';";
          
             Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                PostLike p = new PostLike();
                p.setId(rs.getInt("id"));
                p.setIdpost(rs.getInt("post_id"));
                p.setIduser(rs.getInt("client_id"));
                posts.add(p);
            }
            System.out.println(posts.size());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return posts;
    }
     public void Supprimerlike(int id, int idc ) {
    try
    { 
      Statement st = cnx.createStatement();
      String req = "DELETE FROM post_like WHERE post_id = '"+id+"' and client_id= '"+idc+"';";
                st.executeUpdate(req);      
      System.out.println("post supprimer avec succès...");
    } catch (SQLException ex) {
                System.out.println(ex.getMessage());        
              }
    }
     public boolean ajouterlike(int idp,int idc) {
        boolean a=false;
        try {
            String req = "insert into post_like(client_id,post_id) values("+idc+ "," +idp+")";
          
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            //System.out.println("like ajoutée");
            a=true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
    

     public int comments (int id){
        List<Post> posts = new ArrayList<>();
        try {
            String req = "select * from commentaire where posts_id = " +id+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setDescriptionP(rs.getString("client_id"));
                p.setHashtagP(rs.getString("posts_id"));
                p.setVisibilite(rs.getString("objet"));
                p.setDateP(rs.getString("commentaire"));
                p.setImageP(rs.getString("date_c"));
                p.setIdc(rs.getInt("client_id"));
               posts.add(p);
            }
            System.out.print(posts);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return posts.size(); 
    }
     
     public ObservableList<Post> getall() {
        ObservableList<Post> posts = FXCollections.observableArrayList();
        try {
            String req = "select * from post ORDER BY date_p ASC";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt(1));
                p.setDescriptionP(rs.getString("description_p"));
                p.setHashtagP(rs.getString("hashtag_p"));
                p.setVisibilite(rs.getString("visibilite"));
                p.setDateP(rs.getString("date_p"));
                p.setImageP(rs.getString("image_p"));
               posts.add(p);
            }
            System.out.print(posts);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return posts;
    }
    public boolean UserPost(int id ,int idc) {
        List<Post> posts = new ArrayList<>();
        try {
            String req = "select * from post where client_id = " + idc +" and id = "+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt(1));
                p.setDescriptionP(rs.getString("description_p"));
                p.setHashtagP(rs.getString("hashtag_p"));
                p.setVisibilite(rs.getString("visibilite"));
                p.setDateP(rs.getString("date_p"));
                p.setImageP(rs.getString("image_p"));
               posts.add(p);
            }
            System.out.print(posts);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return !posts.isEmpty();
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
