package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    void createCustomer() {
        Customer customer = CustomerFactory.createCustomer("John", "Doe","johndoesecret");
        System.out.println(customer.toString());
        assertNotNull(customer);
    }
}