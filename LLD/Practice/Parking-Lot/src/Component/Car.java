package Component;
import Enum.VehicleType;

public class Car extends Vehicle{
    public Car (String licensePlate){
        super(licensePlate,VehicleType.CAR);
    }
}
