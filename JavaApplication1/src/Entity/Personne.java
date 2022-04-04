/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ASUS
 */
public class Personne {
    private int Id,Age;
    private String Nom,Prenom;

    public Personne(int Age, String Nom, String Prenom) {
        this.Age = Age;
        this.Nom = Nom;
        this.Prenom = Prenom;
    }

    public Personne(int Id, int Age, String Nom, String Prenom) {
        this.Id = Id;
        this.Age = Age;
        this.Nom = Nom;
        this.Prenom = Prenom;
    }

    public Personne() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    @Override
    public String toString() {
        return "Personne{" + "Id=" + Id + ", Age=" + Age + ", Nom=" + Nom + ", Prenom=" + Prenom + '}';
    }
    
}
