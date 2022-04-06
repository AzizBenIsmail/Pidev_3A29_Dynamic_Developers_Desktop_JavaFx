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

//            String req ="UPDATE `voyage` SET `clien_id`='19',`destination`='ag',`nom_voyage`='18',`duree_voyage`='15',`date`='0000-00-00',`valabilite`='12',`image`='12',`prix`='12' WHERE id=33;";
            
            String req ="UPDATE voyage SET clien_id=19,destination=?,nom_voyage=?,duree_voyage=?,date=?,valabilite=?,image=?,prix=? WHERE id=?;";
            PreparedStatement ps= cnx.prepareStatement(req);
           
            ps.setString(1,v.getDestination());
            ps.setString(2,v.getNom_voyage());
            ps.setString(3,v.getDuree_voyage());
            ps.setDate(4,v.getDatevoy());
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
}