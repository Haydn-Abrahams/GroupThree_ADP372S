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
import za.ac.cput.domain.VehicleType;
import za.ac.cput.factory.VehicleTypeFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleTypeControllerTest {
    public static VehicleType vehicleType = VehicleTypeFactory.buildVehicleType("Yamaha", "Nissan Almera", "Quantam", "Iveco");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/vehicleType";

    @Test
    void a_create(){
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        ResponseEntity<VehicleType> postResponse = restTemplate.postForEntity(url, vehicleType, VehicleType.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        VehicleType savedVehicleType = postResponse.getBody();
        assertEquals(savedVehicleType.getMotorcycle(), savedVehicleType.getMotorcycle());
        System.out.println("Saved data: " + savedVehicleType);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + vehicleType.getMotorcycle();
        System.out.println("URL: " + url);
        // Get
        ResponseEntity<VehicleType> response = restTemplate.getForEntity(url, VehicleType.class);
        assertEquals(vehicleType.getMotorcycle(), response.getBody().getMotorcycle());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        VehicleType updated = new VehicleType.Builder()
                .copy(vehicleType)
                .setMotorcycle("Ducati")
                .setLightWeightCar("Hyundai Elantra")
                .setMiniBus("Bantam")
                .setTruck("Mercedes")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        // Post
        ResponseEntity<VehicleType> response = restTemplate.postForEntity(url, updated, VehicleType.class);
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
