package rdvmedecins.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by GuillaumeD on 19/04/2016.
 */

@MappedSuperclass
public class AbstractEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Version
    protected Long version;

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    // initialisation
    public AbstractEntity build(Long id, Long version) {
        this.id = id;
        this.version = version;
        return  this;
    }

    @Override
    public boolean equals(Object entity) {
        String class1 = this.getClass().getName();
        String class2 = entity.getClass().getName();
        if (!class2.equals(class1)) {
            return false;
        }
        AbstractEntity other = (AbstractEntity) entity;
        return this.id == other.id;
    }

    // getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
