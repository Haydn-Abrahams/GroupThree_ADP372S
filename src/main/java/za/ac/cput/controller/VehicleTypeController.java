package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.VehicleType;
import za.ac.cput.service.VehicleTypeService;

import java.util.List;

@RestController
@RequestMapping("/vehicleType")
public class VehicleTypeController {

    private VehicleTypeService vehicleTypeService;

    @Autowired
    public VehicleTypeController(VehicleTypeService vehicleTypeService){this.vehicleTypeService = vehicleTypeService;}

    @PostMapping("/create")
    public VehicleType create(@RequestBody VehicleType vehicleType){return  vehicleTypeService.create(vehicleType);}

    @GetMapping("/read/{id}")
    public VehicleType read(@PathVariable String id){return  vehicleTypeService.read(id);}

    @PostMapping("/update")
    public VehicleType update(@RequestBody VehicleType vehicleType){return  vehicleTypeService.update(vehicleType);}

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){return vehicleTypeService.delete(id);}

    @GetMapping("/getAll")
    public List<VehicleType> getAll(){return vehicleTypeService.getAll();}
}
