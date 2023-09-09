package za.ac.cput.util.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.util.domain.Customer;

public class CustomerFactory {

    public static Customer createCustomer(String firstname,String lastname,String password){

        if(Helper.isNullorEmpty(firstname) || Helper.isNullorEmpty(lastname) || Helper.isNullorEmpty(password))
            return null;

        String id = Helper.generateID();

        return new Customer.Builder()
                .setFirstname(firstname)
                .setLastname(lastname)
                .setPassword(password)
                .setCustomerId(id)
                .build();
    }
}
