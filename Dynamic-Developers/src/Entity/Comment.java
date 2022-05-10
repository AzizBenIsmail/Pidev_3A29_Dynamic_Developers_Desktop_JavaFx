/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Oumayma
 */
public class Comment {
    int id, idpost, idClient;
    String datec ;

    public String getDatec() {
        return datec;
    }

    public void setDatec(String datec) {
        this.datec = datec;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    String Commentaire , Objet;

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }
   
    public Comment() {
    }

    public Comment(int idpost, int idClient, String datec, String Commentaire, String Objet) {
        this.idpost = idpost;
        this.idClient = idClient;
        this.datec = datec;
        this.Commentaire = Commentaire;
        this.Objet = Objet;
    }

    public Comment(int id, String Commentaire, String Objet) {
        this.id = id;
        this.Commentaire = Commentaire;
        this.Objet = Objet;
    }

    public Comment(int id, String Commentaire) {
        this.id = id;
        this.Commentaire = Commentaire;
    }

    public Comment(int id, int idpost, int idClient, String Commentaire, String Objet) {
        this.id = id;
        this.idpost = idpost;
        this.idClient = idClient;
        this.Commentaire = Commentaire;
        this.Objet = Objet;
    }
    
    
    public Comment(String Commentaire, String Objet) {
        this.Commentaire = Commentaire;
        this.Objet = Objet;
    }
     
    
    public Comment(int id, int idpost, String Commentaire, String Objet) {
        this.id = id;
        this.idpost = idpost;
        this.Commentaire = Commentaire;
        this.Objet = Objet;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public String getObjet() {
        return Objet;
    }

    public void setObjet(String Objet) {
        this.Objet = Objet;
    }
    
    
}
