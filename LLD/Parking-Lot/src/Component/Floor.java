package Component;

import java.util.ArrayList;
import java.util.List;

import DTO.BookingSlip;
import Enum.VehicleType;


public class Floor {
    public int levelNumber;
    public int levelNumberOfBikeSpot;
    public int levelNumberOfCarSpot;
    public int levelNumberOfTruckSpot;
    protected List<Spot> spotListCar;
    protected List<Spot> spotListBike;
    protected List<Spot> spotListTruck;
    public Floor(int levelNumber, int levelNumberOfBikeSpot, int levelNumberOfCarSpot, int levelNumberOfTruckSpot){
        this.levelNumber = levelNumber;
        this.levelNumberOfBikeSpot = levelNumberOfBikeSpot;
        this.levelNumberOfCarSpot = levelNumberOfCarSpot;
        this.levelNumberOfTruckSpot = levelNumberOfTruckSpot;
        this.spotListCar = new ArrayList<>();
        this.spotListBike = new ArrayList<>();
        this.spotListTruck = new ArrayList<>();
        for(int i=0;i<this.levelNumberOfBikeSpot;i++){
            Spot spot = new Spot(VehicleType.BIKE,i+1);
            spotListCar.add(spot);
        }
        for(int i=0;i<this.levelNumberOfCarSpot;i++){
            Spot spot = new Spot(VehicleType.CAR,i+1);
            spotListBike.add(spot);
        }
        for(int i=0;i<this.levelNumberOfTruckSpot;i++){
            Spot spot = new Spot(VehicleType.TRUCK,i+1);
            spotListTruck.add(spot);
        }
    }

    public BookingSlip bookSpot(Vehicle vehicle){
        BookingSlip bookingSlip = new BookingSlip();
        List<Spot> varList = null;
        switch (vehicle.vehicleType){
            case CAR:
                varList = this.spotListCar;
                break;
            case BIKE:
                varList = this.spotListBike;
                break;
            case TRUCK:
                varList = this.spotListTruck;
                break;
            default:
                break;
        }
        for (Spot spot : varList){
            if(spot.isAvailable){
                bookingSlip.setSpotNumber(spot.bookSpot());
                bookingSlip.setLevelNumber(this.levelNumber);
                bookingSlip.setVehicleType(vehicle.vehicleType);
            }
        }
        return bookingSlip;
    }

    public boolean releaseBooking(VehicleType vehicleType, int spotId){
        List<Spot> varList = null;
        switch (vehicleType){
            case CAR:
                varList = this.spotListCar;
                break;
            case BIKE:
                varList = this.spotListBike;
                break;
            case TRUCK:
                varList = this.spotListTruck;
                break;
            default:
                break;
        }
        for (Spot spot : varList){
            if(spot.id==spotId && !spot.isAvailable){
                spot.releaseSpot();
                return true;
            }
        }
        return false;
    }
}
