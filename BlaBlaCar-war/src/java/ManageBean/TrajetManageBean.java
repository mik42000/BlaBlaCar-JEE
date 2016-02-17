/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import metier.interfaces.TrajetInterface;
import pojos.Trajet;
import service.TrajetService;

/**
 *
 * @author dyvernin
 */
@ManagedBean(name="TrajetManageBean")
@SessionScoped
public class TrajetManageBean {
    
    @EJB
    public TrajetInterface trajetService;
    
    private Trajet trajet;
    
    private List<Trajet> listeObtenue;
    
    public void findTrajetByLieuDepartLieuArriveeDate() throws IOException {
        this.trajetService = new TrajetService();
        listeObtenue = this.trajetService.getTrajetByLieuDepartLieuArriveeDate(this.trajet);
        System.out.println("nb en base : " + listeObtenue.size());
        for(Trajet t : listeObtenue){
            System.out.println(t.getDepart() + " -- " + t.getLieuArrivee());
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("resultatRecherche.faces");
    }
    
    public void findAllTrajet() {
        this.trajetService = new TrajetService();
        System.out.println(this.trajetService.getAllTrajet().get(0));
        //List listeTrajets = this.trajetService.getAllTrajet();
        //System.out.println(listeTrajets);
    }

    public TrajetInterface getTrajetService() {
        return trajetService;
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

    public List<Trajet> getListeObtenue() {
        return listeObtenue;
    }

    public void setListeObtenue(List<Trajet> listeObtenue) {
        this.listeObtenue = listeObtenue;
    }
    
    
}
