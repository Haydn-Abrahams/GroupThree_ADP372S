package za.ac.cput.service;

import za.ac.cput.domain.Vehicle;
import za.ac.cput.service.IService;

import java.util.List;

public interface IVehicleService extends IService<Vehicle, String> {

    Vehicle create(Vehicle vehicle);

    Vehicle read (String registrationNumber );
    Vehicle update(Vehicle vehicle);

    boolean delete(String registrationNumber);

    List<Vehicle> getAll();


}
