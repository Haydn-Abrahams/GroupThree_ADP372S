/** BasicRepository.java
 *  This class sets the repository
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.repository.plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.plan.Basic;

@Repository
public interface BasicRepository extends JpaRepository<Basic, String> {
}
