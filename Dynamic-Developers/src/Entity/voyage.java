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
public class voyage {
    int ID;
    String destination,nom_voyage,duree_voyage,valabilite,image;
    float prix;

    public voyage(String destination, String nom_voyage, String duree_voyage, String valabilite, String image, float prix) {
        this.destination = destination;
        this.nom_voyage = nom_voyage;
        this.duree_voyage = duree_voyage;
        this.valabilite = valabilite;
        this.image = image;
        this.prix = prix;
    }

    public voyage(int ID, String destination, String nom_voyage, String duree_voyage, String valabilite, String image, float prix) {
        this.ID = ID;
        this.destination = destination;
        this.nom_voyage = nom_voyage;
        this.duree_voyage = duree_voyage;
        this.valabilite = valabilite;
        this.image = image;
        this.prix = prix;
    }

    public voyage() {
    }
    
    @Override
    public String toString() {
        return "voyage{" + "ID=" + ID + ", destination=" + destination + ", nom_voyage=" + nom_voyage + ", duree_voyage=" + duree_voyage + ", valabilite=" + valabilite + ", image=" + image + ", prix=" + prix + '}';
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNom_voyage() {
        return nom_voyage;
    }

    public void setNom_voyage(String nom_voyage) {
        this.nom_voyage = nom_voyage;
    }

    public String getDuree_voyage() {
        return duree_voyage;
    }

    public void setDuree_voyage(String duree_voyage) {
        this.duree_voyage = duree_voyage;
    }

    public String getValabilite() {
        return valabilite;
    }

    public void setValabilite(String valabilite) {
        this.valabilite = valabilite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
 public int compareTo(voyage v) {
  //trions les employés selon leur age dans l'ordre croiddant
  //retroune un entier négative, zéro ou positive si l'age 
  //de cet employé est moins que, égale à ou supérieur à l'objet comparé avec
        return (int) (this.getPrix() - v.getPrix());
 }
}
