package za.ac.cput.controller.plan;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.plan.Plan;
import za.ac.cput.service.plan.PlanService;

import java.util.List;

@RestController
@RequestMapping("/api/plan")
public class PlanController {
    private final PlanService service;

    @Autowired
    public PlanController(PlanService service) {
        this.service = service;
    }

    @GetMapping("/getplan")
    //@CrossOrigin(origins = "http://localhost:8081") // Allow requests from http://localhost:8081
    public List<Plan> getAllPlans() {
        return service.getAllPlans();
    }

    public Plan createPlan(@RequestBody Plan plan) {
        return service.save(plan);
    }
}
