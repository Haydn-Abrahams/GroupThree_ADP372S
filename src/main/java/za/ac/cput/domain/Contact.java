package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity

public class Contact implements Serializable {


    //my attributes
    @Id
    private String email;

    private String contactNumber;
    private String alternativeNumber;

    //both constructors
    public Contact() {

    }

    public Contact(String email, String contactNumber, String alternativeNumber) {
        this.email = email;
        this.contactNumber = contactNumber;
        this.alternativeNumber = alternativeNumber;
    }

    //private Builder Constructors
    private Contact(Builder builder) {
        this.email = builder.email;
        this.contactNumber = builder.contactNumber;
        this.alternativeNumber = builder.alternativeNumber;

    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAlternativeNumber() {
        return alternativeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email) && Objects.equals(contactNumber, contact.contactNumber) && Objects.equals(alternativeNumber, contact.alternativeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, contactNumber, alternativeNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", alternativeNumber='" + alternativeNumber + '\'' +
                '}';
    }

    //Builder Constructors
    public static class Builder {
        private String email;

        private String contactNumber;
        private String alternativeNumber;

        //Builder Setters
        public Contact.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Contact.Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }
        public Contact.Builder setAlternativeNumber(String alternativeNumber) {
            this.alternativeNumber = alternativeNumber;
            return this;
        }

        public Contact.Builder copy(Contact contact){
            this.email= contact.email;
            this.contactNumber = contact.contactNumber;
            this.alternativeNumber= contact.alternativeNumber;
            return this;
        }

        public Contact build(){return  new Contact(this);}
    }
}








