/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author dyvernin
 */
@Entity
@Table(name = "TRAJET")
public class Trajet {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idTrajet;

    //permet d'associer un trajet à un conducteur
    @ManyToOne
    private Utilisateur utilisateur_conducteur;

    // permet de lister les passagers du trajet
    @OneToMany(mappedBy = "trajet")
    private List<Utilisateur> utilisateurs_passager = new ArrayList<>();

    @Column(name = "lieu_depart")
    private String lieuDepart;

    @Column(name = "lieu_arrivee")
    private String lieuArrivee;

    @Column(name = "depart")
    @Temporal(value = TemporalType.DATE)
    private Date depart;

    @Column(name = "arrivee")
    @Temporal(value = TemporalType.DATE)
    private Date arrivee;

    @Column(name = "nb_places_totales")
    private int nb_places_totales;

    @Column(name = "nb_places_restantes")
    private int nb_places_restantes;

    @Column(name = "prix")
    private float prix;

    /**
     * Constructeur par défaut
     */
    public Trajet() {
    }

    public Trajet(String lieuD, String lieuA, Date dateD, Date dateA, int nbPlaces, int prix) {
        this.lieuDepart = lieuD;
        this.lieuArrivee = lieuA;
        this.depart = dateD;
        this.arrivee = dateA;
        this.nb_places_totales = nbPlaces;
        this.prix = prix;
    }

    //-----Getters/Setters pour les relations manytoone/onetomany
    public Utilisateur getUtilisateur_conducteur() {
        return utilisateur_conducteur;
    }

    public void setUtilisateur_conducteur(Utilisateur utilisateur_conducteur) {
        this.utilisateur_conducteur = utilisateur_conducteur;
    }

    //----Pour passagers
    public List<Utilisateur> getUtilisateurs_passager() {
        return utilisateurs_passager;
    }

    public void setUtilisateurs_passager(List<Utilisateur> utilisateurs_passager) {
        this.utilisateurs_passager = utilisateurs_passager;
    }
    //----------------------------------------------------------------//

    public Date getDepart() {
        return depart;
    }

    public String getDepartString() {
        if (depart == null) {
            return null;
        }
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdfDate.format(depart);
        return dateString;
    }

    public void setDepart(Date depart) {
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String dtime = sdf.format(depart);*/
        this.depart = depart;
    }

    public Date getArrivee() {
        return arrivee;
    }

    public void setArrivee(Date arrivee) {
        this.arrivee = arrivee;
    }

    public int getNb_places_totales() {
        return nb_places_totales;
    }

    public void setNb_places_totales(int nb_places_totales) {
        this.nb_places_totales = nb_places_totales;
    }

    public int getNb_places_restantes() {
        return nb_places_restantes;
    }

    public void setNb_places_restantes(int nb_places_restantes) {
        this.nb_places_restantes = nb_places_restantes;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(int idTrajet) {
        this.idTrajet = idTrajet;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getLieuArrivee() {
        return lieuArrivee;
    }

    public void setLieuArrivee(String lieuArrivee) {
        this.lieuArrivee = lieuArrivee;
    }

}
