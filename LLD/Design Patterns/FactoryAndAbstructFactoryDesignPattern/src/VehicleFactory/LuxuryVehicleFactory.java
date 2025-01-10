package VehicleFactory;

import Variant.LuxuryBike;
import Variant.LuxuryCar;
import Vehicles.Bike;

public class LuxuryVehicleFactory implements VehicleFactory {
    @Override
    public LuxuryCar showCar() {
        return new LuxuryCar();
    }

    @Override
    public Bike showBike() {
        return  new LuxuryBike();
    }
}
