package za.ac.cput.service;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Vehicle;

import java.util.List;

public interface VehicleService extends IService<Vehicle, String>{

    Vehicle create(Vehicle Vehicle);

    Vehicle read (String registrationNumber );
    Vehicle update(Vehicle vehicle);

    boolean delete(String registrationNumber);

    List<Vehicle> getAll();


}
