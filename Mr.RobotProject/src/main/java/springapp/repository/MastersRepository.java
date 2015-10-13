package springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springapp.model.Masters;


public interface MastersRepository extends JpaRepository<Masters, Integer> {

    @Query("Select m from Masters m where m.number = :number")
    Masters findByNumber(@Param("number") String number);

}
