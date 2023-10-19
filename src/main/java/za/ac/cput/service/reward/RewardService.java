/** RewardService.java
 *  This class sets the business rules of the project
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.service.reward;


import org.springframework.stereotype.Service;
import za.ac.cput.domain.reward.Reward;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Set;
@Service
public interface RewardService {
    public Set<Reward> getAll();

    Reward create(Reward reward);

    Reward read(String rewardsId);

    Reward update(Reward reward);
}
