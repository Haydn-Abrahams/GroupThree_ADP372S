package za.ac.cput.repository;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Contact;

import java.util.HashSet;
import java.util.Set;
@Autowired

public class ContactRepositoryImpl implements ContactRepository{

    private static ContactRepository repository = null;

    private Set<Contact> contactDB = null;

    private ContactRepositoryImpl(){
        contactDB = new HashSet<Contact>();

    }
    public static ContactRepository getRepository(){
        if (repository == null){
            repository = new ContactRepositoryImpl();
        }

        return repository;
    }

    public Contact create(Contact contact){
        boolean success = contactDB.add(contact);
        if (!success)
            return null;
        return contact;
    }

    public Contact read(String email) {
        for (Contact c : contactDB) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }


    public Contact update(Contact contact){
        Contact original = read(contact.getEmail());
        if(original== null)
            return null;
        boolean successDelete = contactDB.remove(original);
        if(!successDelete)
            return null;
        boolean correctAdd = contactDB.add(contact);
        if(!correctAdd)
            return null;
        return contact;
    }

    public boolean  delete(String email){
        Contact contactToDelete = read(email);
        if(contactToDelete == null)
            return false;
        boolean success = contactDB.remove(contactToDelete);
        return success;
    }

    public Set<Contact> getAll(){
        return contactDB;
    }


}
