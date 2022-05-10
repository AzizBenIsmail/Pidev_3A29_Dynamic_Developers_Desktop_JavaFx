/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.ReserverVoyage;
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
public class ServiseReserVoy implements IServiseReserVoy<ReserverVoyage> {

    
    Connection cnx;

    public ServiseReserVoy() {
                cnx=MyDB.getInsatnce().getConnection();
    }

    
    @Override
    public void AjouterReserverVoyage(ReserverVoyage r) {
      try {
                String req = "insert into reservation_voyage(id,client_id,voyage_id,date_reservation,travel_class, age)"
                        +"values("+r.getId()+","+1+","+r.getVoyage_id()+",'"+r.getDate_reservation()+"','"+r.getTravel_Class()+"',"+r.getAge()+")";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Voyage ajouter avec succ");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());        }    }
    

@Override
    public void ModifierReserverVoyage(ReserverVoyage r) {
try {

// String req ="UPDATE `voyage` SET `clien_id`='19',`destination`='ag',`nom_voyage`='18',`duree_voyage`='15',`date`='0000-00-00',`valabilite`='12',`image`='12',`prix`='12' WHERE id=33;";
            
            String req ="UPDATE reservation_voyage SET date_reservation=?,travel_class=?,age=? WHERE id=?";
            PreparedStatement ps= cnx.prepareStatement(req); //req dynamic plus securiser
           
           // ps.setString(1,);
            ps.setDate(1,r.getDate_reservation());
            ps.setString(2,r.getTravel_Class());
            ps.setInt(3,(int)r.getAge());
            ps.setInt(4,r.getId());
           ps.executeUpdate();
                        System.out.println("reservation_voyage Modifer avec succ");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceVoyage.class.getName()).log(Level.SEVERE, null, ex);
        }       }

    @Override
    public void SupprimerReserverVoyage(int ID) {
			try
    { 
      Statement st = cnx.createStatement();
      String req = "DELETE FROM reservation_voyage WHERE id = "+ID+"";
                st.executeUpdate(req);      
      System.out.println("La reservation_voyage avec l'id = "+ID+" a été supprimer avec succès...");
    } catch (SQLException ex) {
                System.out.println(ex.getMessage());        
              }
    }

   /* @Override
    public List<ReserverVoyage> RecupererReserverVoyage() {
 List<ReserverVoyage> ReserverVoy = new ArrayList<>();
        try {
            String req ="select * from reservation_voyage";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               ReserverVoyage r = new ReserverVoyage();
               r.setId(rs.getInt("id"));
               r.setClient(rs.getInt("client_id"));
              // r.setVoyage(rs.getInt("voyage_id"));
              // r.setDate_reservation(rs.getString("date_reservation"));
               r.setTravel_Class(rs.getString("travel_class"));
               r.setAge(rs.getInt("age"));
               
                String req1 ="select * from voyage where id= "+rs.getInt("voyage_id")+"";
                 Statement st1 = cnx.createStatement();
                 ResultSet rs1 = st1.executeQuery(req1);
                 while(rs1.next()) 
                 {
                voyage v = new voyage();
               v.setID(rs1.getInt("id"));
               v.setDestination(rs1.getString("destination"));
               v.setNom_voyage(rs1.getString("nom_voyage"));
               v.setDuree_voyage(rs1.getString("duree_voyage"));
               v.setValabilite(rs1.getString("valabilite"));
               v.setImage(rs1.getString("image"));
               v.setPrix(rs1.getInt("prix"));
                            r.setVoyage(v);

                 }

               ReserverVoy.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return ReserverVoy;    }
    */
@Override
    public List<ReserverVoyage> RecupererReserverVoyage() {
         List<ReserverVoyage> ReserverVoyage = new ArrayList<>();
       // String sql ="select * from platt";
        String sql ="select reservation_voyage.id,voyage.nom_voyage ,reservation_voyage.travel_class,reservation_voyage.date_reservation, reservation_voyage.age from reservation_voyage INNER JOIN voyage on reservation_voyage.voyage_id =voyage.id ";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                ReserverVoyage r = new ReserverVoyage();
               r.setId(rs.getInt("id"));
               r.setNom_voyage(rs.getString("nom_voyage"));
               //r.setDate_reservation(rs.getString("date_reservation"));
               r.setTravel_Class(rs.getString("travel_class"));
               r.setAge(rs.getInt("age"));
               
                ReserverVoyage.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ReserverVoyage;

    }
    
    public List<String> getAll() {
        List<String> list = new ArrayList<String>();
        try {
            String requetee = "SELECT nom_voyage FROM voyage";
            PreparedStatement pst = cnx.prepareStatement(requetee);
            ResultSet rs = pst.executeQuery();
            System.out.println(rs.toString());

            while (rs.next()) {
                list.add(rs.getString("nom_voyage"));
            }

            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
     public int chercherVoy(String Nom) throws SQLException{
         int id=0;
         String requetee = "SELECT id FROM voyage where nom_voyage='"+Nom+"';";
            PreparedStatement pst = cnx.prepareStatement(requetee);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {id= rs.getInt("id");
            }return id;}
     
        public ObservableList<ReserverVoyage> chercherReservationVoyage(String chaine){
        String sql ="select reservation_voyage.id,voyage.nom_voyage ,reservation_voyage.travel_class,reservation_voyage.date_reservation, reservation_voyage.age from reservation_voyage INNER JOIN voyage on reservation_voyage.voyage_id =voyage.id where (travel_class LIKE ? or age = ?)";
            
             Connection cnx= MyDB.getInsatnce().getConnection();
            String ch=""+chaine+"%";
         System.out.println(sql);
            ObservableList<ReserverVoyage> myList= FXCollections.observableArrayList();
        try {
           
            Statement ste= cnx.createStatement();
           // PreparedStatement pst = myCNX.getCnx().prepareStatement(requete6);
            PreparedStatement stee =cnx.prepareStatement(sql);  
            stee.setString(1, ch);
            stee.setString(2, ch);

         System.out.println(stee);

            ResultSet rs = stee.executeQuery();
            while (rs.next()){
                 ReserverVoyage r = new ReserverVoyage();
               r.setId(rs.getInt("id"));
               r.setNom_voyage(rs.getString("nom_voyage"));
               r.setDate_reservation(rs.getDate("date_reservation"));
               r.setTravel_Class(rs.getString("travel_class"));
               r.setAge(rs.getInt("age"));
               
                myList.add(r);
                System.out.println("titre trouvé! ");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
      }
}
