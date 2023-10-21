package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.VehicleType;
import za.ac.cput.factory.VehicleTypeFactory;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class VehicleTypeServiceTest {
    @Autowired
    private VehicleTypeService vehicleTypeService;

    private static VehicleType vehicleType;

    @BeforeAll
    public static void setUp(){
        vehicleType = VehicleTypeFactory.buildVehicleType("Yamaha", "Nissan Almera", "Quantum", "Iveco");
    }

    @Test
    @Order(1)
    void save(){
        vehicleType = vehicleTypeService.create(vehicleType);
        assertNotNull(vehicleType);
        assertNotNull(vehicleTypeService.read(vehicleType.toString()));
    }

    @Test
    @Order(2)
    void getById(){
        VehicleType readVehicleType = vehicleTypeService.read(vehicleType.toString());
        assertNotNull(readVehicleType);
        assertEquals(vehicleType.toString(), readVehicleType.toString());
    }

    @Test
    @Order(3)
    void update(){
        VehicleType updateVehicleType = new VehicleType.Builder().copy(vehicleType).setLightWeightCar("Honda Jazz").build();
        updateVehicleType = vehicleTypeService.update(updateVehicleType);
        assertNotNull(updateVehicleType);
        assertEquals("Honda Jazz", updateVehicleType.getLightWeightCar());
    }

    @Test
    @Order(4)
    void deleteById(){
        boolean isDeleted = vehicleTypeService.delete(vehicleType.getMotorcycle());
        assertTrue(isDeleted);
        assertNull(vehicleTypeService.read(vehicleType.getMotorcycle()));
    }

    @Test
    @Order(5)
    void getAll(){
        List<VehicleType> vehicleTypes = vehicleTypeService.getAll();
        assertNotNull(vehicleTypes);
        assertFalse(vehicleTypes.isEmpty());
    }
}
