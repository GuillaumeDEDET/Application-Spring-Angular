package rdvmedecins.entities;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by GuillaumeD on 20/04/2016.
 */
@Entity
@Table(name = "USERS_ROLES")
public class UserRole extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    //un UserRole référence un User
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    //un UserRole référence un Role
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;


    //getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
