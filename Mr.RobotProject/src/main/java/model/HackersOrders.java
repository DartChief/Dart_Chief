package model;

import javax.persistence.*;

@Entity
@Table(name = "hackers_orders", schema = "public", catalog = "Mr.Robot")
public class HackersOrders {
    private int id;
    private Integer count;
    private Double summ;
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
    @Column(name = "count", nullable = true, insertable = true, updatable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "summ", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getSumm() {
        return summ;
    }

    public void setSumm(Double summ) {
        this.summ = summ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HackersOrders that = (HackersOrders) o;

        if (id != that.id) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (summ != null ? !summ.equals(that.summ) : that.summ != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (summ != null ? summ.hashCode() : 0);
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
