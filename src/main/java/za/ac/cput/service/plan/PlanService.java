package za.ac.cput.service.plan;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.plan.Plan;
import za.ac.cput.repository.plan.PlanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    private final PlanRepository repository;

    @Autowired
    public PlanService(PlanRepository repository) {
        this.repository = repository;
    }

    public List<Plan> getAllPlans() {
        return repository.findAll();
    }

    public Plan createPlan(Plan plan) {
        return repository.save(plan);
    }

    public Plan getByPlanId(Long planId) {
        Optional<Plan> person = repository.findById(planId);
        if (person.isPresent()) {
            return person.get();
        } else {
            throw new EntityNotFoundException("Plan not found with id: " + planId);
        }
    }
}
