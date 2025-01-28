package VehicleFactory;

import Variant.LuxuryCar;
import Vehicles.Bike;
import Vehicles.Car;

public interface VehicleFactory {
    Car showCar();
    Bike showBike();
}
