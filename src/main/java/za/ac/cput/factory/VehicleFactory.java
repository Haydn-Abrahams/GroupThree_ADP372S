package za.ac.cput.factory;

import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.Helper;

public class VehicleFactory {

    public static Vehicle createVehicle(String licensePlateNumber, String ownershipStatus, String make, String color, String model) {
        if (Helper.isNullOrEmpty(licensePlateNumber) || Helper.isNullOrEmpty(ownershipStatus) || Helper.isNullOrEmpty(make) || Helper.isNullOrEmpty(color) || Helper.isNullOrEmpty(model)) {
            return null;
        }

        String registrationNumber = Helper.generateId();

        return new Vehicle.Builder().setlicensePlateNumber(licensePlateNumber)
                .setownershipStatus(ownershipStatus)
                .setmake(make)
                .setcolor(color)
                .setmodel(model)
                .build();
    }
}
