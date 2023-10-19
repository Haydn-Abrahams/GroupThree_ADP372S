/** PlanFactoryTest.java
 *  This class tests the factory class
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.factory.plan;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.plan.Basic;
import za.ac.cput.domain.plan.Deluxe;
import za.ac.cput.domain.plan.Plan;

import static org.junit.jupiter.api.Assertions.*;
class PlanFactoryTest {
    @Test
    void testBasicPlan(){
        /*Plan expected = new Plan();
        expected.setBasic(true);*/

        Plan basic = PlanFactory.createBasic();

        assertNotNull(basic);
        System.out.println(basic.displayPlan());
    }

    @Test
    void testDeluxePlan(){
        Plan deluxe = PlanFactory.createDeluxe();

        assertNotNull(deluxe);
        System.out.println(deluxe.displayPlan());
    }

    @Test
    void testPremiumPlan(){
        Plan premium = PlanFactory.createPremium();

        assertNotNull(premium);
        System.out.println(premium.displayPlan());
    }

}