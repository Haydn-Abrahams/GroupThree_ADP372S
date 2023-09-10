package za.ac.cput.service;

import za.ac.cput.domain.Customer;

import java.util.List;

public interface CustomerService{
    Customer create(Customer customer);

    Customer read(String customerId);

    Customer update(Customer customer);

    boolean delete(String customerId);

    List<Customer> getAll();
}
