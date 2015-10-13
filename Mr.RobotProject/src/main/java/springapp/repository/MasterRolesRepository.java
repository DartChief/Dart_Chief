//package springapp.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import springapp.model.MasterRoles;
//
//import java.util.Set;
//
//public interface MasterRolesRepository extends JpaRepository<MasterRoles, Integer> {
//
//    @Query("Select m.name from master_roles m where m.username = :username")
//    String getMasterRolesName(@Param("username") String username);
//
//    @Query("Select m from master_roles m where m.username = :number")
//    Set<MasterRoles> getMasterRolesByNumber(@Param("number") String number);
//
//}
