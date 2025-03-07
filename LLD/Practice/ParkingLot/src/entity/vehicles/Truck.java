package entity.vehicles;

import entity.Vehicle;
import enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(int licensePlate) {
        super(licensePlate, VehicleType.Truck);
    }
}
