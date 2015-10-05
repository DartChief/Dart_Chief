//package model;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//public class Masters {
//    private int id;
//    private String email;
//    private String password;
//    private String number;
//    private boolean enabled;
//    private Set<MasterRoles11> masterRoles = new HashSet<MasterRoles11>(0);
//
//    public Masters11(String number, String password, boolean enabled) {
//        this.number = number;
//        this.password = password;
//        this.enabled = enabled;
//    }
//
//    public Masters11(String number, String password, boolean enabled, Set<MasterRoles11> masterRoles) {
//        this.number = number;
//        this.password = password;
//        this.enabled = enabled;
//        this.masterRoles = masterRoles;
//    }
//
//    public Masters11() {
//    }
//
//    @Id
//    @Column(name = "id", nullable = false, insertable = true, updatable = true)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 64)
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Basic
//    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 64)
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Basic
//    @Column(name = "number", nullable = true, insertable = true, updatable = true, length = 64)
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    @Column(name = "enabled", nullable = false)
//    public boolean isEnabled() {
//        return this.enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Masters11 masters = (Masters11) o;
//
//        if (id != masters.id) return false;
//        if (email != null ? !email.equals(masters.email) : masters.email != null) return false;
//        if (password != null ? !password.equals(masters.password) : masters.password != null) return false;
//        if (number != null ? !number.equals(masters.number) : masters.number != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (number != null ? number.hashCode() : 0);
//        return result;
//    }
//
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "masters")
//    public Set<MasterRoles11> getMasterRoles() {
//        return masterRoles;
//    }
//
//    public void setMasterRoles(Set<MasterRoles11> masterRoles) {
//        this.masterRoles = masterRoles;
//    }
//}
