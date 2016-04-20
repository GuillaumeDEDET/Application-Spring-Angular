package rdvmedecins.web.boot;

import org.springframework.boot.SpringApplication;
import rdvmedecins.web.config.AppConfig;

/**
 * Created by GuillaumeD on 20/04/2016.
 */
public class Boot {

    public static void main(String[] args){
        SpringApplication.run(AppConfig.class, args);
    }
}
