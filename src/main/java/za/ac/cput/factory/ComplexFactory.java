package za.ac.cput.factory;

import za.ac.cput.domain.BaseAddress;
import za.ac.cput.domain.Complex;
import za.ac.cput.util.Helper;

public class ComplexFactory {
    public static Complex createComplex(String complexName, String unit, String floor, String city, String state, String suburb, String postal_Code, String country){
        if(Helper.isNullorEmpty(complexName) || Helper.isNullorEmpty(floor) || Helper.isNullorEmpty(city) || Helper.isNullorEmpty(state) || Helper.isNullorEmpty(suburb) || Helper.isNullorEmpty(country)){
            return null;
        }
        Long random_Id = Helper.generateRandomLong();

        BaseAddress baseAddress = BaseAddress.builder().id(random_Id).city(city).state(state).suburb(suburb).postalCode(postal_Code).country(country).build();

        return Complex.builder().id(random_Id).name(complexName).unit(unit).floor(floor).baseAddress(baseAddress).build();
    }
}