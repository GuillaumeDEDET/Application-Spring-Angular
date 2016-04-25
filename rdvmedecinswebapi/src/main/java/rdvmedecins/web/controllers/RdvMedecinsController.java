package rdvmedecins.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rdvmedecins.domain.AgendaMedecinJour;
import rdvmedecins.entities.Client;
import rdvmedecins.entities.Creneau;
import rdvmedecins.entities.Medecin;
import rdvmedecins.entities.Rv;
import rdvmedecins.web.helpers.Static;
import rdvmedecins.web.models.ApplicationModel;
import rdvmedecins.web.models.PostAjouterRv;
import rdvmedecins.web.models.PostSupprimerRv;
import rdvmedecins.web.models.Reponse;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by GuillaumeD on 20/04/2016.
 */
@RestController
public class RdvMedecinsController {

    @Autowired
    private ApplicationModel application;
    private List<String> messages;

    @Autowired
    private RdvMedecinsCorsController rdvMedecinsCorsController;

    @PostConstruct
    public void init(){
        //messages d'erreur de l'application
        messages = application.getMessages();
    }

    //liste des médecins
    @RequestMapping(value = "/getAllMedecins", method = RequestMethod.GET)
    public Reponse getAllMedecins(HttpServletResponse response){
        //entête CORS
        rdvMedecinsCorsController.getAllMedecins(response);
       //état de l'application
        if(messages != null){
            return new Reponse(-1, messages);
        }
        //liste des médecins
        try {
            return new Reponse(0, application.getAllMedecins());
        } catch (Exception e) {
            return new Reponse(1, Static.getErreursForException(e));
        }
    }

    //liste des clients
    @RequestMapping(value = "/getAllClients", method = RequestMethod.GET)
    public Reponse getAllClients(HttpServletResponse response){
        //entête CORS
        rdvMedecinsCorsController.getAllClients(response);
        //état de l'application
        if(messages != null){
            return new Reponse(-1, messages);
        }
        //liste des clients
        try{
            return new Reponse(0, application.getAllClients());
        } catch (Exception e) {
            return new Reponse(1, Static.getErreursForException(e));
        }
    }

    //liste des créneaux d'un médecin
    @RequestMapping(value = "/getAllCreneaux/{idMedecin}", method = RequestMethod.GET)
    public Reponse getAllCreneaux(@PathVariable("idMedecin") long idMedecin){
        //état de l'application
        if (messages != null){
            return new Reponse(-1, messages);
        }
        //on récupère le médecin
        Reponse reponse = getMedecin(idMedecin);
        if (reponse.getStatus() != 0){
            return reponse;
        }
        Medecin medecin = (Medecin) reponse.getData();
        //créneaux du médecin
        List<Creneau> creneaux = null;
        try{
            creneaux = application.getAllCreneaux(medecin.getId());
        } catch (Exception e1) {
            return new Reponse(3, Static.getErreursForException(e1));
        }
        //on rend la réponse
        return new Reponse(0, Static.getListMapForCreneaux(creneaux));
    }

    private Reponse getMedecin(long id){
        //on récupère le médecin
        Medecin medecin = null;
        try{
            medecin = application.getMedecinById(id);
        } catch (Exception e1) {
            return new Reponse(1, Static.getErreursForException(e1));
        }
        //médecin existant ?
        if (medecin == null){
            return new Reponse(2, null);
        }
        //ok
        return new Reponse(0, medecin);
    }

