package springapp.repository;

import springapp.model.HackersContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackersContentRepository extends JpaRepository<HackersContent, Integer> {
}
