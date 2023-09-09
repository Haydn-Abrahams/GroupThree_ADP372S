/** RewardServiceImpl.java
 *  This class sets the functionality of the business rules
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.service.impl.reward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.reward.Reward;
import za.ac.cput.repository.impl.reward.RewardRepositoryImpl;
import za.ac.cput.repository.reward.RewardRepository;
import za.ac.cput.service.reward.RewardService;

import java.util.List;

@Service
public class RewardServiceImpl /** implements RewardService */{
    private static RewardRepository repository;

    @Autowired
    private RewardServiceImpl(RewardRepository repository){
        this.repository = repository;
    }

   /** @Override
    public List<Reward> calculate(String rewardId) {
        return repository.findByRewardId(rewardId);

        double points;

        for(Booking price : calculate(rewardId)){
            points += price.getPrice() * 0.1;
        }
        return points;
    }

    @Override
    public Reward read(Reward reward) {
        return null;
    }

    @Override
    public Reward update(Reward reward) {
        return null;
    }*/
}
