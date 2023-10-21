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
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VehicleControllerTest {

    private static Vehicle vehicle = VehicleFactory.createVehicle("002154","CAA 10938","BMW","Red","Audi A1");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURl = "http//local:8080/vehicle";

    @Test
    void a_create(){
        String url = baseURl + "/create";
        ResponseEntity<Vehicle> postResponse = restTemplate.postForEntity(url, vehicle,Vehicle.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Vehicle savedVehicle = postResponse.getBody();
        System.out.println("saved" + savedVehicle);
        assertEquals(vehicle.getRegistrationNumber(), savedVehicle.getRegistrationNumber());
    }
    @Test
    void b_read(){
        String url = baseURl +"/read"+ vehicle.getRegistrationNumber();
        System.out.println("URL"+ url);
        ResponseEntity<Vehicle> response = restTemplate.getForEntity(url,Vehicle.class);
        assertEquals(vehicle.getRegistrationNumber(), response.getBody().getRegistrationNumber());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Vehicle updated = new Vehicle.Builder().copy(vehicle).setLicensePlateNumber("AA954").build();
        String url = baseURl + "/update";
        System.out.println("URL" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Vehicle> response = restTemplate.postForEntity(url, updated,Vehicle.class);
        assertNotNull(response.getBody());

    }

    @Test
    void d_delete(){
        String url = baseURl +"/delete"+ vehicle.getRegistrationNumber();
        System.out.println("URL"+ url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll(){

        String url = baseURl + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>( null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

}