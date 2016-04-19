package rdvmedecins.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rdvmedecins.entities.Creneau;

/**
 * Created by GuillaumeD on 19/04/2016.
 */
public interface CreneauRepository extends CrudRepository<Creneau, Long> {
    //Liste des créneaux horaires d'un médecin
    @Query("SELECT c FROM Creneau c WHERE c.medecin.id=?1")
    Iterable<Creneau> getAllCreneaux(long idMedecin);
}
