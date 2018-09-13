/**
 * This file was generated by the Jeddict
 */
package entity.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author sawad
 */
@Entity
public class GroupAuth implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String groupname;

    @ManyToMany(mappedBy = "groupAuths")
    private List<UserAuth> userAuths;

    public GroupAuth() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupname() {
        return this.groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public List<UserAuth> getUserAuths() {
        if (userAuths == null) {
            userAuths = new ArrayList<>();
        }
        return this.userAuths;
    }

    public void setUserAuths(List<UserAuth> userAuths) {
        this.userAuths = userAuths;
    }

    public void addUserAuth(UserAuth userAuth) {
        getUserAuths().add(userAuth);
    }

    public void removeUserAuth(UserAuth userAuth) {
        getUserAuths().remove(userAuth);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GroupAuth other = (GroupAuth) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}