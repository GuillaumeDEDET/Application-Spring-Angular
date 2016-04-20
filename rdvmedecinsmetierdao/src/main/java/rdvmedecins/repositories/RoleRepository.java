package rdvmedecins.repositories;

import org.springframework.data.repository.CrudRepository;
import rdvmedecins.entities.Role;

/**
 * Created by GuillaumeD on 20/04/2016.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    //recherche d'un rôle via son nom
    Role findRoleByName(String name);

}
