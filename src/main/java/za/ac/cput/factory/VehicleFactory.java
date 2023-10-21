package za.ac.cput.factory;


import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.Helper;

public class VehicleFactory {

    public static Vehicle createVehicle(String registrationNumber,String licensePlateNumber, String manufacturer, String color, String model) {
        if (Helper.isNullOrEmpty(registrationNumber) ||Helper.isNullOrEmpty(licensePlateNumber)  || Helper.isNullOrEmpty(manufacturer) || Helper.isNullOrEmpty(color) || Helper.isNullOrEmpty(model)) {
            return null;
        }


        return new Vehicle.Builder().setRegistrationNumber(registrationNumber)
                .setLicensePlateNumber(licensePlateNumber)
                .setManufacturer(manufacturer)
                .setModel(model)
                .setColor(color)
                .build();
    }
}