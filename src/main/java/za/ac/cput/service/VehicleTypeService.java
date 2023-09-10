package za.ac.cput.service;

import za.ac.cput.domain.VehicleType;

import java.util.List;

public interface VehicleTypeService /*extends IService<VehicleType, String>*/ {
    VehicleType create(VehicleType vehicleType);
    VehicleType read(String id);
    VehicleType update(VehicleType vehicleType);
    boolean delete(String id);

    List<VehicleType> getAll();
}
