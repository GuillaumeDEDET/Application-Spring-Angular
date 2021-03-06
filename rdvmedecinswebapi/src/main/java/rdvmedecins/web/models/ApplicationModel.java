package rdvmedecins.web.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rdvmedecins.domain.AgendaMedecinJour;
import rdvmedecins.entities.Client;
import rdvmedecins.entities.Creneau;
import rdvmedecins.entities.Medecin;
import rdvmedecins.entities.Rv;
import rdvmedecins.metier.IMetier;
import rdvmedecins.web.helpers.Static;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Created by GuillaumeD on 20/04/2016.
 */
@Component
public class ApplicationModel implements IMetier {

    //la couche [métier]
    @Autowired
    private IMetier metier;

    //données provenant de la couche [métier]
    private List<Medecin> medecins;
    private List<Client> clients;
    //messages d'erreur
    private List<String> messages;
    // données provenant de la couche [métier]
    private boolean CORSneeded = true;

    @PostConstruct
    public void init(){
        //on récupère les médecins et les clients
        try {
            medecins = metier.getAllMedecins();
            clients = metier.getAllClients();
        }catch (Exception ex){
            messages = Static.getErreursForException(ex);
        }
    }

    //getter
    public List<String> getMessages(){
        return messages;
    }

    //Interface couche [métier]
    @Override
    public List<Client> getAllClients(){
        return clients;
    }

    @Override
    public List<Medecin> getAllMedecins(){
        return medecins;
    }

    @Override
    public List<Creneau> getAllCreneaux(long idMedecin){
        return metier.getAllCreneaux(idMedecin);
    }

    @Override
    public List<Rv> getRvMedecinJour(long idMedecin, Date jour){
        return metier.getRvMedecinJour(idMedecin, jour);
    }

    @Override
    public Client getClientById(long id){
        return metier.getClientById(id);
    }

    @Override
    public Medecin getMedecinById(long id){
        return metier.getMedecinById(id);
    }

    @Override
    public Rv getRvById(long id){
        return metier.getRvById(id);
    }

    @Override
    public Creneau getCreneauById(long id){
        return metier.getCreneauById(id);
    }

    @Override
    public Rv ajouterRv(Date jour, Creneau creneau, Client client){
        return metier.ajouterRv(jour, creneau, client);
    }

    @Override
    public void supprimerRv(long idRv) {
        metier.supprimerRv(idRv);
    }

    @Override
    public AgendaMedecinJour getAgendaMedecinJour(long idMedecin, Date jour){
        return metier.getAgendaMedecinJour(idMedecin, jour);
    }

    public boolean isCORSneeded(){
        return CORSneeded;
    }
}
