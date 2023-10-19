package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Complex;

@Repository
public interface ComplexRepository extends JpaRepository<Complex, Long> {
}
