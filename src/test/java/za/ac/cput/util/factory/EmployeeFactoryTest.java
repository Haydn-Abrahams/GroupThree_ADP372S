package za.ac.cput.util.factory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.util.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeFactoryTest {

    @Test
    void createEmployee() {
        Employee employee = EmployeeFactory.createEmployee(508941659, "John","Doe");
        System.out.println(employee.toString());
        assertNotNull(employee);
    }
}