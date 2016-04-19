package rdvmedecins.web.models;

/**
 * Created by GuillaumeD on 19/04/2016.
 */
public class Reponse {

    //Propriétés
    //statut de l'opération
    private int status;
    // la réponse JSON
    private Object data;

    //Constructeurs
    public Reponse(){}

    public Reponse(int status, Object data){
        this.status = status;
        this.data = data;
    }

    //méthodes
    public void incrStatusBy(int increment){
        status += increment;
    }

    //getters and setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
