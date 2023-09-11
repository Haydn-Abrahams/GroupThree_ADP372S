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
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactControllerTest {

    private static Contact contact = ContactFactory.createContact("0875924558","0879635145","hendricks001@gmail.com");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURl = "http//local:8080/contact";

    @Test
    void a_create(){
        String url = baseURl + "/create";
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url, contact,Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Contact savedContact = postResponse.getBody();
        System.out.println("saved" + savedContact);
        assertEquals(contact.getEmail(), savedContact.getEmail());

    }
    @Test
    void b_read(){
        String url = baseURl +"/read"+ contact.getEmail();
        System.out.println("URL"+ url);
        ResponseEntity<Contact> response = restTemplate.getForEntity(url,Contact.class);
        assertEquals(contact.getEmail(), response.getBody().getEmail());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Contact updated = new Contact.Builder().copy(contact).setcontactNumber("0789547895").build();
        String url = baseURl + "/update";
        System.out.println("URL" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Contact> response = restTemplate.postForEntity(url, updated,Contact.class);
        assertNotNull(response.getBody());

    }

    @Test
    void d_delete(){
        String url = baseURl +"/delete"+ contact.getEmail();
        System.out.println("URL"+ url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll(){

        String url = baseURl + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>( null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}