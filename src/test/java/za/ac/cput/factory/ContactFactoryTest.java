package za.ac.cput.factory;

import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    public void test(){
        Contact contact = ContactFactory.createContact("0789652415","0816547892","williams@cput.ac.za");
        System.out.println(contact.toString());
        assertNotNull(contact);
    }

}