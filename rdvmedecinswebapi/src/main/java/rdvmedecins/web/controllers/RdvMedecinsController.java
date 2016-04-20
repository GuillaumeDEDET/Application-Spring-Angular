package rdvmedecins.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rdvmedecins.entities.Creneau;
import rdvmedecins.entities.Medecin;
import rdvmedecins.web.helpers.Static;
import rdvmedecins.web.models.ApplicationModel;
import rdvmedecins.web.models.PostAjouterRv;
import rdvmedecins.web.models.PostSupprimerRv;
import rdvmedecins.web.models.Reponse;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by GuillaumeD on 20/04/2016.
 */
@RestController
public class RdvMedecinsController {

    @Autowired
    private ApplicationModel application;
    private List<String> messages;

    @PostConstruct
    public void init(){
        //messages d'erreur de l'application
        messages = application.getMessages();
    }

    //liste des médecins
    @RequestMapping(value = "/getAllMedecins", method = RequestMethod.GET)
    public Reponse getAllMedecins(){
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
    public Reponse getAllClients(){
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
        return null;
    }

    //Un client via son id
    @RequestMapping(value= "/getClientById/{id}", method = RequestMethod.GET)
    public Reponse getClientById(@PathVariable("id") long id){
        return null;
    }

    //Un médecin via son id
    @RequestMapping(value= "/getMedecinById/{id}", method = RequestMethod.GET)
    public Reponse getMedecinById(@PathVariable("id") long id){
        return null;
    }

    //Un rdv via son id
    @RequestMapping(value= "/getRvById/{id}", method = RequestMethod.GET)
    public Reponse getRvById(@PathVariable("id") long id){
        return null;
    }

    //Un créneau via son id
    @RequestMapping(value= "/getCreneauById/{id}", method = RequestMethod.GET)
    public Reponse getCreneauById(@PathVariable("id") long id){
        return null;
    }

    //Un ajout de rdv
    @RequestMapping(value= "/ajouterRv", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Reponse ajouterRv(@RequestBody PostAjouterRv post){
        return null;
    }

    //Une suppression de rdv
    @RequestMapping(value= "/supprimerRv", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Reponse supprimerRv(@RequestBody PostSupprimerRv post){
        return null;
    }

    //Un agenda via l'id du medecin et le jour
    @RequestMapping(value= "/getAgendaMedecinJour/{idMedecin}/{jour}", method= RequestMethod.GET)
    public Reponse getAgendaMedecinJour(@PathVariable("idMedecin") long idMedecin, @PathVariable("jour") String jour){
        return null;
    }






}
