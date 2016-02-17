/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metier.interfaces.TrajetInterface;
import service.UtilisateurService;
import metier.interfaces.UtilisateurInterface;
import pojos.Trajet;
import pojos.Utilisateur;

/**
 *
 * @author dyvernin
 */
@ManagedBean(name="UtilisateurManageBean")
@SessionScoped
public class UtilisateurManageBean {
    
    @EJB
    public UtilisateurInterface utilisateurService;
    
    private Utilisateur utilisateur;
    
    @EJB 
    public TrajetInterface trajetService;
    
    private Trajet trajet;
    
    public void deposerTrajet(){
        // Normalement, il ne faut pas instancier l'EJB mais sinon, ça ne marche pas
        this.utilisateurService = new UtilisateurService();
        this.utilisateurService.deposeTrajet(this.utilisateur, this.trajet);
    }
    
    public String createUser(){
        final Utilisateur user = new Utilisateur("lesRabatsdu63", "jul42", "LudoCed", "rabat"); // pojo
        
        // Normalement, il ne faut pas instancier l'EJB mais sinon, ça ne marche pas
        this.utilisateurService = new UtilisateurService();
        utilisateurService.createUser(user); 
        
        return "Utilisateur créé";
    }

    public Utilisateur getUtilisateur() {
        if(utilisateur == null){
            utilisateur = new Utilisateur();
        }
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Trajet getTrajet() {
        if(trajet == null){
            trajet = new Trajet();
        }
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }
    
    
}
