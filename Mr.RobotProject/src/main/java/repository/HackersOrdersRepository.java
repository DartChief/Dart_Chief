package repository;

import model.HackersOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackersOrdersRepository extends JpaRepository<HackersOrders, Integer> {
}
