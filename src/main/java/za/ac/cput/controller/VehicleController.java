package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;
import za.ac.cput.service.VehicleService;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService VehicleService;


    @PostMapping("create")
    public Vehicle create(@RequestBody Vehicle vehicle) {
        Vehicle newContact = VehicleFactory.createVehicle("008", "CAA95", "John Hendricks", "audi","red","polo");
        return VehicleService.create(newContact);

    }

    @GetMapping("/read{id}")
    public Vehicle read(@PathVariable String id) {
        return VehicleService.read(id);
    }

    @PostMapping("/update")
    public Vehicle update(@RequestBody Vehicle contact) {
        return VehicleService.update(contact);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return VehicleService.delete(id);
    }

    @GetMapping("/getall")
    public List<Vehicle> getall(){
        return VehicleService.getAll();
    }
}
