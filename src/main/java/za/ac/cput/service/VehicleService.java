package za.ac.cput.service;

import za.ac.cput.domain.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle create(Vehicle vehicle);

    Vehicle read (String registrationNumber );
    Vehicle update(Vehicle vehicle);

    boolean delete(String registrationNumber);

    List<Vehicle> getAll();


}
