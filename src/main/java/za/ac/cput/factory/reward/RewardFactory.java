/** RewardFactory.java
 *  This class builds the object
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.factory.reward;

import za.ac.cput.domain.reward.Reward;
import za.ac.cput.domain.reward.Tier;
import za.ac.cput.util.Helper;

public class RewardFactory {
    public static Reward createReward(int points, Tier tier){
        String rewardId = Helper.generateID();


        return new Reward.Builder()
                .setRewardId(rewardId)
                .setTier(tier)
                .setPoints(points)
                .build();
    }
}
