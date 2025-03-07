package entity;

import enums.VehicleType;

public class Vehicle {
    int licensePlate;
    VehicleType vehicleType;

    public Vehicle(int licensePlate, VehicleType vehicleType){
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public int getLicensePlate(){
        return this.licensePlate;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }
}
