package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Vehicle;

import za.ac.cput.factory.VehicleFactory;

import za.ac.cput.service.VehicleService;

import static org.junit.jupiter.api.Assertions.*;



class VehicleServiceImplTest {



    private VehicleService  vehicleService;

    private static Vehicle vehicle=
            VehicleFactory.createVehicle("008","CAA89","John Doe","Audi","white","GTI");


    VehicleServiceImplTest(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Test
    void a_create() {
        Vehicle created = vehicleService.create(vehicle);
        assertEquals(vehicle.getRegistrationNumber(),created.getRegistrationNumber());
        System.out.println("Created"+ created);
    }

    @Test
    void b_read() {
        Vehicle read = vehicleService.read(vehicle.getRegistrationNumber());
        assertNotNull(read);
        System.out.println("Read"+ read);

    }

    @Test
    void update() {

        Vehicle newVehicle = new  Vehicle.Builder().copy(vehicle).setRegistrationNumber("Updated RegistrationNumber").setLicensePlateNumber("Updated LicensePlateNumber").setOwnershipStatus("OwnershipStatus").setMake("Updated Mark").setModel("Updated Model").setColor("Updated Color").build();
        Vehicle updated = vehicleService.update(newVehicle);
        assertNotNull(updated);
        System.out.println("Updated"+ updated);
    }
    @Disabled
    @Test
    void e_delete(){}

    @Test
    void getAll() {
        System.out.println("Get all");
        System.out.println(vehicleService.getAll());
    }
}