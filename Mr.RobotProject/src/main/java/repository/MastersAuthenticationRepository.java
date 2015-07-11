package repository;

import model.MastersAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MastersAuthenticationRepository extends JpaRepository<MastersAuthentication, Integer> {
}
