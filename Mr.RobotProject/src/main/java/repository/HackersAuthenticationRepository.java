package repository;

import model.HackersAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackersAuthenticationRepository extends JpaRepository<HackersAuthentication, Integer> {
}
