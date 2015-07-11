package repository;

import model.HackersStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackersStatusRepository extends JpaRepository<HackersStatus, Integer> {
}
