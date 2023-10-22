package za.ac.cput.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="customerId",columnDefinition = "varchar(36)", length = 36, updatable = false , nullable = false)
    @NotNull
    private String customerId;

    @NotNull
    @Column(name="firstName", length = 255)
    private String firstName;
    @NotNull
    @Column(name="lastName", length = 255)
    private String lastName;
    @NotNull
    @Column(name="email", length = 255)
    private String email;
    @NotNull
    @Column(name="password", length = 255)
    private String password;

    //Constructors
    public Customer(){  }
    public Customer(String firstName, String lastName, String email,String password) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    //private Builder Constructors
    private Customer (Builder builder){
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
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

    public String getEmail() {
        return email;
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
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //Builder Constructors
    public static class Builder {

        private String customerId;
        private String firstName;
        private String lastName;
        private String email;
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

        public Builder setEmail (String email) {
            this.email = email;
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
            this.email= customer.email;
            this.password= customer.password;
            return this;
        }

        public Customer build(){return  new Customer(this);}
    }
}
