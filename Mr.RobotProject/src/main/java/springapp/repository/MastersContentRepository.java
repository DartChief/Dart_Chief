package springapp.repository;

import springapp.model.MastersContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MastersContentRepository extends JpaRepository<MastersContent, Integer> {
}
