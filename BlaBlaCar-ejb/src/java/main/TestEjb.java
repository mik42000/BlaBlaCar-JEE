/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import hibernate.HibernateUtils;
import java.util.Date;
import pojos.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Trajet;

/**
 *
 * @author dyvernin
 */
public class TestEjb {
    
    public static void main (String[] args) {
        
        Utilisateur user = new Utilisateur("dylan42130","lol42","Dylan","Vernin");
        Trajet trajet1 = new Trajet("Clermont-Ferrand", "Saint-Etienne", new Date(2016, 01, 25, 12, 00), new Date(2016, 01, 25, 13, 30), 4, 9);
        trajet1.setUtilisateur_conducteur(user);
        
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(user);
        session.save(trajet1);
        //Utilisateur u = (Utilisateur) session.load(Utilisateur.class, 1);
        tx.commit();
        //System.out.println("Identifiant: " + u.getIdentifiant());
        session.close();
        
    }
    
}
