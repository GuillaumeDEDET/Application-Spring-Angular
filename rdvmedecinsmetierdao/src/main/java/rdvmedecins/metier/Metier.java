package rdvmedecins.metier;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rdvmedecins.domain.AgendaMedecinJour;
import rdvmedecins.domain.CreneauMedecinJour;
import rdvmedecins.entities.Client;
import rdvmedecins.entities.Creneau;
import rdvmedecins.entities.Medecin;
import rdvmedecins.entities.Rv;
import rdvmedecins.repositories.ClientRepository;
import rdvmedecins.repositories.CreneauRepository;
import rdvmedecins.repositories.MedecinRepository;
import rdvmedecins.repositories.RvRepository;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by GuillaumeD on 19/04/2016.
 */

@Service("métier")
public class Metier implements IMetier {

    //répositories
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CreneauRepository creneauRepository;
    @Autowired
    private RvRepository rvRepository;

    //implémentation interface
    @Override
    public List<Client> getAllClients() {
        return Lists.newArrayList(clientRepository.findAll());
    }

    @Override
    public List<Medecin> getAllMedecins() {
        return Lists.newArrayList(medecinRepository.findAll());
    }

    @Override
    public List<Creneau> getAllCreneaux(long idMedecin) {
        return Lists.newArrayList(creneauRepository.findAll());
    }

    @Override
    public List<Rv> getRvMedecinJour(long idMedecin, Date jour) {
        return Lists.newArrayList(rvRepository.findAll());
    }

    @Override
    public Client getClientById(long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Medecin getMedecinById(long id) {
        return medecinRepository.findOne(id);
    }

    @Override
    public Rv getRvById(long id) {
        return rvRepository.findOne(id);
    }

    @Override
    public Creneau getCreneauById(long id) {
        return creneauRepository.findOne(id);
    }

    @Override
    public Rv ajouterRv(Date jour, Creneau creneau, Client client) {
        return rvRepository.save(new Rv(jour, client, creneau));
    }

    @Override
    public void supprimerRv(Rv rv) {
        rvRepository.delete(rv.getId());
    }

    @Override
    public AgendaMedecinJour getAgendaMedecinJour(long idMedecin, Date jour) {
        //liste des créneaux horaires du médecin
        List<Creneau> creneauxHoraires = getAllCreneaux(idMedecin);
        //liste des réservations de ce même médecin pour ce même jour
        List<Rv> reservations = getRvMedecinJour(idMedecin, jour);
        // on crée un dictionnaire à partir des Rv pris
        Map<Long, Rv> hReservations = new Hashtable<Long, Rv>();
        for(Rv resa : reservations){
            hReservations.put(resa.getCreneau().getId(), resa);
        }
        // on crée l'agenda pour le jour demandé
        AgendaMedecinJour agenda = new AgendaMedecinJour();
        //le médecin
        agenda.setMedecin(getMedecinById(idMedecin));
        //le jour
        agenda.setJour(jour);
        // les créneaux de réservation
        CreneauMedecinJour[] creneauxMedecinJour = new CreneauMedecinJour[creneauxHoraires.size()];
        agenda.setCreneauxMedecinJour(creneauxMedecinJour);
        //remplissage des créneaux de réservation
        for (int i = 0; i < creneauxHoraires.size(); i++){
            //ligne i agenda
            creneauxMedecinJour[i] = new CreneauMedecinJour();
            //créneau horaire
            Creneau creneau = creneauxHoraires.get(i);
            long idCreneau = creneau.getId();
            creneauxMedecinJour[i].setCreneau(creneau);
            //le créneau est-il libre ou réservé?
            if(hReservations.containsKey(idCreneau)){
                //le créneau est occupé - on note la résa
                Rv resa = hReservations.get(idCreneau);
                creneauxMedecinJour[i].setRv(resa);
            }
        }
        // on rend le résultat
        return agenda;
    }
}
