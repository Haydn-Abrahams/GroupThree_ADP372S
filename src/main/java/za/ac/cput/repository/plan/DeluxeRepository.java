package za.ac.cput.repository.plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.plan.Deluxe;

@Repository
public interface DeluxeRepository extends JpaRepository<Deluxe, String> {
}
