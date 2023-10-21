package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    public
    VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("create")
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleService.create(vehicle);

    }

    @GetMapping("/read{id}")
    public Vehicle read(@PathVariable String id) {
        return vehicleService.read(id);
    }

    @PostMapping("/update")
    public Vehicle update(@RequestBody Vehicle contact) {
        return vehicleService.update(contact);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return vehicleService.delete(id);
    }

    @GetMapping("/getall")
    public List<Vehicle> getall(){
        return vehicleService.getAll();
    }
}