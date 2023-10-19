/** PlanServiceImplTest.java
 *  This class tests the service  class
 *  Andrea Jacobs 218024266
 *  10 September 2023 */

package za.ac.cput.service.impl.plan;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.plan.Plan;
import za.ac.cput.factory.plan.PlanFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PlanServiceImplTest {
    @Autowired
    private PlanServiceImpl service;

    Plan basic = PlanFactory.createBasic();
    Plan deluxe = PlanFactory.createDeluxe();
    Plan premium = PlanFactory.createPremium();

    //@Disabled
    @Order(1)
    @Test
    void testGetPlanById(){
        Plan result = service.getPlanById("4e7989e1-332d-4d89-ae32-ea2b371f4a7c");
        assertNotNull(result);
        System.out.println(result);
    }

    //@Disabled
    @Order(2)
    @Test
    void testGetAllPlans(){
        List<Plan> results = service.getAllPlans("4e7989e1-332d-4d89-ae32-ea2b371f4a7c");
        assertNotNull(results);
        System.out.println(results);
    }
}