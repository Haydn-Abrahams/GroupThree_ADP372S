/** PlanControllerTest.java
 *  This class tests the controller
 *  Andrea Jacobs 218024266
 *  10 September 2023 */

package za.ac.cput.controller.plan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.plan.Plan;
import za.ac.cput.factory.plan.PlanFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlanControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "https://localhost:8080/plan";

    Plan basic = PlanFactory.createBasic();
    @Test
    void read(){
        String url = baseURL + "/read/" + basic.getPlanId();
        System.out.println("URL" + url);
        ResponseEntity<Plan> response = restTemplate.getForEntity(url, Plan.class);
        assertEquals(basic.getPlanId(), response.getBody().getPlanId());
        System.out.println(response.getBody());
    }

}