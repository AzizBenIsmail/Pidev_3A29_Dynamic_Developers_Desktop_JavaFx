/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Personne;
import Util.MYDB;
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
public class PersonneServise implements IService<Personne>{

    Connection cnx;

    public PersonneServise() {
        cnx=MYDB.getInsatnce().getConnection();
    }
    
    @Override
    public void Ajouter(Personne p) {
        try {
            String req = "insert into Personne(nom,Prenom,age)"
                    +"values('"+p.getNom()+"','"+p.getPrenom()+"',"
                    +""+null+")";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Personne ajouter avec succ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    }

    @Override
    public void Modifier(Personne p) {
        try {
            String req ="UPDATE personne SET Age=?,Nom=?,Prenom=? WHERE Id=?";
            PreparedStatement ps= cnx.prepareStatement(req);
            
            ps.setInt(1, p.getAge());
            ps.setString(2, p.getNom() );
            ps.setString(3, p.getPrenom());
            ps.setInt(4, p.getId());

           ps.executeUpdate();
                        System.out.println("Personne Modifer avec succ");

        } catch (SQLException ex) {
            Logger.getLogger(PersonneServise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Supprimer(int ID) {
    }

    @Override
    public  List<Personne> Recuperer() {
        List<Personne> personnes = new ArrayList<>();
        try {
            String req ="select * from personne";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               Personne p = new Personne();
               p.setId(rs.getInt(1));
               p.setAge(rs.getInt("age"));
               p.setNom(rs.getString(3));
               p.setPrenom(rs.getString(4));
               personnes.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
return personnes;
    }
    
    
}
