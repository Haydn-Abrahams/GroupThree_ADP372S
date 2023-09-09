/** BasicTest.java
 *  This class tests is the Basic Class was built correctly
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.factory.plan;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.plan.Basic;

import static org.junit.jupiter.api.Assertions.*;

class BasicFactoryTest {
    @Test
    void basicTest(){
        Basic basic = BasicFactory.createBasic("WASH, WAX", "VACCUM, WIPE-DOWN", "1-2 HOURS", 500, "NONE");
        assertNotNull(basic);
        System.out.println(basic.displayPlan());
    }

}