/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import metier.interfaces.TrajetInterface;
import pojos.Trajet;

/**
 *
 * @author dyvernin
 */
@Stateless
@Local(TrajetInterface.class)
public class TrajetService implements TrajetInterface {
    
    @PersistenceUnit(unitName = "BlaBlaCar-ejbPU")
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlaBlaCar-ejbPU");

    //private EntityManager em;

    public TrajetService() {
        //this.em = emf.createEntityManager();
    }

    @Override
    public List<Trajet> getTrajetByLieuDepartLieuArriveeDate(Trajet trajet) {
        EntityManager em = this.emf.createEntityManager();
        Query query = em.createQuery("FROM Trajet WHERE LIEU_DEPART=:lieuDepartParam AND LIEU_ARRIVEE=:lieuArriveeParam AND DEPART=:dateDepartParam");
        query.setParameter("lieuDepartParam", trajet.getLieuDepart());
        query.setParameter("lieuArriveeParam", trajet.getLieuArrivee());
        query.setParameter("dateDepartParam", trajet.getDepartString());
        
        return query.getResultList();
    }

    @Override
    public List getAllTrajet() {
        EntityManager em = this.emf.createEntityManager();
        Query query = em.createQuery("from Trajet");
        return query.getResultList();
                
    }

}
