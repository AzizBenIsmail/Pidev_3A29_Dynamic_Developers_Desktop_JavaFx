/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic.developers;

import Entity.ReserverVoyage;
import Entity.voyage;
import Service.ServiceVoyage;
import Service.ServiseReserVoy;
import Util.MyDB;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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

      voyage v = new voyage("AF","FGHANESTEN","25 Jour 24 nuit",null,"Non Disponible","Image",15);
      ReserverVoyage r = new ReserverVoyage(1,5,"Travel_Class",null,15);
        ServiceVoyage ps = new ServiceVoyage();
       //  ps.AjouterVoyage(v);
        
        //ps.ModifierVoyage(v);
    
        //ps.SupprimerVoyage(35);

      //Affichage            
           List<voyage> Listvoyage = new ArrayList<>();
           List<ReserverVoyage> Listreservationvoyage = new ArrayList<>();
           
        Listvoyage=ps.RecupererVoyage();

        //Listvoyage=ps.RecupererVoyagetrieDestination();
        
       // Listvoyage=ps.RechercheVoyage("CA");
        
       // Listvoyage=ps.RecupererVoyageDisponible();
        
       // Listvoyage=ps.RecupererVoyageBientotdisponible();

      // Listvoyage=ps.RecupererVoyageNonDisponible();
      
        ServiseReserVoy pss = new ServiseReserVoy();
        
        //pss.SupprimerReserverVoyage(1);
        
        pss.AjouterReserverVoyage(r);

        Listreservationvoyage=pss.RecupererReserverVoyage();
        
        
    System.out.println(Listvoyage);
    System.out.println(Listreservationvoyage);

    }
    
}
