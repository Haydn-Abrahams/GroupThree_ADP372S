package za.ac.cput.controller;

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
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    public static Customer customer = CustomerFactory.createCustomer( "John", "Doe", "doejohn282@gmail.com","password123");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/customers";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Customer savedCustomer = postResponse.getBody();
        assertEquals(savedCustomer.getCustomerId(), savedCustomer.getCustomerId());
        System.out.println("Saved data: " + savedCustomer);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + customer.getCustomerId();
        System.out.println("URL: " + url);
        // Get
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        assertEquals(customer.getCustomerId(), response.getBody().getCustomerId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Customer updated = new Customer.Builder()
                .copy(customer)
                .setFirstName("UpdatedFirstName")
                .setLastName("UpdatedLastName")
                .setPassword("updatedPassword")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        // Post
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, updated, Customer.class);
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