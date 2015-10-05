package springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springapp.model.Hackers;

public interface HackersRepository extends JpaRepository<Hackers, Integer> {

    @Query("Select h from Hackers h where h.login = :login")
    Hackers findByLogin(@Param("login") String login);

}
