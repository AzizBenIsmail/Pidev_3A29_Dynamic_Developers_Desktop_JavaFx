/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entity.Personne;
import Service.PersonneServise;
import Util.MYDB;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
      /*MYDB db = MYDB.getInsatnce();
        System.out.println(db);*/
       
//Ajouter un Personne
       
       Personne p = new Personne(22,"Ben Isamil","Mohamed");
        PersonneServise ps = new PersonneServise();
       // ps.Ajouter(p);
       
//Modifier un Personne       
       
      /* Personne p = new Personne(1,19,"Aziz","BenIsmail");
        PersonneServise ps = new PersonneServise();
        ps.Modifier(p);*/
      
//Afficher 
      //  PersonneServise ps = new PersonneServise();
        System.out.println(ps.Recuperer());
    }
}
