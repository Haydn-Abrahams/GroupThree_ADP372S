/** RewardServiceImplTest.java
 *  This tests the service method
 *  Andrea Jacobs 218024266
 *  10 September 2023 */

package za.ac.cput.service.impl.reward;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.reward.Reward;
import za.ac.cput.domain.reward.Tier;
import za.ac.cput.factory.reward.RewardFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class RewardServiceImplTest {
    @Autowired
    private RewardServiceImpl service;

    Reward reward = RewardFactory.createReward(500, Tier.PLATINUM);

    @Test
    void e_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }

    @Test
    void a_create() {
        Reward created = service.create(reward);
        assertEquals(reward.getRewardId(), created.getRewardId());
        System.out.println("Created: " + reward);
    }

    @Test
    void b_read() {
        Reward read = service.read(reward.getRewardId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        Reward newRewards = new Reward.Builder()
                .copy(reward)
                .setPoints(505)
                .build();
    }

    @Disabled
    @Test
    void d_delete() {
    }
}