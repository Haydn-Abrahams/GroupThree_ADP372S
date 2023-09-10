package za.ac.cput.factory;

import za.ac.cput.domain.VehicleType;
import za.ac.cput.util.Helper;

public class VehicleTypeFactory {
    public static VehicleType buildVehicleType(String motorcycle, String lightWeightCar, String miniBus, String truck){
        if(Helper.isNullorEmpty(motorcycle) || Helper.isNullorEmpty(lightWeightCar) || Helper.isNullorEmpty(miniBus) || Helper.isNullorEmpty(truck)){
            return null;
        }

        return new VehicleType.Builder().setMotorcycle(motorcycle)
                .setLightWeightCar(lightWeightCar)
                .setMiniBus(miniBus)
                .setTruck(truck)
                .build();
    }
}
