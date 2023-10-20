package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactControllerTest {

    public static Contact contact = ContactFactory.createContact("0795871484","0698785478","abrahamsallie@gmail.com");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/contact";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL:" +url);
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url,contact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Contact savedContact = postResponse.getBody();
        assertEquals(savedContact.getEmail(),
        savedContact.getEmail());
        System.out.println("saved data"+ savedContact);
    }

    @Test
    void b_read() {

        String url = baseURL + "/read"+
        contact.getEmail();
        System.out.println("URL:" +url);
        ResponseEntity<Contact> response = restTemplate.getForEntity(url,Contact.class);
        assertEquals(contact.getEmail(),
        response.getBody().getEmail());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {

        Contact updated = new Contact.Builder().copy(contact).setEmail("Updated email")
                .setContactNumber("Update contact number")
                .setAlternativeNumber("Updated alternative number")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL"+ url);
        System.out.println("Post data "+ updated);

        ResponseEntity<Contact> response = restTemplate.postForEntity(url, updated, Contact.class);

    }


    @Test
    void d_getAll() {

        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String>response =
                restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
        System.out.println("show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());



    }
}