package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Complex;
import za.ac.cput.service.ComplexService;

import java.util.Set;

@RestController
@RequestMapping("/complex")
public class ComplexController {
    @Autowired
    private ComplexService complexService;

    @PostMapping("/create")
    public Complex create(@RequestBody Complex complex){
        return complexService.save(complex);
    }
    @GetMapping("/read/{id}")
    public Complex read(@PathVariable Long id){return complexService.getById(id);}
    @PostMapping("/update")
    public Complex update(@RequestBody Complex complex){return complexService.update(complex);}
    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable Long id){return complexService.deleteById(id);}
    @RequestMapping({"/getAll"})
    public Set<Complex> getAll(){
        return complexService.getAll();
    }
}
