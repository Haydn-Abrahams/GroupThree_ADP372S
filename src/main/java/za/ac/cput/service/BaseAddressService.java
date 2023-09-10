package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.BaseAddress;
import za.ac.cput.repository.BaseAddressRepository;
@Service
public class BaseAddressService {
    private BaseAddressRepository baseAddressRepository;
    @Autowired
    private BaseAddressService(BaseAddressRepository baseAddressRepository){this.baseAddressRepository = baseAddressRepository;}

    public BaseAddress save(BaseAddress baseAddress){return baseAddressRepository.save(baseAddress);}
    public boolean deleteById(Long id){
        baseAddressRepository.deleteById(id);
        return true;
    }
    //BaseAddress findByCity(String city);
    //BaseAddress findByPostalCode(String postalCode);

}
