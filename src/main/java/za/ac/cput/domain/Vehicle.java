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

    private String manufacturer;

    private String model;

    private String color;

    public Vehicle(){

    }

    public Vehicle(String registrationNumber, String licensePlateNumber, String manufacturer, String model, String color) {
        this.registrationNumber = registrationNumber;
        this.licensePlateNumber = licensePlateNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
    }

    private Vehicle(Builder builder){
        this.registrationNumber = builder.registrationNumber;
        this.licensePlateNumber = builder.licensePlateNumber;
        this.manufacturer = builder.manufacturer;
        this.model = builder.model;
        this.color = builder.color;

    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getManufacturer() {
        return manufacturer;
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
        return Objects.equals(registrationNumber, vehicle.registrationNumber) && Objects.equals(licensePlateNumber, vehicle.licensePlateNumber)  && Objects.equals(manufacturer, vehicle.manufacturer) && Objects.equals(model, vehicle.model) && Objects.equals(color, vehicle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber, licensePlateNumber, manufacturer, model, color);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", licensePlateNumber='" + licensePlateNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static class Builder {

        private String registrationNumber;

        private String licensePlateNumber;
        private String manufacturer;
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

        public Builder setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
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
            this.manufacturer= vehicle.manufacturer;
            this.model= vehicle.model;
            this.color= vehicle.color;

            return this;
        }

        public Vehicle build(){return  new Vehicle(this);}
    }
}