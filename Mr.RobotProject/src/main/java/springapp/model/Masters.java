package springapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Masters implements Serializable{
    private int id;
    private String email;
    private String password;
    private String number;
    private Set<MasterRoles> masterRoles;

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
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "number", nullable = true, insertable = true, updatable = true, length = 64)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Masters masters = (Masters) o;

        if (id != masters.id) return false;
        if (email != null ? !email.equals(masters.email) : masters.email != null) return false;
        if (password != null ? !password.equals(masters.password) : masters.password != null) return false;
        if (number != null ? !number.equals(masters.number) : masters.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "masters")
    public Set<MasterRoles> getMasterRoles() {
        return masterRoles;
    }

    public void setMasterRoles(Set<MasterRoles> masterRoles) {
        this.masterRoles = masterRoles;
    }
}
