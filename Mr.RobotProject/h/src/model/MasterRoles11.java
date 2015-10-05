//package model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "master_roles", schema = "public", catalog = "Mr.Robot")
//public class MasterRoles11 {
//    private int id;
//    private String name;
//    private Masters masters;
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
//    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 64)
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        MasterRoles11 that = (MasterRoles11) o;
//
//        if (id != that.id) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "username")
//    public Masters11 getMasters() {
//        return masters;
//    }
//
//    public void setMasters(Masters11 masters) {
//        this.masters = masters;
//    }
//}
