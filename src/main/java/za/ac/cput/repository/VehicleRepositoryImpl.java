package za.ac.cput.repository;

import za.ac.cput.domain.Vehicle;

import java.util.HashSet;
import java.util.Set;

public class VehicleRepositoryImpl implements VehicleRepository{

    private static VehicleRepository repository = null;

    private Set<Vehicle> vehicleDB = null;

    private VehicleRepositoryImpl(){
        vehicleDB = new HashSet<Vehicle>();

    }
    public static VehicleRepository getRepository(){
        if (repository == null){
            repository = (VehicleRepository) new VehicleRepositoryImpl();
        }

        return repository;
    }


    public Vehicle create(Vehicle vehicle){
        boolean success = vehicleDB.add(vehicle);
        if (!success)
            return null;
        return vehicle;
    }

    public Vehicle read(String licensePlateNumber) {
        for (Vehicle v : vehicleDB) {
            if (v.getLicensePlateNumber().equals(licensePlateNumber)) {
                return v;
            }
        }
        return null;
    }


    public Vehicle update(Vehicle vehicle){
        Vehicle original = read(vehicle.getLicensePlateNumber());
        if(original== null)
            return null;
        boolean successDelete = vehicleDB.remove(original);
        if(!successDelete)
            return null;
        boolean correctAdd = vehicleDB.add(vehicle);
        if(!correctAdd)
            return null;
        return vehicle;
    }

    public boolean  delete(String licensePlateNumber){
        Vehicle vehicleToDelete = read(licensePlateNumber);
        if(vehicleToDelete == null)
            return false;
        boolean success = vehicleDB.remove(vehicleToDelete);
        return success;
    }

    public Set<Vehicle> getAll(){
        return vehicleDB;
    }

}
