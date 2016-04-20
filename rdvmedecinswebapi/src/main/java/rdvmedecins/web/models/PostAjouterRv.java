package rdvmedecins.web.models;

/**
 * Created by GuillaumeD on 20/04/2016.
 */
public class PostAjouterRv {
    //données du post
    private String jour;
    private long idClient;
    private long idCreneau;

    //getters and setters

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public long getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(long idCreneau) {
        this.idCreneau = idCreneau;
    }
}
