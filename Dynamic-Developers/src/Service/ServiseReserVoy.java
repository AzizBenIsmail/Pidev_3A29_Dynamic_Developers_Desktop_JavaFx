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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                        +"values("+r.getId()+","+1+","+r.getVoyage()+","+r.getDate_reservation()+",'"+r.getTravel_Class()+"',"+r.getAge()+")";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Voyage ajouter avec succ");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());        }    }


    @Override
    public void ModifierReserverVoyage(ReserverVoyage r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
              }    }

    @Override
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
               r.setVoyage(rs.getInt("voyage_id"));
              // r.setDate_reservation(rs.getString("date_reservation"));
               r.setTravel_Class(rs.getString("travel_class"));
               r.setAge(rs.getInt("age"));
               
               ReserverVoy.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return ReserverVoy;    }
    
}
