package Component;
import Enum.VehicleType;

public class Bike extends Vehicle{
    public Bike(String licensePlate){
        super(licensePlate, VehicleType.BIKE);
    }
}
