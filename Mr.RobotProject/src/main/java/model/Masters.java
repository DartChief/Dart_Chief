package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Masters {
    private int id;
    private String email;
    private String number;
    private String password;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="id")
    private Set<MasterRoles> masterRoles = new HashSet<>();


    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "number", nullable = true, insertable = true, updatable = true, unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<MasterRoles> getMasterRoles() {
        return masterRoles;
    }

    public void setMasterRoles(Set<MasterRoles> masterRoles) {
        this.masterRoles = masterRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Masters masters = (Masters) o;

        if (id != masters.id) return false;
        if (email != null ? !email.equals(masters.email) : masters.email != null) return false;
        if (number != null ? !number.equals(masters.number) : masters.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
