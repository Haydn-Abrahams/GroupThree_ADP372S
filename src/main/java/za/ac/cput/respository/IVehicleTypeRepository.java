package za.ac.cput.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.VehicleType;

public interface IVehicleTypeRepository extends JpaRepository<VehicleType, String> {
}
