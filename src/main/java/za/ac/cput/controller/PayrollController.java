package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payroll;
import za.ac.cput.service.PayrollService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class PayrollController {


    private PayrollService service;
    @Autowired
    public PayrollController(PayrollService service) {this.service = service;}

    @PostMapping("/create")
    public Payroll create(@RequestBody Payroll payroll) {
        return service.create(payroll);
    }
    @GetMapping("/read{id}")
    public Payroll read(@PathVariable String employeeCode) {
        return service.read(String.valueOf(employeeCode));
    }
    @PostMapping("/update")
    public Payroll update(@RequestBody Payroll payroll) {
        return service.update(payroll);
    }
    @DeleteMapping("/delete{employeeCode}")
    public boolean delete(@PathVariable String employeeCode) {
        return service.delete(employeeCode);
    }
    @GetMapping("/getAll")
    public List<Payroll> getAll() {
        return service.getAll();
    }
}
