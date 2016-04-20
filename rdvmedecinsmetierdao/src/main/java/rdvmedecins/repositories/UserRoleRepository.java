package rdvmedecins.repositories;

import org.springframework.data.repository.CrudRepository;
import rdvmedecins.entities.UserRole;

/**
 * Created by GuillaumeD on 20/04/2016.
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

}
