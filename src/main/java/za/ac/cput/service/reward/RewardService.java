/** RewardService.java
 *  This class sets the business rules of the project
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.service.reward;

import za.ac.cput.domain.reward.Reward;

public interface RewardService {
    Reward calculate(Reward reward);
    Reward read(Reward reward);
    Reward update(Reward reward);
}
