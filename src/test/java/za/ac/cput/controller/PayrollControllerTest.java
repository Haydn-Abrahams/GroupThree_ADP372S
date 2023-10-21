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
import za.ac.cput.domain.Payroll;
import za.ac.cput.factory.PayrollFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PayrollControllerTest {

    private static Payroll payroll = PayrollFactory.buildPayroll("Detailer", 21, 2,90,15390);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8080/payroll";
    @Test
    void create() {
        String url = baseUrl + "/create";
        ResponseEntity<Payroll> postResponse = restTemplate.postForEntity(url, payroll, Payroll.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Payroll savedPayroll = postResponse.getBody();
        System.out.println("Saved Data: " + savedPayroll);
        assertNotNull(payroll.getPaymentID(), savedPayroll.getPaymentID());
    }

    @Test
    void read() {
        String url = baseUrl + "/read" + payroll.getPaymentID();
        System.out.println("URL " + url);
        ResponseEntity<Payroll> response = restTemplate.getForEntity(url, Payroll.class);
        assertNotNull(baseUrl, response.getBody().getPaymentID());
        System.out.println(response.getBody());
    }

    @Test
    void update() {
        Payroll updated = new Payroll.Builder().copy(payroll).setOvertime(3).build();
        String url = baseUrl + "/update";
        System.out.println("URL " + url);
        System.out.println("Post Data: " + updated);
        ResponseEntity<Payroll> response = restTemplate.postForEntity(url, updated, Payroll.class);
        assertNotNull(response.getBody());
    }


    @Test
    void e_delete() {
        String url = baseUrl + "/delete" + payroll.getPaymentID();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseUrl + "/getAll";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}