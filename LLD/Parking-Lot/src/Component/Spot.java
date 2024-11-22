package Component;
import Enum.VehicleType;

public class Spot {
    public boolean isAvailable;
    public VehicleType vehicleType;
    public int id;
    public Spot(VehicleType vehicleType, int id){
        isAvailable = true;
        this.vehicleType = vehicleType;
        this.id = id;
    }

    public int bookSpot(){
        if(this.isAvailable){
            isAvailable = false;
        }
        return this.id;
    }
     public boolean releaseSpot(){
        isAvailable=true;
        return true;
     }
}
