package za.ac.cput.controller.plan;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.plan.Plan;
import za.ac.cput.service.plan.PlanService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PlanController {
    private final PlanService service;

    @Autowired
    public PlanController(PlanService service) {
        this.service = service;
    }

    @GetMapping("/getplan")
    public List<Plan> getAllPlans() {
        return service.getAllPlans();
    }

    @PostMapping
    public Plan createPlan(@RequestBody Plan plan) {
        return service.createPlan(plan);
    }

    @GetMapping("plan/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Long planId) {
        try {
            Plan plan = service.getByPlanId(planId);
            return ResponseEntity.ok(plan);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
