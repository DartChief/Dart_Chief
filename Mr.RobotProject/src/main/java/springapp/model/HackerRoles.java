package springapp.model;

import javax.persistence.*;

@Entity
@Table(name = "hacker_roles", schema = "public", catalog = "Mr.Robot")
public class HackerRoles {
    private int id;
    private String name;
    private Hackers hackers;

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

        HackerRoles that = (HackerRoles) o;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", referencedColumnName = "login")
    public Hackers getHackers() {
        return hackers;
    }

    public void setHackers(Hackers hackers) {
        this.hackers = hackers;
    }
}
