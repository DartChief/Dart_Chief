package springapp.repository;

import springapp.model.HackersStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackersStatusRepository extends JpaRepository<HackersStatus, Integer> {
}
