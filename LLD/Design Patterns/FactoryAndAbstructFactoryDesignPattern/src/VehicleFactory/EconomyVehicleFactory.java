package VehicleFactory;

import Variant.EconomyBike;
import Variant.EconomyCar;
import Vehicles.Bike;
import Vehicles.Car;

public class EconomyVehicleFactory implements VehicleFactory{
    @Override
    public Car showCar() {
        return new EconomyCar();
    }

    @Override
    public Bike showBike() {
        return new EconomyBike();
    }
}
