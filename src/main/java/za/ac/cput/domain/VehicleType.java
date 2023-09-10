package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class VehicleType implements Serializable {
    @Id
    private String motorcycle;
    private String lightWeightCar;
    private String miniBus;
    private String truck;

    public VehicleType() {}

    private VehicleType(String motorcycle, String lightWeightCar, String miniBus, String truck) {
        this.motorcycle = motorcycle;
        this.lightWeightCar = lightWeightCar;
        this.miniBus = miniBus;
        this.truck = truck;
    }

    private VehicleType(Builder builder) {
        this.motorcycle = builder.motorcycle;
        this.lightWeightCar = builder.lightWeightCar;
        this.miniBus = builder.miniBus;
        this.truck = builder.truck;
    }

    public String getMotorcycle() {
        return motorcycle;
    }

    public String getLightWeightCar() {
        return lightWeightCar;
    }

    public String getMiniBus() {
        return miniBus;
    }

    public String getTruck() {
        return truck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleType that = (VehicleType) o;
        return Objects.equals(motorcycle, that.motorcycle) && Objects.equals(lightWeightCar, that.lightWeightCar) && Objects.equals(miniBus, that.miniBus) && Objects.equals(truck, that.truck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorcycle, lightWeightCar, miniBus, truck);
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "motorcycle='" + motorcycle + '\'' +
                ", lightWeightCar='" + lightWeightCar + '\'' +
                ", miniBus='" + miniBus + '\'' +
                ", truck='" + truck + '\'' +
                '}';
    }

    public static class Builder {
        private String motorcycle;
        private String lightWeightCar;
        private String miniBus;
        private String truck;

        public Builder setMotorcycle(String motorcycle) {
            this.motorcycle = motorcycle;
            return this;
        }

        public Builder setLightWeightCar(String lightWeightCar) {
            this.lightWeightCar = lightWeightCar;
            return this;
        }

        public Builder setMiniBus(String miniBus) {
            this.miniBus = miniBus;
            return this;
        }

        public Builder setTruck(String truck) {
            this.truck = truck;
            return this;
        }

        public Builder copy(VehicleType vehicleType) {
            this.motorcycle = vehicleType.motorcycle;
            this.lightWeightCar = vehicleType.lightWeightCar;
            this.miniBus = vehicleType.miniBus;
            this.truck = vehicleType.truck;
            return this;
        }

        public VehicleType build() {
            return new VehicleType(motorcycle, lightWeightCar, miniBus, truck);
        }
    }
}