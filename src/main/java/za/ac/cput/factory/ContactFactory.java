package za.ac.cput.factory;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory{



    public static Contact createContact(String contactNumber, String alternativeNumber, String email) {

        if (!Helper.isValidEmail(email)) {
            return null;
        }

        if (Helper.isNullOrEmpty(contactNumber) || Helper.isNullOrEmpty(alternativeNumber)) {
            return null;
        }

        return new Contact.Builder().setContactNumber(contactNumber)
                .setAlternativeNumber(alternativeNumber)
                .setEmail(email)
                .build();


    }
}
