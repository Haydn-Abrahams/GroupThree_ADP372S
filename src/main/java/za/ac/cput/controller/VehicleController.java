package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;
import za.ac.cput.service.VehicleService;

import java.util.List;
import java.util.Set;
@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
//po

    @PostMapping("create")
    public Vehicle create(@RequestBody Vehicle vehicle) {
        Vehicle newContact = VehicleFactory.createVehicle("CAA957", "John Hendricks", "toyota", "white","Audi");
        return vehicleService.create(newContact);

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
