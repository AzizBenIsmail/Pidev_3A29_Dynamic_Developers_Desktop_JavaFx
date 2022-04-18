    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.voyage;
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
 * @author ASUS
 */
public class ServiceVoyage implements IServise<voyage>{

    Connection cnx;

    public ServiceVoyage() {
                cnx=MyDB.getInsatnce().getConnection();
    }

    @Override
    public void AjouterVoyage(voyage v) {
         try {
                String req = "insert into voyage(id,clien_id,destination,nom_voyage,duree_voyage,date,valabilite,image,prix)"
                        +"values("+v.getID()+","+1+",'"+v.getDestination()+"','"+v.getNom_voyage()+"','"+v.getDuree_voyage()+"',"+v.getDatevoy()+","
                        +"'"+v.getValabilite()+"','"+v.getImage()+"',"+v.getPrix()+")";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Voyage ajouter avec succ");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());        }    }

    @Override
    public void ModifierVoyage(voyage v) {
        try {

// String req ="UPDATE `voyage` SET `clien_id`='19',`destination`='ag',`nom_voyage`='18',`duree_voyage`='15',`date`='0000-00-00',`valabilite`='12',`image`='12',`prix`='12' WHERE id=33;";
            
            String req ="UPDATE voyage SET clien_id=1,destination=?,nom_voyage=?,duree_voyage=?,date=?,valabilite=?,image=?,prix=? WHERE id=?;";
            PreparedStatement ps= cnx.prepareStatement(req); //req dynamic plus securiser
           
            ps.setString(1,v.getDestination());
            ps.setString(2,v.getNom_voyage());
            ps.setString(3,v.getDuree_voyage());
            ps.setDate(4,null);
            ps.setString(5,v.getValabilite());
            ps.setString(6,v.getImage());
            ps.setInt(7,(int)v.getPrix());
            ps.setInt(8,v.getID());

           ps.executeUpdate();
                        System.out.println("voyage Modifer avec succ");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceVoyage.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @Override
    public void SupprimerVoyage(int ID) {
			try
    { 
      Statement st = cnx.createStatement();
      String req = "DELETE FROM voyage WHERE id = "+ID+"";
                st.executeUpdate(req);      
      System.out.println("L'Voyage avec l'id = "+ID+" a été supprimer avec succès...");
    } catch (SQLException ex) {
                System.out.println(ex.getMessage());        
              }
    }

    @Override
    public List<voyage> RecupererVoyage() {
 List<voyage> voyage = new ArrayList<>();
        try {
            String req ="select * from voyage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               voyage v = new voyage();
               v.setID(rs.getInt("id"));
               v.setDestination(rs.getString("destination"));
               v.setNom_voyage(rs.getString("nom_voyage"));
               v.setDuree_voyage(rs.getString("duree_voyage"));
               v.setValabilite(rs.getString("valabilite"));
               v.setImage(rs.getString("image"));
               v.setPrix(rs.getInt("prix"));
               
               voyage.add(v);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return voyage;    }


@Override
    public List<voyage> RecupererVoyagetrieDestination() {
 List<voyage> voyage = new ArrayList<>();
        try {
            String req ="select * from voyage order by Destination";
            Statement st = cnx.createStatement();   //req statique 
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               voyage v = new voyage();
               v.setID(rs.getInt("id"));
               v.setDestination(rs.getString("destination"));
               v.setNom_voyage(rs.getString("nom_voyage"));
               v.setDuree_voyage(rs.getString("duree_voyage"));
               v.setValabilite(rs.getString("valabilite"));
               v.setImage(rs.getString("image"));
               v.setPrix(rs.getInt("prix"));
               
               voyage.add(v);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return voyage;    }
    
    @Override
    public List<voyage> RechercheVoyage(String dest) {
 List<voyage> voyage = new ArrayList<>();
        try {
            String req ="select * from voyage WHERE destination = '"+dest+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               voyage v = new voyage();
               v.setID(rs.getInt("id"));
               v.setDestination(rs.getString("destination"));
               v.setNom_voyage(rs.getString("nom_voyage"));
               v.setDuree_voyage(rs.getString("duree_voyage"));
               v.setValabilite(rs.getString("valabilite"));
               v.setImage(rs.getString("image"));
               v.setPrix(rs.getInt("prix"));
               
               voyage.add(v);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return voyage;    }

    @Override
    public List<voyage> RecupererVoyageDisponible() {
List<voyage> voyage = new ArrayList<>();
        try {
            String req ="select * from voyage WHERE valabilite = 'Disponible'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               voyage v = new voyage();
               v.setID(rs.getInt("id"));
               v.setDestination(rs.getString("destination"));
               v.setNom_voyage(rs.getString("nom_voyage"));
               v.setDuree_voyage(rs.getString("duree_voyage"));
               v.setValabilite(rs.getString("valabilite"));
               v.setImage(rs.getString("image"));
               v.setPrix(rs.getInt("prix"));
               
               voyage.add(v);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return voyage;        }

    @Override
    public List<voyage> RecupererVoyageNonDisponible() {
List<voyage> voyage = new ArrayList<>();
        try {
            String req ="select * from voyage WHERE valabilite = 'Non Disponible'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               voyage v = new voyage();
               v.setID(rs.getInt("id"));
               v.setDestination(rs.getString("destination"));
               v.setNom_voyage(rs.getString("nom_voyage"));
               v.setDuree_voyage(rs.getString("duree_voyage"));
               v.setValabilite(rs.getString("valabilite"));
               v.setImage(rs.getString("image"));
               v.setPrix(rs.getInt("prix"));
               
               voyage.add(v);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return voyage;   
    }

    @Override
    public List<voyage> RecupererVoyageBientotdisponible() {
List<voyage> voyage = new ArrayList<>();
        try {
            String req ="select * from voyage WHERE valabilite = 'Bientot Disponible'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               voyage v = new voyage();
               v.setID(rs.getInt("id"));
               v.setDestination(rs.getString("destination"));
               v.setNom_voyage(rs.getString("nom_voyage"));
               v.setDuree_voyage(rs.getString("duree_voyage"));
               v.setValabilite(rs.getString("valabilite"));
               v.setImage(rs.getString("image"));
               v.setPrix(rs.getInt("prix"));
               
               voyage.add(v);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return voyage;   
    }
     public List <voyage> listeVoyage()
    {
        String sql = "select id,destination, nom_voyage, duree_voyage,date,valabilite,image,prix from voyage";
        
       List <voyage> list = new ArrayList<>(); 
       try {
       PreparedStatement ps=cnx.prepareStatement(sql);
         ResultSet rs=ps.executeQuery();
       
       while (rs.next())
       {
           list.add(new voyage(rs.getInt("id"),rs.getString("destination"),rs.getString("nom_voyage"),rs.getString("duree_voyage"),rs.getDate("date"),rs.getString("valabilite"),rs.getString("image"),rs.getFloat("prix")));
       }
       
       }
       catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    return list; 
    }
    
    //--------------------------------- getvoyageList() ------------------------------------------------------//
    public ObservableList<voyage> getvoyageList() throws SQLException
    {
        ObservableList<voyage> voyagelist = FXCollections.observableArrayList();
        
       Statement ps=cnx.createStatement();
        String sql = "select id,destination, nom_voyage, duree_voyage,date,valabilite,image,prix from voyage";
        ResultSet rs;
        rs = ps.executeQuery(sql);
        voyage voyage;
        while (rs.next()) {
           voyage= new voyage(rs.getInt("id"),rs.getString("destination"),rs.getString("nom_voyage"),rs.getString("duree_voyage"),rs.getDate("date"),rs.getString("valabilite"),rs.getString("image"),rs.getFloat("prix"));  
            //System.out.println(events);
            voyagelist.add(voyage);

        }
         return voyagelist;    
    }
    public ObservableList<voyage> getvoyageNon_Disponible() throws SQLException
    {
        ObservableList<voyage> voyagelist = FXCollections.observableArrayList();
        
       Statement ps=cnx.createStatement();
        String sql = "select id,destination, nom_voyage, duree_voyage,date,valabilite,image,prix from voyage WHERE valabilite = 'Non Disponible'";
        ResultSet rs;
        rs = ps.executeQuery(sql);
        voyage voyage;
        while (rs.next()) {
           voyage= new voyage(rs.getInt("id"),rs.getString("destination"),rs.getString("nom_voyage"),rs.getString("duree_voyage"),rs.getDate("date"),rs.getString("valabilite"),rs.getString("image"),rs.getFloat("prix"));  
            //System.out.println(events);
            voyagelist.add(voyage);

        }
         return voyagelist;    
    }
        public ObservableList<voyage> getvoyageDisponible() throws SQLException
    {
        ObservableList<voyage> voyagelist = FXCollections.observableArrayList();
        
       Statement ps=cnx.createStatement();
        String sql = "select id,destination, nom_voyage, duree_voyage,date,valabilite,image,prix from voyage WHERE valabilite = 'Disponible'";
        ResultSet rs;
        rs = ps.executeQuery(sql);
        voyage voyage;
        while (rs.next()) {
           voyage= new voyage(rs.getInt("id"),rs.getString("destination"),rs.getString("nom_voyage"),rs.getString("duree_voyage"),rs.getDate("date"),rs.getString("valabilite"),rs.getString("image"),rs.getFloat("prix"));  
            //System.out.println(events);
            voyagelist.add(voyage);

        }
         return voyagelist;    
    }  public ObservableList<voyage> getvoyageBientot_Disponible() throws SQLException
    {
        ObservableList<voyage> voyagelist = FXCollections.observableArrayList();
        
       Statement ps=cnx.createStatement();
        String sql = "select id,destination, nom_voyage, duree_voyage,date,valabilite,image,prix from voyage WHERE valabilite = 'Bientot Disponible'";
        ResultSet rs;
        rs = ps.executeQuery(sql);
        voyage voyage;
        while (rs.next()) {
           voyage= new voyage(rs.getInt("id"),rs.getString("destination"),rs.getString("nom_voyage"),rs.getString("duree_voyage"),rs.getDate("date"),rs.getString("valabilite"),rs.getString("image"),rs.getFloat("prix"));  
            //System.out.println(events);
            voyagelist.add(voyage);

        }
         return voyagelist;    
    }
     //----------------------------------------  Display Destination by ID --------------------------------------------------------------//
     public String getDestinationID(int idxx)
    {
        try{
            PreparedStatement ps= cnx.prepareStatement("select * from voyage where id=?");
            ps.setInt(1, idxx);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            
            if (rs.next()) {
                return rs.getString("Destination");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(voyage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
     public String getnomID(int idxx)
    {
        try{
            PreparedStatement ps= cnx.prepareStatement("select * from voyage where id=?");
            ps.setInt(1, idxx);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            
            if (rs.next()) {
                return rs.getString("nom_voyage");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(voyage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
     public String getduree_voyageID(int idxx)
    {
        try{
            PreparedStatement ps= cnx.prepareStatement("select * from voyage where id=?");
            ps.setInt(1, idxx);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            
            if (rs.next()) {
                return rs.getString("duree_voyage");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(voyage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
     public String getvalabiliteID(int idxx)
    {
        try{
            PreparedStatement ps= cnx.prepareStatement("select * from voyage where id=?");
            ps.setInt(1, idxx);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            
            if (rs.next()) {
                return rs.getString("valabilite");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(voyage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
     
     public float getprixID(int idxx)
    {
        try{
            PreparedStatement ps= cnx.prepareStatement("select * from voyage where id=?");
            ps.setInt(1, idxx);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            
            if (rs.next()) {
                return rs.getFloat("prix");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(voyage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     public void modifier(voyage v ,int id) {
           try {
             
PreparedStatement ps= cnx.prepareStatement("UPDATE voyage SET clien_id=19,destination=?,nom_voyage=?,duree_voyage=?,date=?,valabilite=?,image=?,prix=? WHERE id=?");           
            ps.setString(1,v.getDestination());
            ps.setString(2,v.getNom_voyage());
            ps.setString(3,v.getDuree_voyage());
            ps.setDate(4,v.getDatevoy());
            ps.setString(5,v.getValabilite());
            ps.setString(6,v.getImage());
            ps.setInt(7,(int)v.getPrix());
            ps.setInt(8,id);

           ps.executeUpdate();
                        System.out.println("voyage Modifer avec succ");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceVoyage.class.getName()).log(Level.SEVERE, null, ex);
        }   

    }
     public ObservableList<voyage> chercherTitreplat(String chaine){
          String sql="SELECT * FROM voyage WHERE (nom_voyage LIKE ? or duree_voyage LIKE ? or valabilite LIKE ? )";
            
             Connection cnx= MyDB.getInsatnce().getConnection();
            String ch="%"+chaine+"%";

            ObservableList<voyage> myList= FXCollections.observableArrayList();
        try {
           
            Statement ste= cnx.createStatement();
           // PreparedStatement pst = myCNX.getCnx().prepareStatement(requete6);
            PreparedStatement stee =cnx.prepareStatement(sql);  
            stee.setString(1, ch);
            stee.setString(2, ch);
            stee.setString(3, ch);

            ResultSet rs = stee.executeQuery();
            while (rs.next()){
                voyage v = new voyage ();
                v.setDestination(rs.getString(3));
                v.setNom_voyage(rs.getString(4));
                v.setDuree_voyage(rs.getString(5));
                v.setDatevoy(rs.getDate(6));
                v.setValabilite(rs.getString(7));
                v.setImage(rs.getString(8));
                v.setPrix(rs.getFloat(9));

                myList.add(v);
                System.out.println("titre trouvé! ");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
      }
}