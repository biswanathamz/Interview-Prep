package entity;

public class Slip {
    int floorNo;
    int spotNo;
    Vehicle vehicle;

    public Slip(int floorNo, int spotNo, Vehicle vehicle){
        this.floorNo = floorNo;
        this.spotNo = spotNo;
        this.vehicle = vehicle;
    }

    public int getFloorNo(){
        return this.floorNo;
    }

    public int getSpotNo(){
        return this.spotNo;
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public int getVehicleNumber(){
        return this.vehicle.getLicensePlate();
    }
}
