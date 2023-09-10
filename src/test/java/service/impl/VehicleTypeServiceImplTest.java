package service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.VehicleType;
import za.ac.cput.factory.VehicleTypeFactory;
import za.ac.cput.service.VehicleTypeService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VehicleTypeServiceImplTest {

    @Autowired
    private static VehicleTypeService vehicleTypeService;

    private static VehicleType vehicleType = VehicleTypeFactory.buildVehicleType("Yamaha", "Nissan Almera", "Quantum", "Iveco");

    @Test
    @Order(1)
    void create() {
        VehicleType created = vehicleTypeService.create(vehicleType);
        assertNotNull(created);
        assertEquals(vehicleType.getMotorcycle(), created.getMotorcycle());
    }

    @Test
    @Order(2)
    void read() {
        VehicleType read = vehicleTypeService.read(vehicleType.getMotorcycle());
        assertNotNull(read);
        assertEquals(vehicleType.getMotorcycle(), read.getMotorcycle());
    }

    @Test
    @Order(3)
    void update() {
        VehicleType updated = new VehicleType.Builder().copy(vehicleType).setLightWeightCar("Volkswagen Jetta").build();
        updated = vehicleTypeService.update(updated);
        assertNotNull(updated);
        assertEquals("Volkswagen Jetta", updated.getLightWeightCar());
    }

    @Test
    @Order(4)
    void delete() {
        boolean deleted = vehicleTypeService.delete(vehicleType.getMotorcycle());
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {
        assertNotNull(vehicleTypeService.getAll());
    }
}
