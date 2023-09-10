/** RewardRepositoryImpl.java
 *  This class sets the repository for the rewards
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.repository.impl.reward;

import za.ac.cput.domain.reward.Reward;

import java.util.HashSet;
import java.util.Set;

public class RewardRepositoryImpl {
    private static RewardRepositoryImpl repository = null;
    private Set<Reward> rewardDB = null;

    private RewardRepositoryImpl() {
        rewardDB = new HashSet<Reward>();
    }

    public static RewardRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new RewardRepositoryImpl();
        }
        return repository;
    }
}
