package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    public static Employee employee = EmployeeFactory.createEmployee(1, "John", "Doe", "password123");

    @Test
    void a_create() {
        Employee created = employeeService.create(employee);
        assertEquals(employee.getEmployeeCode(), created.getEmployeeCode());
        System.out.println(created);
    }

    @Test
    void b_read() {
        Employee read = employeeService.read(employee.getEmployeeCode());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Employee newEmployee = new Employee.Builder()
                .copy(employee)
                .setFirstName("UpdatedFirstName")
                .setLastName("UpdatedLastName")
                .setPassword("updatedPassword")
                .build();
        Employee updated = employeeService.update(newEmployee);

        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void e_delete() {
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(employeeService.getAll());
    }
}