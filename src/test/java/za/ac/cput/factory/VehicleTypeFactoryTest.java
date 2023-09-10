package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.VehicleType;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTypeFactoryTest {
    @Test
    void createVehicleType(){
        VehicleType vehicleType = VehicleTypeFactory.buildVehicleType("Yamaha", "Nissan Almera", "Quantum", "Iveco");
        System.out.println(vehicleType.toString());
        assertNotNull(vehicleType);
    }
}
