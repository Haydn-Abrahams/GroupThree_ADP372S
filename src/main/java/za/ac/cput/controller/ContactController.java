package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contact")

public class ContactController {

    @Autowired
    private ContactService contactService;

    public
    ContactController(ContactService contactService){
        this.contactService = contactService;
    }


    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact) {

        return contactService.create(contact);

    }

    @GetMapping("/read{email}")
    public Contact read(@PathVariable String email) {
        return contactService.read(email);
    }

    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact) {
        return contactService.update(contact);
    }

    @DeleteMapping("delete/{email}")
    public boolean delete(@PathVariable String email) {
        return contactService.delete(email);
    }

    @GetMapping("/getall")
    public List<Contact> getall(){
        return contactService.getAll();
    }
}
