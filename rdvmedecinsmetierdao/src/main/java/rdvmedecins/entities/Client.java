package rdvmedecins.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by GuillaumeD on 19/04/2016.
 */
@Entity
@Table(name = "clients")
public class Client extends Personne{

    private static final long serialVersionUID = 1L;

    //contructeur par défaut
    public Client(){}

    //contructeur avec paramètres
    public Client(String titre, String nom, String prenom){
        super(titre, nom, prenom);
    }

    //identités
    public String toString(){
        return String.format("Client[%s]", super.toString());
    }
}
