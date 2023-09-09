/** RewardFactoryTest.java
 *  This is a test class
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.factory.reward;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.reward.Reward;
import za.ac.cput.domain.reward.Tier;

import static org.junit.jupiter.api.Assertions.*;

class RewardFactoryTest {
    @Test
    void rewardTest(){
        Reward reward = RewardFactory.createReward(500, Tier.PLATINUM);
        assertNotNull(reward);
        System.out.println(reward.toString());
    }


}