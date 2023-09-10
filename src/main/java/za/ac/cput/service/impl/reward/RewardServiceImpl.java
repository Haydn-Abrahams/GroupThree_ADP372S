/** RewardServiceImpl.java
 *  This class sets the functionality of the business rules
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.service.impl.reward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.reward.Reward;
import za.ac.cput.repository.reward.RewardRepository;
import za.ac.cput.service.reward.RewardService;

import java.util.Set;

@Service
public class RewardServiceImpl implements RewardService {
    private RewardRepository repository;
    @Autowired
    private RewardServiceImpl(RewardRepository repository){
        this.repository = repository;
    }

    @Override
    public Set<Reward> getAll() {
        return null;
    }

    @Override
    public Reward create(Reward reward){
        return this.repository.save(reward);
    }

    @Override
    public Reward read(String rewardsId){
        return this.repository.findById(rewardsId).orElse(null);
    }

    @Override
    public Reward update(Reward reward){
        if(this.repository.existsById(reward.getRewardId()));
        this.repository.save(reward);
        return null;
    }

    @Override
    public boolean delete(String rewardId){
        if(this.repository.existsById(rewardId)){
            this.repository.deleteAllById(rewardId);
            return true;
        }
        return false;
    }

}
