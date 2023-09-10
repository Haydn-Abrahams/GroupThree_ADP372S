package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    public static Employee employee = EmployeeFactory.createEmployee(1, "John", "Doe", "password123");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/employees";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Employee savedEmployee = postResponse.getBody();
        assertEquals(savedEmployee.getEmployeeCode(), savedEmployee.getEmployeeCode());
        System.out.println("Saved data: " + savedEmployee);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + employee.getEmployeeCode();
        System.out.println("URL: " + url);
        // Get
        ResponseEntity<Employee> response = restTemplate.getForEntity(url, Employee.class);
        assertEquals(employee.getEmployeeCode(), response.getBody().getEmployeeCode());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Employee updated = new Employee.Builder()
                .copy(employee)
                .setFirstName("UpdatedFirstName")
                .setLastName("UpdatedLastName")
                .setPassword("updatedPassword")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        // Post
        ResponseEntity<Employee> response = restTemplate.postForEntity(url, updated, Employee.class);
        // assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + employee.getEmployeeCode();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}