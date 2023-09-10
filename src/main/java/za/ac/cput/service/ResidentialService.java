package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.BaseAddress;
import za.ac.cput.domain.Residential;
import za.ac.cput.repository.BaseAddressRepository;
import za.ac.cput.repository.ResidentialRepository;

import java.util.HashSet;
import java.util.Set;
@Service
public class ResidentialService {
    private ResidentialRepository residentialRepository;
    private BaseAddressService baseAddressService;
    @Autowired
    private ResidentialService(ResidentialRepository residentialRepository, BaseAddressService baseAddressService){
        this.residentialRepository = residentialRepository;
        this.baseAddressService = baseAddressService;}

    public Residential save(Residential residential){
        BaseAddress savedBaseAddress = baseAddressService.save(residential.getBaseAddress());
        residential.setBaseAddress(savedBaseAddress);
        return residentialRepository.save(residential);}
    public Residential getById(Long id){return residentialRepository.findById(id).orElse(null);}
    public Set<Residential> getAll(){return new HashSet<>(residentialRepository.findAll());}
    public Residential update(Residential updateResidential){return residentialRepository.save(updateResidential);}
    public boolean deleteById(Long id){
        residentialRepository.deleteById(id);
        baseAddressService.deleteById(id);
        return true;
    }
}