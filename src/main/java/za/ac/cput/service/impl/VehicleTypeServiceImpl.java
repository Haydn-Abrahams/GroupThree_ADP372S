package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.VehicleType;
import za.ac.cput.repository.IVehicleTypeRepository;
import za.ac.cput.service.VehicleTypeService;

import java.util.List;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {
    private IVehicleTypeRepository repository;

    @Autowired
    public VehicleTypeServiceImpl(IVehicleTypeRepository repository){this.repository = repository;}
    @Override
    public VehicleType create(VehicleType vehicleType) {
        return this.repository.save(vehicleType);
    }

    @Override
    public VehicleType read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public VehicleType update(VehicleType vehicleType) {
        return this.repository.save(vehicleType);
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }

    @Override
    public List<VehicleType> getAll() {
        return this.repository.findAll();
    }
}
