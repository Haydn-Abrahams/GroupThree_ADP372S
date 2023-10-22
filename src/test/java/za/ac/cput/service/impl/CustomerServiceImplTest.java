package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.CustomerService;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    public static Customer customer = CustomerFactory.createCustomer("John", "Doe","doejohn282@gmail.com", "password123");
    @Test
    void a_create() {
        Customer created = customerService.create(customer);
        assertEquals(customer.getCustomerId(), created.getCustomerId());
        System.out.println(created);
    }

    @Test
    void b_read() {
        Customer read = customerService.read(customer.getCustomerId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Customer newCustomer= new Customer.Builder()
                .copy(customer)
                .setFirstName("UpdatedFirstName")
                .setLastName("UpdatedLastName")
                .setPassword("updatedPassword")
                .build();
        Customer updated = customerService.update(newCustomer);

        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }
    @Disabled
    @Test
    void e_delete() {
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(customerService.getAll());
    }
}