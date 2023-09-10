package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.VehicleType;

public interface IVehicleTypeRepository extends JpaRepository<VehicleType, String> {
}
