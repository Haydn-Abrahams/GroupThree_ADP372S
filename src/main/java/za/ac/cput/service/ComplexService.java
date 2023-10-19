package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.BaseAddress;
import za.ac.cput.domain.Complex;
import za.ac.cput.repository.ComplexRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class ComplexService {
    private ComplexRepository complexRepository;
    private BaseAddressService baseAddressService;
    @Autowired
    private ComplexService(ComplexRepository complexRepository, BaseAddressService baseAddressService){
        this.complexRepository = complexRepository;
        this.baseAddressService = baseAddressService;}

    public Complex save(Complex complex){
        BaseAddress savedBaseAddress1 = baseAddressService.save(complex.getBaseAddress());
        complex.setBaseAddress(savedBaseAddress1);
        return complexRepository.save(complex);}
    public Complex getById(Long id){return complexRepository.findById(id).orElse(null);}
    public Set<Complex> getAll(){return new HashSet<>(complexRepository.findAll());}
    public Complex update(Complex updateComplex){return complexRepository.save(updateComplex);}
    public boolean deleteById(Long id){
        complexRepository.deleteById(id);
        baseAddressService.deleteById(id);
        return true;
    }

}
