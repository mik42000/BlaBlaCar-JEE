/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author dyvernin
 */
@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur {

    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY pour sqlNetbeans, AUTO pour Oracle
    @Id
    private int idUtilisateur;

    @Column(name = "identifiant")
    private String identifiant;

    @Column(name = "motdepasse")
    private String motDePasse;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    //permet de lister les trajets pour lesquels l'utilisateur est/était le conducteur
    @OneToMany(mappedBy = "utilisateur_conducteur")
    private List<Trajet> trajets = new ArrayList<>();

    //permet de relier un utilisateur inscrit à un trajet en tant que passager
    @ManyToOne
    private Trajet trajet;

    @OneToMany(mappedBy = "utilisateur_posteur")
    private List<Avis> avisPostes = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur_receveur")
    private List<Avis> avisRecus = new ArrayList<>();

    @OneToOne(mappedBy = "proprietaire")
    private Car voiture;

    /**
     * Constructeur
     */
    public Utilisateur() {
    }

    public Utilisateur(String identifiant, String password, String nom, String prenom) {
        this.identifiant = identifiant;
        this.motDePasse = password;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Trajet> getTrajets() {
        return trajets;
    }

    public void setTrajets(List<Trajet> trajets) {
        this.trajets = trajets;
    }

    /**
     * * Pour ManyToOne passager **
     */
    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public List<Avis> getAvisPostes() {
        return avisPostes;
    }

    public void setAvisPostes(List<Avis> avisPostes) {
        this.avisPostes = avisPostes;
    }

    public List<Avis> getAvisRecus() {
        return avisRecus;
    }

    public void setAvisRecus(List<Avis> avisRecus) {
        this.avisRecus = avisRecus;
    }

    public Car getVoiture() {
        return voiture;
    }

    public void setVoiture(Car voiture) {
        this.voiture = voiture;
    }
    
    

}
