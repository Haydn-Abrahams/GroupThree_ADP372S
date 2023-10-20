package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity



public class Vehicle implements Serializable {

    @Id
    private String registrationNumber;
    private String licensePlateNumber;
    private String ownershipStatus;

    private String make;

    private String model;

    private String color;

    public Vehicle(){

    }

    public Vehicle(String registrationNumber, String licensePlateNumber, String ownershipStatus, String make, String model, String color) {
        this.registrationNumber = registrationNumber;
        this.licensePlateNumber = licensePlateNumber;
        this.ownershipStatus = ownershipStatus;
        this.make = make;
        this.model = model;
        this.color = color;
    }

    private Vehicle(Builder builder){
        this.registrationNumber = builder.registrationNumber;
        this.licensePlateNumber = builder.licensePlateNumber;
        this.ownershipStatus = builder.ownershipStatus;
        this.make = builder.make;
        this.model = builder.model;
        this.color = builder.color;

    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getOwnershipStatus() {
        return ownershipStatus;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(registrationNumber, vehicle.registrationNumber) && Objects.equals(licensePlateNumber, vehicle.licensePlateNumber) && Objects.equals(ownershipStatus, vehicle.ownershipStatus) && Objects.equals(make, vehicle.make) && Objects.equals(model, vehicle.model) && Objects.equals(color, vehicle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber, licensePlateNumber, ownershipStatus, make, model, color);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", licensePlateNumber='" + licensePlateNumber + '\'' +
                ", ownershipStatus='" + ownershipStatus + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static class Builder {

        private String registrationNumber;

        private String licensePlateNumber;
        private String ownershipStatus;
        private String make;
        private String model;
        private String color;


        public Builder setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }
        public Builder setLicensePlateNumber(String licensePlateNumber) {
            this.licensePlateNumber = licensePlateNumber;
            return this;
        }

        public Builder setOwnershipStatus(String ownershipStatus) {
            this.ownershipStatus = ownershipStatus;
            return this;
        }
        public Builder setMake(String make) {
            this.make = make;
            return this;
        }
        public Builder setModel(String model) {
            this.model = model;
            return this;
        }
        public Builder setColor(String color) {
            this.color = color;
            return this;
        }
        public Builder copy(Vehicle vehicle){
            this.registrationNumber = vehicle.registrationNumber;
            this.licensePlateNumber= vehicle.licensePlateNumber;
            this.ownershipStatus = vehicle.ownershipStatus;
            this.make= vehicle.make;
            this.model= vehicle.model;
            this.color= vehicle.color;

            return this;
        }

        public Vehicle build(){return  new Vehicle(this);}
    }
}