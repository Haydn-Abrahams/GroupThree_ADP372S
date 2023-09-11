package za.ac.cput.domain;

import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;


    public class Vehicle implements Serializable {


        private String registrationNumber;
        private String licensePlateNumber;
        private String ownershipStatus;

        private String make;

        private String model;

        private String color;

        protected Vehicle(){}

        private Vehicle(Vehicle.Builder builder) {

            this.registrationNumber = builder.registrationNumber;
            this.licensePlateNumber= builder.licensePlateNumber;
            this.ownershipStatus= builder.ownershipStatus;
            this.make= builder.make;
            this.color= builder.color;
            this.model = builder.model;
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

        public static class Builder{

            private String registrationNumber;

            private String licensePlateNumber;

            private String ownershipStatus;

            private String make;

            private String color;
            private String model;

            // setting my builder attibutes

            public Vehicle.Builder setregistrationNumber(String registrationNumber){
                this.registrationNumber = registrationNumber;
                return this;
            }

            public Vehicle.Builder setlicensePlateNumber(String licensePlateNumber){
                this.licensePlateNumber = licensePlateNumber;
                return this;
            }

            public Vehicle.Builder setownershipStatus(String ownershipStatus){
                this.ownershipStatus = ownershipStatus;
                return this;
            }

            public Vehicle.Builder setmake(String make){
                this.make = make;
                return this;
            }
            public Vehicle.Builder setcolor(String color){
                this.color = color;
                return this;
            }


            public Vehicle.Builder setmodel(String model){
                this.model = model;
                return this;
            }

            public Vehicle.Builder copy (final Vehicle vehicle){

                this.registrationNumber = vehicle.registrationNumber;
                this.licensePlateNumber = vehicle.licensePlateNumber;
                this.ownershipStatus = vehicle.ownershipStatus;
                this.make = vehicle.make;
                this.color = vehicle.color;
                this.model = vehicle.model;
                return this;
            }
            public Vehicle build(){
                return new Vehicle(this);
            }
        }

    }
