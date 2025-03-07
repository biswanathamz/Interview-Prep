package entity.vehicles;

import entity.Vehicle;
import enums.VehicleType;

public class Car extends Vehicle {
    public Car(int licensePlate) {
        super(licensePlate, VehicleType.Car);
    }
}
