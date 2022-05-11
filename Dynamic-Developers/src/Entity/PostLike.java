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
public class PostLike {
    int id , idpost ,iduser;

    public PostLike() {
    }

    public PostLike(int id, int idpost, int iduser) {
        this.id = id;
        this.idpost = idpost;
        this.iduser = iduser;
    }

    public PostLike(int id, int idpost) {
        this.id = id;
        this.idpost = idpost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    
    
}
