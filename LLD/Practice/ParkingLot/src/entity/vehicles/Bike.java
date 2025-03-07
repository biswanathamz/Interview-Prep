package entity.vehicles;

import entity.Vehicle;
import enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(int licensePlate) {
        super(licensePlate, VehicleType.Bike);
    }
}
