package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payroll;
import za.ac.cput.service.PayrollService;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {


    private PayrollService service;
    @Autowired
    public PayrollController(PayrollService service) {this.service = service;}

    @PostMapping("/create{paymentID}")
    public Payroll create(@PathVariable String paymentID, @RequestBody Payroll payroll) {
        return service.create(payroll);
    }
    @GetMapping("/read{paymentID}")
    public Payroll read(@PathVariable String paymentID) {
        return service.read(String.valueOf(paymentID));
    }
    @PostMapping("/update{paymentID}")
    public Payroll update(@PathVariable String paymentID, @RequestBody Payroll payroll) {
        return service.update(payroll);
    }
    @DeleteMapping("/delete{paymentID}")
    public boolean delete(@PathVariable String paymentID) {
        return service.delete(paymentID);
    }
    @GetMapping("/getAll")
    public List<Payroll> getAll() {
        return service.getAll();
    }
}
