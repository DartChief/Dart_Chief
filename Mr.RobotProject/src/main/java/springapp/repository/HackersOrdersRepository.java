package springapp.repository;

import springapp.model.HackersOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackersOrdersRepository extends JpaRepository<HackersOrders, Integer> {
}
