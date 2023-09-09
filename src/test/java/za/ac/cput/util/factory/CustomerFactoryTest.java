package za.ac.cput.util.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    void createCustomer() {
        Customer customer = CustomerFactory.createCustomer("John", "Doe","johndoesecret");
        System.out.println(customer.toString());
        assertNotNull(customer);
    }
}