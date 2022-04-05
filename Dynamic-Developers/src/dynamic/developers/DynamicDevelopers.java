/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic.developers;

import Entity.voyage;
import Service.ServiceVoyage;
import Util.MyDB;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DynamicDevelopers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // MyDB db = MyDB.getInsatnce();
      //Ajouter 
      voyage v = new voyage("TN","Soussa","17 Jour 16 nuit","Disponible","Tunisia-Soussa-image",15);
        ServiceVoyage ps = new ServiceVoyage();
         //ps.AjouterVoyage(v);
        
        //ps.ModifierVoyage(v);
    
       // ps.SupprimerVoyage(34);

      //Affichage
            //  ServiceVoyage ps = new ServiceVoyage();
            
           List<voyage> Listvoyage = new ArrayList<>();
           
        //Listvoyage=ps.RecupererVoyagetrieDestination();
        
        //Listvoyage=ps.RechercheVoyage("CA");
        
       // Listvoyage=ps.RecupererVoyageDisponible();
        
       // Listvoyage=ps.RecupererVoyageBientotdisponible();

       Listvoyage=ps.RecupererVoyageNonDisponible();


        
  System.out.println(Listvoyage);
    }
    
}
