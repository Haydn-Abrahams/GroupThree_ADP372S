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
import za.ac.cput.domain.Residential;
import za.ac.cput.factory.ResidentialFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ResidentialControllerTest {
    private static Residential residential1 = ResidentialFactory.createResidential("87 King Edward Road", "Cape Town", "Western Cape", "Parow", "7500", "South Africa");
    private static Residential residential2 = ResidentialFactory.createResidential("18 Kloser Street", "Cape Town", "Western Cape", "Delft", "7500", "South Africa");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/residential";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Residential> postResponse = restTemplate.postForEntity(url, residential2, Residential.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Residential residential1 = postResponse.getBody();
        assertEquals(residential1.getId(), postResponse.getBody().getId());

        System.out.println("Saved:" + residential1);
    }

    @Test
    void read() {
        String url = baseURL + "/read/" + residential2.getId();
        System.out.println("Read " + url);
        ResponseEntity<Residential> response = restTemplate.getForEntity(url, Residential.class);
        assertEquals(residential2.getId(), response.getBody().getId());
    }

    @Test
    void update() {
        Residential updatedResidential = residential2.toBuilder().street_Address("12 Mango Street").build();
        String url = baseURL + "/update";
        System.out.println("URL " + url);
        ResponseEntity<Residential> response = restTemplate.postForEntity(url, updatedResidential, Residential.class);
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {
        String url = baseURL + "/delete" + residential2.getId();
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