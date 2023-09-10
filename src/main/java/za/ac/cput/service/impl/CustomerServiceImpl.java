package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepository;
import za.ac.cput.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final ICustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(ICustomerRepository repository){this.repository = repository;}


    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer read(String customerId) {
        return repository.findById(customerId).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if(repository.existsById(customer.getCustomerId())){
            return repository.save(customer);
        }
        return null;
    }

    @Override
    public boolean delete(String customerId) {
        if(repository.existsById(customerId)){
            repository.deleteById(customerId);
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }
}
