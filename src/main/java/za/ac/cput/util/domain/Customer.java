package za.ac.cput.util.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Customer implements Serializable {
    @Id
    private String customerId;
    private String firstname;

    private String lastname;

    private String password;

    //Constructors
    public Customer() {
    }
    public Customer(String customerId, String firstname, String lastname, String password) {
        this.customerId = customerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    //private Builder Constructors
    private Customer(Builder builder){
        this.customerId = builder. customerId;
        this.firstname = builder. firstname;
        this.lastname = builder. lastname;
        this.password = builder. password;
    }


    //Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    //toString
    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String customerId;
        private String firstname;
        private String lastname;
        private String password;

        //Builder Setters
        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(Customer customer){
            this.customerId = customer.customerId;
            this.firstname = customer.firstname;
            this.lastname= customer.lastname;
            this.password= customer.password;
            return this;
        }

        public Customer build(){return new Customer(this);}
    }
}
