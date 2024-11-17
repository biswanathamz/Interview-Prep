package Component;
import Enum.VehicleType;


public class Vehicle {
    protected String licensePlate;
    protected VehicleType vehicleType;
    public Vehicle(String licensePlate, VehicleType vehicleType){
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }
    public VehicleType getType(){
        return this.vehicleType;
    }
}
