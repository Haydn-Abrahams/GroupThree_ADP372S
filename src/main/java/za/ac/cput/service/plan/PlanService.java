/** PlanService.java
 *  This class is the interface to the service packages
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.service.plan;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.plan.Plan;

import java.util.List;

@Service
public interface PlanService {
    Plan getPlanById(String planId);
    List<Plan> getAllPlans(String planId);

}
