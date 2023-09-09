/** RewardRepository.java
 *  This class sets the repository
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.repository.reward;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.reward.Reward;

@Repository
public interface RewardRepository extends JpaRepository<Reward, String> {
}
