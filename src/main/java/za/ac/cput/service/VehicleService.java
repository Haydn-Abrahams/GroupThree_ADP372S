package za.ac.cput.service;

import za.ac.cput.domain.Vehicle;

import java.util.List;

public interface VehicleService extends IService<Vehicle, String>{


    List<Vehicle> getAll();


}
