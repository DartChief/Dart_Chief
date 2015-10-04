package springapp.model;

import javax.persistence.*;

@Entity
@Table(name = "hackers_status", schema = "public", catalog = "Mr.Robot")
public class HackersStatus {
    private int id;
    private String status;
    private Hackers hackersByHackerId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true, length = 64)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HackersStatus that = (HackersStatus) o;

        if (id != that.id) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "hacker_id", referencedColumnName = "id")
    public Hackers getHackersByHackerId() {
        return hackersByHackerId;
    }

    public void setHackersByHackerId(Hackers hackersByHackerId) {
        this.hackersByHackerId = hackersByHackerId;
    }
}
