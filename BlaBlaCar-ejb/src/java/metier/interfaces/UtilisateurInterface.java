/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.interfaces;

import java.util.List;
import javax.ejb.Local;
import pojos.Trajet;
import pojos.Utilisateur;
import pojos.Avis;

/**
 *
 * @author dyvernin
 */

@Local
public interface UtilisateurInterface {
    
    public void inscrireTrajet(Trajet trajet); //pour passager
    public void deposeTrajet(Utilisateur utilisateur, Trajet trajet);
    public void deposeAvis(Utilisateur utilisateur, Avis avis);
    public void acceptePassagers(List<Utilisateur> listePassagers);
    public void paye(Trajet trajet); //pour passager
    public void createUser(Utilisateur user);
    
}
