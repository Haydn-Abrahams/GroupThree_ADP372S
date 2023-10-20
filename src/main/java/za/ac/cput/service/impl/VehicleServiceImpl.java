package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Vehicle;

import za.ac.cput.repository.VehicleRepository;
import za.ac.cput.service.VehicleService;

import java.util.List;
@Service

public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;

    @Autowired

    private VehicleServiceImpl(VehicleRepository repository)
    {
        this.repository = repository;
    }



    public Vehicle create(Vehicle vehicle) {
        return this.repository.save(vehicle);
    }


    public Vehicle read(String registrationNumber) {
        return this.repository.findById(registrationNumber).orElse(null);
    }


    public Vehicle update(Vehicle vehicle) {
        if(repository.existsById(vehicle.getRegistrationNumber()))
            this.repository.save(vehicle);
        return null;
    }


    public boolean delete(String registrationNumber) {
        if (this.repository.existsById(registrationNumber)) {
            this.repository.deleteById(registrationNumber);
            return true;
        }
        return false;
    }

    public List<Vehicle> getAll() {
        return this.repository.findAll();
    }
}

