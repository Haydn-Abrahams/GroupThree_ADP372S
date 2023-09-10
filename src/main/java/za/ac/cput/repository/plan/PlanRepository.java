/** PlanRepository.java
 *  This class sets up the repository for the various plans
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.repository.plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.plan.Plan;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepository extends JpaRepository<Plan, String> {
    Plan findByPlanId(String planId);
    List<Plan> findAll();
}
