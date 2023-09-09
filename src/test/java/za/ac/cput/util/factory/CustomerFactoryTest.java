package za.ac.cput.util.factory;

import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.util.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    public void test(){
        Customer customer = CustomerFactory.createCustomer("John", "Doe","johndoesecret");
        System.out.println(customer.toString());
        assertNotNull(customer);
    }

//   @Test
//    public void test_fail(){
//       Customer customer = CustomerFactory.createCustomer( " ", "Doe","johndoesecret");
//       System.out.println(customer.toString());
//       assertNotNull(customer);
//   }
}