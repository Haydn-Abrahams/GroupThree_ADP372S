package za.ac.cput.util.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeFactoryTest {

    @Test
    void createEmployee() {
        Employee employee = EmployeeFactory.createEmployee(508941659, "John","Doe");
        System.out.println(employee.toString());
        assertNotNull(employee);
    }
}