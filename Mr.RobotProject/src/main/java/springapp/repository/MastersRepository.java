package springapp.repository;

import springapp.model.Masters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MastersRepository extends JpaRepository<Masters, Integer> {

    @Query("Select m from Masters m where m.number = :number")
    Masters findByNumber(@Param("number") String number);

}
