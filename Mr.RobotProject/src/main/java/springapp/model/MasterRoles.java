package springapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "master_roles", schema = "public", catalog = "Mr.Robot")
public class MasterRoles implements Serializable {
    private int id;
    private String name;
    private Masters masters;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MasterRoles that = (MasterRoles) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "number")
    public Masters getMasters() {
        return masters;
    }

    public void setMasters(Masters masters) {
        this.masters = masters;
    }
}
