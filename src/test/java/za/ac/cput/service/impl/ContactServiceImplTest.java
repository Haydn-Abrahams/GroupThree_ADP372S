package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ContactServiceImplTest {
@Autowired
    private ContactServiceImpl service;

    private static Contact contact = ContactFactory.createContact("07958478542","0874954624","hendricks@gmail.com")
    @Test
    void create() {
        Contact created = service.create(contact);
        assertEquals(contact.getEmail(),created.getEmail());
        System.out.println("Created"+ created);
    }

    @Test
    void read() {
        Contact read = service.read(contact.getEmail());
        assertNotNull(read);
        System.out.println("Read"+ read);

    }

    @Test
    void update() {

        Contact updated = new Contact.Builder().copy(contact).setalternativeNumber("0875984587").build();
        assertNotNull(updated);
        System.out.println("Updated"+ updated);
    }



    @Test
    void getAll() {
        System.out.println("Get all");
        System.out.println(service.getAll());
    }
}