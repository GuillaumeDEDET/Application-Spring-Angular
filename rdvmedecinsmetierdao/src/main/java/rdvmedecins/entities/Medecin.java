package rdvmedecins.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by GuillaumeD on 19/04/2016.
 */
@Entity
@Table(name = "medecins")
public class Medecin extends Personne{

    private static final long serialVersionUID = 1L;

    //contructeur par défaut
    public Medecin(){}

    //contructeur avec paramètres
    public Medecin(String titre, String nom, String prenom){
        super(titre, nom, prenom);
    }

    public String toString(){
        return String.format("Medecin[%s]", super.toString());
    }
}
