/** PlanServiceImpl.java
 *  This class implements the interface and sets the business rules
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.service.impl.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.plan.Plan;
import za.ac.cput.repository.plan.PlanRepository;
import za.ac.cput.service.plan.PlanService;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService{
    private PlanRepository repository;
    @Autowired
    private PlanServiceImpl(PlanRepository repository){
        this.repository = repository;
    }

    public Plan getPlanById(String planId){
        return repository.findByPlanId(planId);
    }

    public List<Plan> getAllPlans(String planId){
        return repository.findAll();
    }
}
