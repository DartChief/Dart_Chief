package springapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "hackers", schema = "public", catalog = "Mr.Robot")
public class Hackers implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer rank;
    private String ip;
    private String password;
    private String login;
    private boolean enabled;
    private Set<HackerRoles> hackerRoles;

    public Hackers(String login, String password, boolean enabled) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
    }

    public Hackers(String login, String password, boolean enabled, Set<HackerRoles> hackerRoles) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.hackerRoles = hackerRoles;
    }

    public Hackers() {
    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = true, insertable = true, updatable = true, length = 64)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, insertable = true, updatable = true, length = 64)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    @Column(name = "rank", nullable = true, insertable = true, updatable = true)
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "ip", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
    @Column(name = "login", nullable = true, insertable = true, updatable = true, length = 64)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hackers hackers = (Hackers) o;

        if (id != hackers.id) return false;
        if (firstName != null ? !firstName.equals(hackers.firstName) : hackers.firstName != null) return false;
        if (lastName != null ? !lastName.equals(hackers.lastName) : hackers.lastName != null) return false;
        if (email != null ? !email.equals(hackers.email) : hackers.email != null) return false;
        if (rank != null ? !rank.equals(hackers.rank) : hackers.rank != null) return false;
        if (ip != null ? !ip.equals(hackers.ip) : hackers.ip != null) return false;
        if (password != null ? !password.equals(hackers.password) : hackers.password != null) return false;
        if (login != null ? !login.equals(hackers.login) : hackers.login != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "hackers")
    public Set<HackerRoles> getHackerRoles() {
        return hackerRoles;
    }

    public void setHackerRoles(Set<HackerRoles> hackerRoles) {
        this.hackerRoles = hackerRoles;
    }
}
