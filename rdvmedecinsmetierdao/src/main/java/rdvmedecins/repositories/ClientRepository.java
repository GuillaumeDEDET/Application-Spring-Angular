package rdvmedecins.repositories;

import org.springframework.data.repository.CrudRepository;
import rdvmedecins.entities.Client;

/**
 * Created by GuillaumeD on 19/04/2016.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
}
