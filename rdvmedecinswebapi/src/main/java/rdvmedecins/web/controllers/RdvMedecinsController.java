package rdvmedecins.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by GuillaumeD on 20/04/2016.
 */
@RestController
public class RdvMedecinsController {

    @Autowired
    private ApplicationModel application;
    private List<String> messages;


}
