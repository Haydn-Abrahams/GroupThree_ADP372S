package za.ac.cput.service;


import za.ac.cput.domain.Contact;

import java.util.List;



public interface ContactService extends IService<Contact, String>{

    Contact create(Contact contact);

    Contact read (String email );
    Contact update(Contact contact);

    boolean delete(String email);


    List<Contact> getAll();

}
