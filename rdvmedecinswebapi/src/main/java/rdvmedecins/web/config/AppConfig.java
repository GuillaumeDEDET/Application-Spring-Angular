package rdvmedecins.web.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import rdvmedecins.config.DomainAndPersistenceConfig;

/**
 * Created by GuillaumeD on 20/04/2016.
 */

@EnableAutoConfiguration
@ComponentScan(basePackages = { "rdvmedecins.web"})
@Import({DomainAndPersistenceConfig.class})
public class AppConfig {}
