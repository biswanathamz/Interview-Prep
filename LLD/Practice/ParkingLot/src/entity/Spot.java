package entity;

import enums.VehicleType;

public class Spot {
    int id;
    boolean isAvailable;
    VehicleType vehicleType;

    public Spot(int id, VehicleType vehicleType){
        this.id = id;
        isAvailable = true;
        this.vehicleType = vehicleType;
    }

    public int getSpotId(){
        return this.id;
    }

    public boolean book(){
        if (isAvailable){
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    public void release(){
        this.isAvailable = true;
    }
}
