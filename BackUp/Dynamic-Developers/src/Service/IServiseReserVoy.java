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
public interface IServiseReserVoy<R>  {
    public void AjouterReserverVoyage(R r) ;
    public void ModifierReserverVoyage(R r);
    public void SupprimerReserverVoyage(int ID);
    public List<R>RecupererReserverVoyage();

}
