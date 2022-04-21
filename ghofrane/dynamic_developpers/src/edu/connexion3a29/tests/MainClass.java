/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a29.tests;

import edu.connexion3a29.entities.Restaurant;
import edu.connexion3a29.entities.RestaurantReservation;
import edu.connexion3a29.services.RestaurantCrud;
import edu.connexion3a29.services.RestaurantReservationCrud;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import java.util.List;


/**
 *
 * @author ASUS
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RestaurantCrud rc=new RestaurantCrud();
        Restaurant r= new Restaurant("brodway","menzah6",41707517,"blablabla");
        //rc.ajouter_restaurant(r);
       // System.out.println(rc.listerRestaurants());
       // rc.supprimer_restaurant(r);
       //rc.modifier_restaurant(1, "ffff", "rrrr", 0111, "eeee");
       //rc.supprimer_restaurant(1);
         SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        String string_date = "12-02-2040";
        
        long milliseconds_date= 0;
        
        try {
            Date dD = f.parse(string_date);
           
            milliseconds_date= dD.getTime();
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RestaurantReservationCrud rcd=new RestaurantReservationCrud();
        RestaurantReservation rr=new RestaurantReservation("tt","tt",66,new java.sql.Date(milliseconds_date));
       // rcd.ajouter_restaurantreservation(rr);
       // System.out.println(rcd.listerRestaurantReservations());
      // rcd.modifier_RestaurantReservation(1,"rr", "uuu", 0,new java.sql.Date(milliseconds_date));
    //  rcd.supprimer_RestaurantReservation(1);
    }
    
}
