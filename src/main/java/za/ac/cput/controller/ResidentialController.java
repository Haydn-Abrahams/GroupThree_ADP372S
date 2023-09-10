package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Residential;
import za.ac.cput.service.ResidentialService;

import java.util.Set;

@RestController
@RequestMapping("/residential")
public class ResidentialController {
    @Autowired
    private ResidentialService residentialService;

    @PostMapping("/create")
    public Residential create(@RequestBody Residential residential){
        return residentialService.save(residential);
    }
    @GetMapping("/read/{id}")
    public Residential read(@PathVariable Long id){return residentialService.getById(id);}
    @PostMapping("/update")
    public Residential update(@RequestBody Residential residential){return residentialService.update(residential);}
    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable Long id){return residentialService.deleteById(id);}
    @RequestMapping({"/getAll"})
    public Set<Residential> getAll(){
        return residentialService.getAll();
    }
}
