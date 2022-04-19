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
public class ReserverVoyage {
        int Client,id;
        int voyage_id ;
        String Nom_voyage,travel_Class;
        Date date_reservation;
        int Age;

    public ReserverVoyage(int id, String Nom_voyage, Date date_reservation, String travel_Class, int Age) {
        this.id = id;
        this.Nom_voyage = Nom_voyage;
        this.date_reservation = date_reservation;
        this.travel_Class = travel_Class;
        this.Age = Age;
    }

    public ReserverVoyage(int voyage_id, String travel_Class, Date date_reservation, int Age) {
        this.voyage_id = voyage_id;
        this.travel_Class = travel_Class;
        this.date_reservation = null;
        this.Age = Age;
    }


    
    public ReserverVoyage(String Nom_voyage, String Travel_Class,Date date_reservation, int Age) {
     //   this.Client = Client;
        this.Nom_voyage = Nom_voyage;
        this.travel_Class = Travel_Class;
        this.date_reservation = date_reservation;
        this.Age = Age;
    }

    public ReserverVoyage(int id, int Client, int voyage_id, String Travel_Class,Date date_reservation, int Age) {
        this.Client = Client;
        this.id = id;
        this.voyage_id = voyage_id;
        this.travel_Class = Travel_Class;
        this.date_reservation = date_reservation;        
        this.Age = Age;
    }

    public ReserverVoyage() {
    }

    @Override
    public String toString() {
        return "ReserverVoyage{" + "Client=" + Client + ", id=" + id + ", Nom_voyage=" + Nom_voyage + ", date_reservation=" + date_reservation + ", Travel_Class=" + travel_Class + ", Age=" + Age + '}';
    }

    public int getVoyage_id() {
        return voyage_id;
    }

    public void setVoyage_id(int voyage_id) {
        this.voyage_id = voyage_id;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public int getClient() {
        return Client;
    }

    public void setClient(int Client) {
        this.Client = Client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_voyage() {
        return Nom_voyage;
    }

    public void setNom_voyage(String Nom_voyage) {
        this.Nom_voyage = Nom_voyage;
    }

    public String getTravel_Class() {
        return travel_Class;
    }

    public void setTravel_Class(String travel_Class) {
        this.travel_Class = travel_Class;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
}
