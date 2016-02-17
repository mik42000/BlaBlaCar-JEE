/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author dyvernin
 */
@Entity
@Table(name = "AVIS")
public class Avis {

    @Column(name = "id_avis")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "note")
    private int note;

    @Column(name = "date_avis")
    @Temporal(value=TemporalType.DATE)
    private Date date;

    // utilisateur qui poste un avis
    @ManyToOne
    private Utilisateur utilisateur_posteur;

    // utilisateur pour lequel est destiné l'avis
    @ManyToOne
    private Utilisateur utilisateur_receveur;

    /**
     * Constructeur
     */
    public Avis() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Utilisateur getUtilisateur_posteur() {
        return utilisateur_posteur;
    }

    public void setUtilisateur_posteur(Utilisateur utilisateur_posteur) {
        this.utilisateur_posteur = utilisateur_posteur;
    }

    public Utilisateur getUtilisateur_receveur() {
        return utilisateur_receveur;
    }

    public void setUtilisateur_receveur(Utilisateur utilisateur_receveur) {
        this.utilisateur_receveur = utilisateur_receveur;
    }

}
