package rdvmedecins.web.helpers;

import rdvmedecins.domain.AgendaMedecinJour;
import rdvmedecins.domain.CreneauMedecinJour;
import rdvmedecins.entities.Client;
import rdvmedecins.entities.Creneau;
import rdvmedecins.entities.Rv;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GuillaumeD on 20/04/2016.
 */
public class Static {

    public Static(){}

    //liste des messages d'erreur d'une exception
    public static List<String> getErreursForException(Exception exception){
        //on récupère la liste des messages d'erreur e l'exception
        Throwable cause = exception;
        List<String> erreurs = new ArrayList<String>();
        while (cause != null){
            erreurs.add(cause.getMessage());
            cause = cause.getCause();
        }
        return erreurs;
    }

    //Mappers Object --> Map
    //-------------------------------------------------------

    //Creneau --> Map
    public static Map<String, Object> getMapForCreneau(Creneau creneau){
        //quelque chose à faire?
        if (creneau == null){
            return null;
        }
        //dictionnaire <String, Object>
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("id", creneau.getId());
        hash.put("hDebut", creneau.getHdebut());
        hash.put("mDebut", creneau.getMdebut());
        hash.put("hFin", creneau.getHfin());
        hash.put("mFin", creneau.getMfin());
        //on rend le dictionnaire
        return hash;
    }

    //Client --> Map
    private static Map<String, Object> getMapForClient(Client client) {
        //quelque chose à faire?
        if (client == null){
            return null;
        }
        //dictionnaire <String,Object>
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("id", client.getId());
        hash.put("nom", client.getNom());
        hash.put("prenom", client.getPrenom());
        hash.put("titre", client.getTitre());
        //on rend le dictionnaire
        return hash;
    }

    //List<Creneau> ----> List<Map>
    public static List<Map<String, Object>> getListMapForCreneaux(List<Creneau> creneaux){
        //liste de dictionnaires <String,Object>
        List <Map<String, Object>> liste = new ArrayList<Map<String, Object>>();
        for (Creneau creneau : creneaux){
            liste.add(Static.getMapForCreneau(creneau));
        }
        //on rend la liste
        return liste;
    }

    //Rv --> Map
    public static Map<String, Object> getMapForRv(Rv rv){
        //quelque chose à faire ?
        if(rv == null){
            return null;
        }
        //dictionnaire <String,Object>
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("id", rv.getId());
        hash.put("client", getMapForClient(rv.getClient()));
        hash.put("creneau", getMapForCreneau(rv.getCreneau()));
        //on rend le dictionnaire
        return hash;
    }

    //List<Rv> -----> List<Map>
    public static List<Map<String, Object>> getListMapForRvs(List<Rv> rvs){
        //liste de dictionnaires <String,Object>
        List <Map<String, Object>> liste = new ArrayList<Map<String, Object>>();
        for(Rv rv : rvs){
            liste.add(Static.getMapForRv(rv));
        }
        //on rend la liste
        return liste;
    }

    // CreneauMedecinJour --> Map
    public static Map<String, Object> getMapForCreneauMedecinJour(CreneauMedecinJour creneau){
        // quelque chose à faire?
        if(creneau == null){
            return  null;
        }
        //dictionnaire <String, Object>
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("creneau", getMapForCreneau(creneau.getCreneau()));
        hash.put("rv", getMapForRv(creneau.getRv()));
        //on rend le dictionnaire
        return hash;
    }

    // AgendaMedecinJour --> Map
    public static Map<String, Object> getMapForAgendaMedecinJour(AgendaMedecinJour agenda) {
        //quelque chose à faire?
        if(agenda == null){
            return null;
        }
        //dictionnaire <String, Object>
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("medecin", agenda.getMedecin());
        hash.put("jour", agenda.getJour());
        List<Map<String, Object>> creneaux = new ArrayList<Map<String, Object>>();
        for(CreneauMedecinJour creneau : agenda.getCreneauxMedecinJour()){
            creneaux.add(getMapForCreneauMedecinJour(creneau));
        }
        hash.put("creneauxMedecin", creneaux);
        //on rend le dictionnaire
        return hash;
    }

    public static Map<String, Object> getMapForRv2(Rv rv) {
        // quelque chose à faire ?
        if (rv == null){
            return null;
        }
        //dictionnaire <String,Object>
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("id", rv.getId());
        hash.put("idClient", rv.getIdClient());
        hash.put("idCreneau", rv.getIdCreneau());
        // on rend le dictionnaire
        return hash;
    }
}
