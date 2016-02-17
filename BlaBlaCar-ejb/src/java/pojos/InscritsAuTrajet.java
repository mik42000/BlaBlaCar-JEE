/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import javax.persistence.*;

/**
 *
 * @author dyvernin
 */
@Entity
@Table(name = "INSCRITSAUTRAJET")
public class InscritsAuTrajet {
    
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    
    @Column(name = "id_utilisateur_passager")
    private int id_utilisateur_passager;
    
    @Column(name = "id_trajet")
    private int id_trajet;

    /**
     * Constructeur
     */
    public InscritsAuTrajet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_utilisateur_passager() {
        return id_utilisateur_passager;
    }

    public void setId_utilisateur_passager(int id_utilisateur_passager) {
        this.id_utilisateur_passager = id_utilisateur_passager;
    }

    public int getId_trajet() {
        return id_trajet;
    }

    public void setId_trajet(int id_trajet) {
        this.id_trajet = id_trajet;
    }
}
