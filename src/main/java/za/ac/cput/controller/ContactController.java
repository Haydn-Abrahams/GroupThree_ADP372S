package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.service.ContactService;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;


    @PostMapping("create")
    public Contact create(@RequestBody Contact contact) {
        Contact newContact = ContactFactory.createContact("0789558745", "0625478958", "willams@mycput.ac.za");
        return contactService.create(newContact);

    }

    @GetMapping("/read{id}")
    public Contact read(@PathVariable String id) {
        return contactService.read(id);
    }

    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact) {
        return contactService.update(contact);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return contactService.delete(id);
    }

    @GetMapping("/getall")
    public List<Contact> getall(){
        return contactService.getAll();
    }
}
