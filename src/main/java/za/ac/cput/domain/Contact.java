package za.ac.cput.domain;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;




    public class Contact implements Serializable {
        // Attributes


        private String email;

        private String contactNumber;
        private String alternativeNumber;



        //class Contructor
        protected Contact(){}

        private Contact(Builder builder) {

            this.email = builder.email;
            this.contactNumber = builder.contactNumber;
            this.alternativeNumber = builder.alternativeNumber;
        }

        // Getters

        public String getEmail() {
            return email;
        }

        public String getcontactNumber() {
            return contactNumber;
        }

        public String getalternativeNumber() {
            return alternativeNumber;
        }

        //equals and hash

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


        // toString

        @Override
        public String toString() {
            return "Contact{" +
                    "email='" + email + '\'' +
                    ", contactNumber='" + contactNumber + '\'' +
                    ", alternativeNumber='" + alternativeNumber + '\'' +
                    '}';
        }


//builder attributes

        public static class Builder{

            private String email;

            private String contactNumber;

            private String alternativeNumber;

            // setting my builder attibutes

            public Builder setEmail(String email){
                this.email = email;
                return this;
            }

            public Builder setcontactNumber(String contactNumber){
                this.contactNumber = contactNumber;
                return this;
            }

            public Builder setalternativeNumber(String alternativeNumber){
                this.alternativeNumber = alternativeNumber;
                return this;
            }

            public Builder copy (final Contact contact){

                this.email = contact.email;
                this.contactNumber = contact.contactNumber;
                this.alternativeNumber = contact.alternativeNumber;
                return this;
            }
            public Contact build(){
                return new Contact(this);
            }
        }
}
