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
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import metier.interfaces.UtilisateurInterface;
import pojos.Avis;
import pojos.Trajet;
import pojos.Utilisateur;

/**
 *
 * @author dyvernin
 */
@Stateless
@Local(UtilisateurInterface.class)
public class UtilisateurService implements UtilisateurInterface {

    @PersistenceUnit(unitName = "BlaBlaCar-ejbPU")
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlaBlaCar-ejbPU");

    public UtilisateurService() {
        //this.emf = Persistence.createEntityManagerFactory("toto");
        //this.em = emf.createEntityManager();
    }

    @Override
    public void inscrireTrajet(Trajet trajet) {

    }

    @Override
    public void deposeTrajet(Utilisateur utilisateur, Trajet trajet) {
        if (trajet != null) {
            EntityManager em1 = this.emf.createEntityManager();
            String nomUtilisateur = utilisateur.getNom();
            String prenomUtilisateur = utilisateur.getPrenom();
            Query query = em1.createQuery("FROM Utilisateur WHERE prenom=:prenom AND nom=:nom");
            query.setParameter("prenom", prenomUtilisateur);
            query.setParameter("nom", nomUtilisateur);
            List<Utilisateur> listeUtilisateurs = query.getResultList();
            em1.close();
            
            EntityManager em2 = this.emf.createEntityManager();
            if (listeUtilisateurs.isEmpty()) { // s'il n'y a aucun utilisateur avec ce nom et prenom dans la base, on en créé un nouveau
                trajet.setUtilisateur_conducteur(utilisateur);
                utilisateur.getTrajets().add(trajet);
                System.err.println(utilisateur.getNom());
                //em.persist(utilisateur);
            } else {
                final Utilisateur userTmp = listeUtilisateurs.get(0);
                trajet.setUtilisateur_conducteur(userTmp); // sinon on associe le premier trouvé au nouveau trajet
                userTmp.getTrajets().add(trajet);
            }
            em2.getTransaction().begin();
            em2.persist(trajet);
            em2.getTransaction().commit();
            em2.close();
        }
    }

    @Override
    public void deposeAvis(Utilisateur utilisateur, Avis avis) {

    }

    @Override
    public void acceptePassagers(List<Utilisateur> listePassagers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paye(Trajet trajet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createUser(Utilisateur user) {
        EntityManager em = this.emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        System.out.println("!!!! Utilisateur créé : createUser de UtilisateurService !!!!");
    }

}
