package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.repository.ContactRepository;
import za.ac.cput.service.ContactService;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

// used jap to avoid seqeunce sequele statements

    private static ContactRepository repository;

    @Autowired
    private ContactServiceImpl(ContactRepository repository)
    {this.repository = repository = repository;
    }


    @Override
    public Contact create(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact read(String email) {
        return this.repository.findById(email).orElse(null);
    }

    @Override
    public Contact update(Contact contact) {
        if(repository.existsById(contact.getEmail()))
            this.repository.save(contact);
        return null;
    }

    @Override
    public boolean delete(String email) {
        if (this.repository.existsById(email)) {
            this.repository.deleteById(email);
            return true;
        }
        return false;
    }
    @Override
    public List<Contact> getAll() {
        return this.repository.findAll();
    }
}
