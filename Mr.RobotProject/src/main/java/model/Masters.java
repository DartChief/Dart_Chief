package model;

import javax.persistence.*;

@Entity
@Table(name = "masters")
public class Masters {
    private int id;
    private Integer number;
    private String email;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = true, insertable = true, updatable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Masters masters = (Masters) o;

        if (id != masters.id) return false;
        if (number != null ? !number.equals(masters.number) : masters.number != null) return false;
        if (email != null ? !email.equals(masters.email) : masters.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
