package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.BaseAddress;

@Repository
public interface BaseAddressRepository extends JpaRepository<BaseAddress, Long> {
}
