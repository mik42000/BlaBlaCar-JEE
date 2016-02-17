/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.interfaces;

import java.util.List;
import javax.ejb.Local;
import pojos.Trajet;

/**
 *
 * @author dyvernin
 */
@Local
public interface TrajetInterface {
    
    public List getTrajetByLieuDepartLieuArriveeDate(Trajet trajet);
    public List getAllTrajet();
}
