package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.domain.Customer;

public class CustomerFactory {
    public static Customer createCustomer(String firstName, String lastName, String password) {

        if(Helper.isNullorEmpty(firstName)
                || Helper.isNullorEmpty(lastName)|| Helper.isNullorEmpty(password))
            return null;

        String customerId = Helper.generateID();

        return new Customer.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .setCustomerId(customerId)
                .build();
    }
}
