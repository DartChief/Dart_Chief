package repository;

import model.Hackers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HackersRepository extends JpaRepository<Hackers, Integer> {

    @Query("Select from hackers where login = :login")
    Hackers findByLogin(@Param("login") String login);

}
