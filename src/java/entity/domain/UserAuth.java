package entity.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author sawad
 */
@Entity
public class UserAuth implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String username;

    @Basic
    private String password;

    @Basic
    private String email;

    @ManyToOne
    private Clinic clinic;

    @ManyToMany
    private List<GroupAuth> groupAuths;

    public UserAuth() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Clinic getClinic() {
        return this.clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public List<GroupAuth> getGroupAuths() {
        if (groupAuths == null) {
            groupAuths = new ArrayList<>();
        }
        return this.groupAuths;
    }

    public void setGroupAuths(List<GroupAuth> groupAuths) {
        this.groupAuths = groupAuths;
    }

    public void addGroupAuth(GroupAuth groupAuth) {
        getGroupAuths().add(groupAuth);
        groupAuth.getUserAuths().add(this);
    }

    public void removeGroupAuth(GroupAuth groupAuth) {
        getGroupAuths().remove(groupAuth);
        groupAuth.getUserAuths().remove(this);
    }

}
