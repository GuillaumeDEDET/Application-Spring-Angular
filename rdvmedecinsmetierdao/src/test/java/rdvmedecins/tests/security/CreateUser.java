package rdvmedecins.tests.security;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCrypt;
import rdvmedecins.config.DomainAndPersistenceConfig;
import rdvmedecins.entities.Role;
import rdvmedecins.entities.User;
import rdvmedecins.entities.UserRole;
import rdvmedecins.repositories.RoleRepository;
import rdvmedecins.repositories.UserRepository;
import rdvmedecins.repositories.UserRoleRepository;

/**
 * Created by GuillaumeD on 21/04/2016.
 */
public class CreateUser {
    public static void main(String[] args){
        // syntaxe : login password roleName
        // il faut trois paramètres
        if (args.length != 3){
            System.out.println("Syntaxe : [pg] user password role");
            System.exit(0);
        }
        // on récupère les paramètres
        String login = args[0];
        String password = args[1];
        String roleName = String.format("ROLE_%s", args[2].toUpperCase());
        // contexte Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DomainAndPersistenceConfig.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        RoleRepository roleRepository = context.getBean(RoleRepository.class);
        UserRoleRepository userRoleRepository = context.getBean(UserRoleRepository.class);
        //le rôle existe-t-il déjà ?
        Role role = roleRepository.findRoleByName(roleName);
        //s'il n'existe pas on le crée
        if (role == null){
            role = roleRepository.save(new Role(roleName));
        }
        // l'utilisateur existe-t-il déjà ?
        User user = userRepository.findUserByLogin(login);
        //s'il n'existe pas on le crée
        if (user == null){
            // on hashe le mot de passe avec le bcrypt
            String crypt = BCrypt.hashpw(password, BCrypt.gensalt());
            // on sauvegarde l'utilisateur
            user = userRepository.save(new User(login, login, crypt));
            // on crée la relation avec le rôle
            userRoleRepository.save(new UserRole(user, role));
        } else {
            // l'utilisateur existe déjà, a-t-il le rôle demandé ?
            boolean found = false;
            for (Role r : userRepository.getRoles(user.getId())) {
                if (r.getName().equals(roleName)){
                    found = true;
                    break;
                }
            }
            // si pas trouvé, on crée la relation avec le rôle
            if (!found){
                userRoleRepository.save(new UserRole(user, role));
            }
        }

        // fermeture contexte Spring
        context.close();

    }
}
