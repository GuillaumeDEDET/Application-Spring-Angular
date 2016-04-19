package rdvmedecins.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by GuillaumeD on 19/04/2016.
 */
@Entity
@Table(name = "rv")
public class Rv extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    // caractéristiques d'un Rv
    @Temporal(TemporalType.DATE)
    private Date jour;

    //un rv est lié à un client
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;

    //un rv est lié à un créneau
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creneau")
    private Creneau creneau;

    //clés étrangères
    @Column(name = "id_client", insertable = false, updatable = false)
    private long idClient;
    @Column(name = "id_creneau", insertable = false, updatable = false)
    private long idCreneau;

    //constructeur par défaut
    public Rv(){}

    // avec paramètres
    public Rv(Date jour, Client client, Creneau creneau){
        this.jour = jour;
        this.client = client;
        this.creneau = creneau;
    }

    // toString
    public String toString(){
        return String.format("Rv[%d, %s, %d, %d]", id, jour, client.id, creneau.id);
    }

    //clés étrangères
    public long getIdCreneau(){
        return idCreneau;
    }

    public long getIdClient(){
        return idClient;
    }

    // getters et setters
    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }
}
