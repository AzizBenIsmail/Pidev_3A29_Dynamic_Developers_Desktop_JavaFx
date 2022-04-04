/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IService<T> {
    public void Ajouter(T t) ;
    public void Modifier(T t);
    public void Supprimer(int ID);
    public List<T>Recuperer();
}