    //liste des rendez-vous d'un médecin
    @RequestMapping(value = "/getRvMedecinJour/{idMedecin}/{jour}", method = RequestMethod.GET)
    public Reponse getRvMedecinJour(@PathVariable("idMedecin") long idMedecin, @PathVariable("jour") String jour){
        //état de l'application
        if(messages != null){
            return new Reponse(-1, messages);
        }
        //on vérifie la date
        Date jourAgenda = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            jourAgenda = sdf.parse(jour);
        } catch (ParseException e) {
            return new Reponse(3, null);
        }
        //on récupère le médecin
        Reponse reponse = getMedecin(idMedecin);
        if(reponse.getStatus() != 0){
            return reponse;
        }
        Medecin medecin = (Medecin) reponse.getData();
        //liste de ses rendez-vous
        List<Rv> rvs = null;
        try{
            rvs = application.getRvMedecinJour(medecin.getId(), jourAgenda);
        } catch (Exception e1) {
            return new Reponse(4, Static.getErreursForException(e1));
        }
        //on rend la réponse
        return new Reponse(0, Static.getListMapForRvs(rvs));
    }

    //Un client via son id
    @RequestMapping(value= "/getClientById/{id}", method = RequestMethod.GET)
    public Reponse getClientById(@PathVariable("id") long id){
        //état de l'application
        if (messages != null){
            return new Reponse(-1, messages);
        }
        //on récupère le client
        return getClient(id);
    }

    private Reponse getClient(long id){
        //on récupère le client
        Client client = null;
        try {
            client = application.getClientById(id);
        } catch (Exception e1){
            return new Reponse(1, Static.getErreursForException(e1));
        }
        //client existant ?
        if (client == null){
            return new Reponse(2, null);
        }
        //ok
        return new Reponse(0, client);
    }

    //Un médecin via son id
    @RequestMapping(value= "/getMedecinById/{id}", method = RequestMethod.GET)
    public Reponse getMedecinById(@PathVariable("id") long id){
        //état de l'application
        if (messages != null){
            return new Reponse(-1, messages);
        }
        //on récupère le médecin
        return getMedecin(id);
    }

    //Un rdv via son id
    @RequestMapping(value= "/getRvById/{id}", method = RequestMethod.GET)
    public Reponse getRvById(@PathVariable("id") long id){
        // état de l'application
        if (messages != null){
            return new Reponse(-1, messages);
        }
        //on récupère le rv
        Reponse reponse = getRv(id);
        if (reponse.getStatus() == 0){
            reponse.setData(Static.getMapForRv2((Rv) reponse.getData()));
        }
        //résultat
        return reponse;
    }

    private Reponse getRv(long id){
        //on récupère le Rv
        Rv rv = null;
        try {
            rv = application.getRvById(id);
        } catch (Exception e1) {
            return new Reponse(1, Static.getErreursForException(e1));
        }
        //Rv existant ?
        if (rv == null){
            return new Reponse(2, null);
        }
        //ok
        return new Reponse(0, rv);
    }

    //Un créneau via son id
    @RequestMapping(value= "/getCreneauById/{id}", method = RequestMethod.GET)
    public Reponse getCreneauById(@PathVariable("id") long id){
        //état de l'application
        if (messages != null){
            return new Reponse(-1, messages);
        }
        //on récupère le créneau
        Reponse reponse = getCreneau(id);
        if(reponse.getStatus() == 0){
            reponse.setData(Static.getMapForCreneau((Creneau) reponse.getData()));
        }
        //résultat
        return reponse;
    }

    private Reponse getCreneau(long id){
        // on récupère le créneau
        Creneau creneau = null;
        try{
            creneau = application.getCreneauById(id);
        } catch (Exception e1){
            return new Reponse(1, Static.getErreursForException(e1));
        }
        // créneau existant ?
        if ( creneau == null){
            return new Reponse(2, null);
        }
        // ok
        return new Reponse(0, creneau);
    }

    //Un ajout de rdv
    @RequestMapping(value= "/ajouterRv", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Reponse ajouterRv(@RequestBody PostAjouterRv post, HttpServletResponse response){
        //entêtes CORS
        rdvMedecinsCorsController.ajouterRv(response);
        //état de l'application
        if (messages != null){
            return new Reponse(-1, messages);
        }
        // on récupère les valeurs postées
        String jour = post.getJour();
        long idCreneau = post.getIdCreneau();
        long idClient = post.getIdClient();
        // on vérifie la date
        Date jourAgenda = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            jourAgenda = sdf.parse(jour);
        } catch (ParseException e) {
            return new Reponse(6, null);
        }
        //on récupère le créneau
        Reponse reponse = getCreneau(idCreneau);
        if (reponse.getStatus() != 0){
            return reponse;
        }
        Creneau creneau = (Creneau) reponse.getData();
        //on récupère le client
        reponse = getClient(idClient);
        if (reponse.getStatus() != 0){
            reponse.incrStatusBy(2);
            return reponse;
        }
        Client client = (Client) reponse.getData();
        //on ajoute le Rv
        Rv rv = null;
        try {
            rv = application.ajouterRv(jourAgenda, creneau, client);
        } catch (Exception e1) {
            return new Reponse(5, Static.getErreursForException(e1));
        }
        // on rend la réponse
        return new Reponse(0, Static.getMapForRv(rv));
    }

    //Une suppression de rdv
    @RequestMapping(value= "/supprimerRv", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Reponse supprimerRv(@RequestBody PostSupprimerRv post, HttpServletResponse response){
        //entêtes CORS
        rdvMedecinsCorsController.supprimerRv(response);
        //état de l'application
        if (messages != null){
            return new Reponse(-1, messages);
        }
        //on récupère les valeurs postées
        long idRv = post.getIdRv();
        //on récupère le rv
        Reponse reponse = getRv(idRv);
        if (reponse.getStatus() != 0){
            return reponse;
        }
        Rv rv = (Rv) reponse.getData();
        //suppression du rv
        try {
            application.supprimerRv(rv);
        } catch (Exception e1){
            return new Reponse(3, Static.getErreursForException(e1));
        }
        //ok
        return new Reponse(0, null);
    }

    //Un agenda via l'id du medecin et le jour
    @RequestMapping(value= "/getAgendaMedecinJour/{idMedecin}/{jour}", method= RequestMethod.GET)
    public Reponse getAgendaMedecinJour(@PathVariable("idMedecin") long idMedecin, @PathVariable("jour") String jour, HttpServletResponse response){
        //entêtes CORS
        rdvMedecinsCorsController.getAgendaMedecinJour(response);
        //état de l'application
        if( messages != null){
            return new Reponse(-1, messages);
        }
        //on vérifie la date
        Date jourAgenda = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            jourAgenda = sdf.parse(jour);
        } catch (ParseException e){
            return new Reponse (3, new String[] { String.format("jour [%s] invalide", jour)});
        }
        //on récupère le médecin
        Reponse reponse = getMedecin(idMedecin);
        if(reponse.getStatus() != 0){
            return reponse;
        }
        Medecin medecin = (Medecin) reponse.getData();
        //on récupère son agenda
        AgendaMedecinJour agenda = null;
        try {
            agenda = application.getAgendaMedecinJour(medecin.getId(), jourAgenda);
        } catch(Exception e1){
            return new Reponse(4, Static.getErreursForException(e1));
        }
        // ok
        return new Reponse(0, Static.getMapForAgendaMedecinJour(agenda));
    }

}
