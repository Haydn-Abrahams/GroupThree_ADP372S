/** PlanController.java
 *  This class sets the controller of the project
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.controller.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.plan.Plan;
import za.ac.cput.service.impl.plan.PlanServiceImpl;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanServiceImpl service;

    @GetMapping("/read{id}")
    public Plan read(@PathVariable String planId) {
        return (Plan) service.getAllPlans(planId);
    }
}
