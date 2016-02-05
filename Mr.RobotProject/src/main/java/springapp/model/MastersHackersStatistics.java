package springapp.model;

import javax.persistence.*;

@Entity
@Table(name = "masters_hackers_statistics", schema = "public", catalog = "Mr.Robot")
public class MastersHackersStatistics {
    private int id;
    private Hackers hackersByHackerId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MastersHackersStatistics that = (MastersHackersStatistics) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
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
