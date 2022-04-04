/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic.developers;

import Entity.voyage;
import Service.ServiceVoyage;
import Util.MyDB;

/**
 *
 * @author ASUS
 */
public class DynamicDevelopers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      MyDB db = MyDB.getInsatnce();
      //Ajouter 
      voyage v = new voyage("AG","Qsantina","15 Jour 16 nuit","Disponible","Algeria-image",15);
        ServiceVoyage ps = new ServiceVoyage();
        ps.AjouterVoyage(v);
      
      
      //Affichage
            //  ServiceVoyage ps = new ServiceVoyage();
        System.out.println(ps.RecupererVoyage());
    }
    
}
