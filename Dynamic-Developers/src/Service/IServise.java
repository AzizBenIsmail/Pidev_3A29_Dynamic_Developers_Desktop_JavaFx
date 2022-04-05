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
public interface IServise<V> {
    public void AjouterVoyage(V v) ;
    public void ModifierVoyage(V v);
    public void SupprimerVoyage(int ID);
    public List<V>RecupererVoyage();
    public List<V>RecupererVoyagetrieDestination();  //exemple trie 
    public List<V>RechercheVoyage(String Dest);  
    public List<V>RecupererVoyageDisponible();  
    public List<V>RecupererVoyageNonDisponible();  
    public List<V>RecupererVoyageBientotdisponible();  
    


}