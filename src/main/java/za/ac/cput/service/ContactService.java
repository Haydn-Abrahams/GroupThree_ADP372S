package za.ac.cput.service;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Vehicle;

import java.util.List;

public interface ContactService extends IService<Contact, String>{

    List<Contact> getAll();

}
