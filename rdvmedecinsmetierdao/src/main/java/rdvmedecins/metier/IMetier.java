package rdvmedecins.metier;

import rdvmedecins.domain.AgendaMedecinJour;
import rdvmedecins.entities.Client;
import rdvmedecins.entities.Creneau;
import rdvmedecins.entities.Medecin;
import rdvmedecins.entities.Rv;

import java.util.Date;
import java.util.List;

/**
 * Created by GuillaumeD on 19/04/2016.
 */
public interface IMetier {

    //liste de clients
    public List<Client> getAllClients();

    //liste des médecins
    public List<Medecin> getAllMedecins();

    //liste des créneaux horaires d'un médecin
    public List<Creneau> getAllCreneaux(long idMedecin);

    //list des Rv d'un médecin, un jour donné
    public List<Rv> getRvMedecinJour(long idMedecin, Date jour);

    //trouver un client identifié par son id
    public Client getClientById(long id);

    //trouver un médecin identifié par son id
    public  Medecin getMedecinById(long id);

    //trouver un Rv identifié par son id
    public Rv getRvById(long id);

    //trouver un créneau horaire identifié par son id
    public Creneau getCreneauById(long id);

    //ajouter un Rv
    public Rv ajouterRv(Date jour, Creneau creneau, Client client);

    // supprimer un Rv
    public void supprimerRv(Rv rv);

    //metier
    public AgendaMedecinJour getAgendaMedecinJour(long idMedecin, Date jour);
}
