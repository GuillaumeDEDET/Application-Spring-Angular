package rdvmedecins.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by GuillaumeD on 19/04/2016.
 */
@MappedSuperclass
public class Personne extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    //attributs d'une personne
    @Column(length = 5)
    private String titre;
    @Column(length = 20)
    private String nom;
    @Column(length = 20)
    private String prenom;

    //contructeur par défaut
    public Personne(){}

    //constructeur avec paramètres
    public Personne(String titre, String nom, String prenom){
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
    }

    //toString
    public String toString(){
        return String.format("Personne[%s, %s, %s, %s, %s]", id, version, titre, nom, prenom);
    }

    // getters et setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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
}
