/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Service.ServicePost;


/**
 *
 * @author Oumayma
 */
public class Post implements Comparable<Post> {
   private int id , likes;
   private String HashtagP,DescriptionP,visibilite,ImageP;
   private String DateP , country; 

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Post(int id, String HashtagP, String DescriptionP, String visibilite, String DateP) {
        this.id = id;
        this.HashtagP = HashtagP;
        this.DescriptionP = DescriptionP;
        this.visibilite = visibilite;
        this.DateP = DateP;
    }

    public Post(int id, int likes, String HashtagP, String DescriptionP, String visibilite, String ImageP, String DateP) {
        this.id = id;
        this.likes = likes;
        this.HashtagP = HashtagP;
        this.DescriptionP = DescriptionP;
        this.visibilite = visibilite;
        this.ImageP = ImageP;
        this.DateP = DateP;
    }
    
    public Post() {
    }

    public Post(String HashtagP, String DescriptionP, String visibilite, String DateP) {
        this.HashtagP = HashtagP;
        this.DescriptionP = DescriptionP;
        this.visibilite = visibilite;
        this.DateP = DateP;
    }

    public Post(int id, String HashtagP, String DescriptionP, String visibilite, String ImageP, String DateP) {
        this.id = id;
        this.HashtagP = HashtagP;
        this.DescriptionP = DescriptionP;
        this.visibilite = visibilite;
        this.ImageP = ImageP;
        this.DateP = DateP;
    }

    public Post(String HashtagP, String DescriptionP, String visibilite) {
        this.HashtagP = HashtagP;
        this.DescriptionP = DescriptionP;
        this.visibilite = visibilite;
    }
    
    public Post(String HashtagP, String DescriptionP, String visibilite, String ImageP, String DateP) {
        this.HashtagP = HashtagP;
        this.DescriptionP = DescriptionP;
        this.visibilite = visibilite;
        this.ImageP = ImageP;
        this.DateP = DateP;
    }
    
    public String getImageP() {
        return ImageP;
    }

    public void setImageP(String ImageP) {
        this.ImageP = ImageP;
    }
    
   
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHashtagP() {
        return HashtagP;
    }

    public void setHashtagP(String HashtagP) {
        this.HashtagP = HashtagP;
    }

    public String getDescriptionP() {
        return DescriptionP;
    }

    public void setDescriptionP(String DescriptionP) {
        this.DescriptionP = DescriptionP;
    }

    public String getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(String visibilite) {
        this.visibilite = visibilite;
    }

    public String getDateP() {
        return DateP;
    }

    public void setDateP(String DateP) {
        this.DateP = DateP;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", likes=" + likes + ", HashtagP=" + HashtagP + ", DescriptionP=" + DescriptionP + ", visibilite=" + visibilite + ", ImageP=" + ImageP + ", DateP=" + DateP + '}';
    }

    @Override
    public int compareTo(Post o) {
        ServicePost serv = new ServicePost();
        int l1 = serv.likes(this.id).size();
        int l2 = serv.likes(o.id).size();
        return l1-l2;
    }
    
    
}
