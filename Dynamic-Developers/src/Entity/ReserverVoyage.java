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
        int Client,id,voyage;
    Date date_reservation;
    String Travel_Class;
    int Age;

    public ReserverVoyage(int Client, int voyage, String Travel_Class,Date date_reservation, int Age) {
        this.Client = Client;
        this.voyage = voyage;
        this.Travel_Class = Travel_Class;
        this.date_reservation = date_reservation;
        this.Age = Age;
    }

    public ReserverVoyage(int Client, int id, int voyage, String Travel_Class,Date date_reservation, int Age) {
        this.Client = Client;
        this.id = id;
        this.voyage = voyage;
        this.Travel_Class = Travel_Class;
        this.date_reservation = date_reservation;        
        this.Age = Age;
    }

    public ReserverVoyage() {
    }

    @Override
    public String toString() {
        return "ReserverVoyage{" + "Client=" + Client + ", id=" + id + ", voyage=" + voyage + ", date_reservation=" + date_reservation + ", Travel_Class=" + Travel_Class + ", Age=" + Age + '}';
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

    public int getVoyage() {
        return voyage;
    }

    public void setVoyage(int voyage) {
        this.voyage = voyage;
    }

    public String getTravel_Class() {
        return Travel_Class;
    }

    public void setTravel_Class(String Travel_Class) {
        this.Travel_Class = Travel_Class;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
}
