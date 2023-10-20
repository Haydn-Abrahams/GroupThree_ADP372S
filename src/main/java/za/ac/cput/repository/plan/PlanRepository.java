package za.ac.cput.repository.plan;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.plan.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
