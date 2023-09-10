package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Customer {

    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String password;

    //Constructors
    public Customer(){  }
    public Customer(String customerId, String firstName, String lastName, String password) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    //private Builder Constructors
    private Customer (Builder builder){
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
    }

    //Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //Builder Constructors
    public static class Builder {

        private String customerId;
        private String firstName;
        private String lastName;
        private String password;

        //Builder Setters
        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName (String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(Customer customer){
            this.customerId= customer.customerId;
            this.firstName = customer.firstName;
            this.lastName= customer.lastName;
            this.password= customer.password;
            return this;
        }

        public Customer build(){return  new Customer(this);}
    }
}
