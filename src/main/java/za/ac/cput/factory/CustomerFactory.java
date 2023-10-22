package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.domain.Customer;

public class CustomerFactory {
    public static Customer createCustomer(String firstName, String lastName,String email, String password) {

        if(Helper.isNullorEmpty(firstName)||
                Helper.isNullorEmpty(lastName)||
                Helper.isNullorEmpty(email)||
                Helper.isNullorEmpty(password))
            return null;

        String customerId = Helper.generateID();

        return new Customer.Builder()
                .setCustomerId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}
