package entity;

import enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    int no;
    List<Spot> spotList;

    public Floor(int no){
        this.no = no;
        spotList = new ArrayList<>();
    }

    public int getFloorNo(){
        return this.no;
    }

    public void addSpot(Spot spot){
        this.spotList.add(spot);
    }

    public Spot getSpot(int spotId){
        for (Spot spot : this.spotList){
            if(spot.getSpotId()==spotId){
                return spot;
            }
        }
        return null;
    }

    public boolean isSpotAvailable(VehicleType vehicleType){
        for (Spot spot : this.spotList){
            if(spot.vehicleType == vehicleType){
                if(spot.isAvailable){
                    return true;
                }
            }
        }
        return false;
    }

    public Spot getAvailableSpot (VehicleType vehicleType){
        for (Spot spot : this.spotList){
            if(spot.vehicleType == vehicleType){
                if(spot.isAvailable){
                    return spot;
                }
            }
        }
        return null;
    }
}
