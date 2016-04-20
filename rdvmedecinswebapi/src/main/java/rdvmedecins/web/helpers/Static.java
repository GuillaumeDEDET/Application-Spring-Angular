package rdvmedecins.web.helpers;

import rdvmedecins.entities.Creneau;

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
        //dictionnaire <String, Object?
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("id", creneau.getId());
        hash.put("hDebut", creneau.getHdebut());
        hash.put("mDebut", creneau.getMdebut());
        hash.put("hFin", creneau.getHfin());
        hash.put("mFin", creneau.getMfin());
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
}
