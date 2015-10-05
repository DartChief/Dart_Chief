package springapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "master_roles", schema = "public", catalog = "Mr.Robot")
public class MasterRoles implements Serializable {
    private int id;
    private String name;
    private String username;
    private Masters mastersByUsername;

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = false, updatable = false, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "username", nullable = true, insertable = false, updatable = false, length = 64)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MasterRoles that = (MasterRoles) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "number")
    public Masters getMastersByUsername() {
        return mastersByUsername;
    }

    public void setMastersByUsername(Masters mastersByUsername) {
        this.mastersByUsername = mastersByUsername;
    }
}
