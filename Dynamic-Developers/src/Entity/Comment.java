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
    String Commentaire ;

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }
   
    public Comment() {
    }

    public Comment(int idpost, int idClient, String datec, String Commentaire) {
        this.idpost = idpost;
        this.idClient = idClient;
        this.datec = datec;
        this.Commentaire = Commentaire;
       
    }

    public Comment(int id, String Commentaire) {
        this.id = id;
        this.Commentaire = Commentaire;
       
    }

  

    public Comment(int id, int idpost, int idClient, String Commentaire) {
        this.id = id;
        this.idpost = idpost;
        this.idClient = idClient;
        this.Commentaire = Commentaire;
       
    }
    
    
    public Comment(String Commentaire) {
        this.Commentaire = Commentaire;
        
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

   
    
    
}
