package springapp.model;

import javax.persistence.*;

@Entity
@Table(name = "hackers_authentication", schema = "public", catalog = "Mr.Robot")
public class HackersAuthentication {
    private int id;
    private String login;
    private String password;
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
    @Column(name = "login", nullable = true, insertable = true, updatable = true, length = 64)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HackersAuthentication that = (HackersAuthentication) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
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
