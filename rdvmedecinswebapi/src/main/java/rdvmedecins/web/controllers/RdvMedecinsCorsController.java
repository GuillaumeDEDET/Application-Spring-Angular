package rdvmedecins.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rdvmedecins.web.models.ApplicationModel;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by GuillaumeD on 22/04/2016.
 */
@Controller
public class RdvMedecinsCorsController {

    @Autowired
    private ApplicationModel application;

    //envoi des options au client
    private void sendOptions(HttpServletResponse response) {
        if(application.isCORSneeded()) {
            //on fixe le header CORS
            response.addHeader("Access-Control-Allow-Origin", "*");
            //on autorise le header [Authorization]
            response.addHeader("Access-Control-Allow-Headers", "Authorization");
        }
    }

    //liste des médecins
    @RequestMapping(value = "/getAllMedecins", method = RequestMethod.OPTIONS)
    public void getAllMedecins(HttpServletResponse response){
        sendOptions(response);
    }
}
