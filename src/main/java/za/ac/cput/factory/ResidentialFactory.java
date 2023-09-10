package za.ac.cput.factory;

import za.ac.cput.domain.BaseAddress;
import za.ac.cput.domain.Residential;
import za.ac.cput.util.Helper;
public class ResidentialFactory {
    public static Residential createResidential(String street_Address, String city, String state, String suburb, String postal_Code, String country){
        if (Helper.isNullorEmpty(street_Address) || Helper.isNullorEmpty(city) || Helper.isNullorEmpty(state) || Helper.isNullorEmpty(suburb) || Helper.isNullorEmpty(country)) {
            return null;
        }

        Long random_Id = Helper.generateRandomLong();

        BaseAddress baseAddress = BaseAddress.builder().id(random_Id).city(city).state(state).suburb(suburb).postalCode(postal_Code).country(country).build();

        return Residential.builder().id(random_Id).street_Address(street_Address).baseAddress(baseAddress).build();
    }
}