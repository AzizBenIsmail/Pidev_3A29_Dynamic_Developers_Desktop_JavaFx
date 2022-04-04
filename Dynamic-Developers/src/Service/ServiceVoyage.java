/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

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
public class ServiceVoyage implements IServise<voyage>{

    Connection cnx;

    public ServiceVoyage() {
                cnx=MyDB.getInsatnce().getConnection();
    }

    @Override
    public void AjouterVoyage(voyage v) {
         try {
                String req = "insert into voyage(id,clien_id,destination,nom_voyage,duree_voyage,date,valabilite,image,prix)"
                        +"values("+v.getID()+","+null+",'"+v.getDestination()+"','"+v.getNom_voyage()+"','"+v.getDuree_voyage()+"',"+null+","
                        +"'"+v.getValabilite()+"','"+v.getImage()+"',"+v.getPrix()+")";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Voyage ajouter avec succ");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());        }    }

    @Override
    public void ModifierVoyage(voyage v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SupprimerVoyage(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
