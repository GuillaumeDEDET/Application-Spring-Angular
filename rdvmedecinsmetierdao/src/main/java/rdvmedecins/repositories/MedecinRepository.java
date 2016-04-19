package rdvmedecins.repositories;

import org.springframework.data.repository.CrudRepository;
import rdvmedecins.entities.Medecin;

/**
 * Created by GuillaumeD on 19/04/2016.
 */
public interface MedecinRepository extends CrudRepository<Medecin, Long> {
}
