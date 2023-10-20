package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {
    private ContactService contactService;

    private static Contact contact=
           ContactFactory.createContact("0785485954","0816957842","joyray08@gmail.com");


    ContactServiceImplTest(ContactService contactService) {
        this.contactService = contactService;
    }

    @Test
    void a_create() {
        Contact created = contactService.create(contact);
        assertEquals(contact.getEmail(),created.getEmail());
        System.out.println("Created"+ created);
    }

    @Test
    void b_read() {
        Contact read = contactService.read(contact.getEmail());
        assertNotNull(read);
        System.out.println("Read"+ read);

    }

    @Test
    void update() {

        Contact newContact = new  Contact.Builder().copy(contact).setContactNumber("ContactNumber").setAlternativeNumber("Updated AlternativeNumber").setEmail("Updated Email").build();
        Contact updated = contactService.update(newContact);
        assertNotNull(updated);
        System.out.println("Updated"+ updated);
    }
    @Disabled
    @Test
    void e_delete(){}

    @Test
    void getAll() {
        System.out.println("Get all");
        System.out.println(contactService.getAll());
    }
}