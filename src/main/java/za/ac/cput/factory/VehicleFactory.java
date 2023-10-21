package za.ac.cput.factory;


import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.Helper;

public class VehicleFactory {

    public static Vehicle createVehicle(String registrationNumber,String licensePlateNumber, String ownershipStatus, String make, String color, String model) {
        if (Helper.isNullOrEmpty(registrationNumber) ||Helper.isNullOrEmpty(licensePlateNumber)  || Helper.isNullOrEmpty(ownershipStatus) || Helper.isNullOrEmpty(make) || Helper.isNullOrEmpty(color) || Helper.isNullOrEmpty(model)) {
            return null;
        }


        return new Vehicle.Builder().setRegistrationNumber(registrationNumber)
                .setLicensePlateNumber(licensePlateNumber)
                .setOwnershipStatus(ownershipStatus)
                .setMake(make)
                .setModel(model)
                .setColor(color)
                .build();
    }
}