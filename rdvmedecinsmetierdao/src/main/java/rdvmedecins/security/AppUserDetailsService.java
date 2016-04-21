package rdvmedecins.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rdvmedecins.entities.User;
import rdvmedecins.repositories.UserRepository;

/**
 * Created by GuillaumeD on 21/04/2016.
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // on cherche l'utilisateur via son login
        User user = userRepository.findUserByLogin(login);
        // trouvé?
        if (user == null){
            throw new UsernameNotFoundException(String.format("login [%s] inexistant", login));
        }
        // on rend les détails de l'utilisateur
        return new AppUserDetails(user, userRepository);
    }
}
