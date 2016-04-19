package rdvmedecins.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rdvmedecins.entities.Rv;

import java.util.Date;

/**
 * Created by GuillaumeD on 19/04/2016.
 */
public interface RvRepository extends CrudRepository<Rv, Long> {

    @Query("SELECT rv FROM Rv rv LEFT JOIN FETCH rv.client c LEFT JOIN FETCH rv.creneau cr WHERE cr.medecin.id=?1 AND rv.jour=?2")
    Iterable<Rv> getRvMedecinJour(long idMedecin, Date jour);
}
