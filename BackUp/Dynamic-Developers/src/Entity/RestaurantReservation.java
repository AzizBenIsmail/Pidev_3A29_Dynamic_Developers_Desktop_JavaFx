/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class RestaurantReservation {
   private int  Id;
  private String Nom_Restaurant;
  
   private String nom_Client;
    private int Nbr_Personne;
    private Date Date_Reservation;
    public RestaurantReservation(){}

    public RestaurantReservation(int Id, String Nom_Restaurant, String nom_Client, int Nbr_Personne, Date Date_Reservation) {
        this.Id = Id;
        this.Nom_Restaurant = Nom_Restaurant;
        this.nom_Client = nom_Client;
        this.Nbr_Personne = Nbr_Personne;
        this.Date_Reservation = Date_Reservation;
    }

    public RestaurantReservation(String Nom_Restaurant, String nom_Client, int Nbr_Personne, Date Date_Reservation) {
        this.Nom_Restaurant = Nom_Restaurant;
        this.nom_Client = nom_Client;
        this.Nbr_Personne = Nbr_Personne;
        this.Date_Reservation = Date_Reservation;
    }

   

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getDate_Reservation() {
        return Date_Reservation;
    }

    public void setDate_Reservation(Date Date_Reservation) {
        this.Date_Reservation = Date_Reservation;
    }

    public int getNbr_Personne() {
        return Nbr_Personne;
    }

    public void setNbr_Personne(int Nbr_Personne) {
        this.Nbr_Personne = Nbr_Personne;
    }

    public String getNom_Client() {
        return nom_Client;
    }

    public void setNom_Client(String nom_Client) {
        this.nom_Client = nom_Client;
    }

    public String getNom_Restaurant() {
        return Nom_Restaurant;
    }

    public void setNom_Restaurant(String Nom_Restaurant) {
        this.Nom_Restaurant = Nom_Restaurant;
    }

    @Override
    public String toString() {
        return "RestaurantReservation{" + "Id=" + Id + ", Date_Reservation=" + Date_Reservation + ", Nbr_Personne=" + Nbr_Personne + ", nom_Client=" + nom_Client + ", Nom_Restaurant=" + Nom_Restaurant + '}';
    }
   
    
}
