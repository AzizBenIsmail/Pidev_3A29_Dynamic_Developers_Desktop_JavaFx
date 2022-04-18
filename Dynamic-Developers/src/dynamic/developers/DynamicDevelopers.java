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
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.stream.Collectors;
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
      Date Datevoy=Date.valueOf("2022-10-10");

      voyage v = new voyage("AF","FGHANESTEN","25 Jour 24 nuit",Datevoy,"Non Disponible","Image",15);
     // ReserverVoyage r = new ReserverVoyage(2,1,v,"economic Class",null,15);
        ServiceVoyage ps = new ServiceVoyage();
         ps.AjouterVoyage(v);
        
        //ps.ModifierVoyage(v);
    
        //ps.SupprimerVoyage(35);

      //Affichage            
         List<voyage> Listvoyage = new ArrayList<>();
           
         List<ReserverVoyage> Listreservationvoyage = new ArrayList<>();
           
        Listvoyage=ps.RecupererVoyage();

       /* Listvoyage.sort(new Comparator<voyage>() {
          @Override
          public int compare(voyage o1, voyage o2) {
              return o2.getNom_voyage().compareTo(o1.getNom_voyage());
          }
      }); */
      /*           List<voyage> Listtrievoyage = new ArrayList<>();

       Listtrievoyage = Listvoyage.stream().sorted(new Comparator<voyage>() {
          @Override
          public int compare(voyage o1, voyage o2) {
              return o2.getNom_voyage().compareTo(o1.getNom_voyage());
          }
      }).collect(Collectors.toList());
        
        */
        //Listvoyage=ps.RecupererVoyagetrieDestination();
        
       // Listvoyage=ps.RechercheVoyage("CA");
        
       // Listvoyage=ps.RecupererVoyageDisponible();
        
       // Listvoyage=ps.RecupererVoyageBientotdisponible();

      // Listvoyage=ps.RecupererVoyageNonDisponible();
      
        ServiseReserVoy pss = new ServiseReserVoy();
        
        //pss.SupprimerReserverVoyage(1);
        
        //pss.AjouterReserverVoyage(r);

        //pss.ModifierReserverVoyage(r);

        
        Listreservationvoyage=pss.RecupererReserverVoyage();
        
        
    //System.out.println(Listvoyage);
    System.out.println(Listreservationvoyage);

    }
    
}
