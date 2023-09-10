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
import za.ac.cput.domain.Complex;
import za.ac.cput.factory.ComplexFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComplexControllerTest {
    private static Complex createComplex1 = ComplexFactory.createComplex("Libertas", "35A", "3", "Cape Town", "Western Cape", "Parow","7500", "South Africa");
    private static Complex createComplex2 = ComplexFactory.createComplex("Picton", "12B", "1", "Cape Town", "Western Cape", "Delft","7100", "South Africa");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/complex";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Complex> postResponse = restTemplate.postForEntity(url, createComplex1, Complex.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        createComplex1 = postResponse.getBody();
        System.out.println("Created " + postResponse);
        assertEquals(createComplex1.getId(), postResponse.getBody().getId());
    }

    @Test
    void read() {
        String url = baseURL + "/read/" + createComplex1.getId();
        System.out.println("Read " + url);
        ResponseEntity<Complex> response = restTemplate.getForEntity(url, Complex.class);
        assertEquals(createComplex1.getId(), response.getBody().getId());
        System.out.println(response.getBody());
    }

    @Test
    void update() {
        Complex updatedComplex = createComplex1.toBuilder().name("Sherif House").build();
        String url = baseURL + "/update";
        System.out.println("URL " + url);
        ResponseEntity<Complex> response = restTemplate.postForEntity(url, updatedComplex, Complex.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void delete() {
        String url = baseURL + "/delete" + createComplex1.getId();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Showing All");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}