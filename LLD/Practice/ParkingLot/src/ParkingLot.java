import entity.Floor;
import entity.Slip;
import entity.Spot;
import entity.Vehicle;
import entity.vehicles.Bike;
import entity.vehicles.Car;
import entity.vehicles.Truck;
import enums.VehicleType;

import java.util.*;

public class ParkingLot {

    int noOfFloor;
    Scanner scanner ;
    List<Floor> floors;
    Map<Integer, Slip> slipMap;

    public ParkingLot(){
        this.scanner = new Scanner(System.in);
        this.floors = new ArrayList<>();
        this.slipMap = new HashMap<>();
        this.noOfFloor = 0;
        this.createParkingLot();
    }

    public void createParkingLot(){
        System.out.println("Please Enter the Number Of Floors : ");
        try{
            this.noOfFloor = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Please enter correct option!");
            createParkingLot();
        }
        for(int i=0; i<this.noOfFloor; i++){
            System.out.println("Please enter the number of CAR slot for leavel : "+(i+1));
            int numberOfSpotForCar = scanner.nextInt();
            System.out.println("Please enter the number of Bike slot for leavel : "+(i+1));
            int numberOfSpotForBike = scanner.nextInt();
            System.out.println("Please enter the number of Truck slot for leavel : "+(i+1));
            int numberOfSpotForTruck = scanner.nextInt();
            Floor floor = new Floor(i);
            this.createSpot(floor,numberOfSpotForCar,VehicleType.Car);
            this.createSpot(floor,numberOfSpotForBike,VehicleType.Bike);
            this.createSpot(floor,numberOfSpotForTruck,VehicleType.Truck);
            this.floors.add(floor);
        }
    }

    public void createSpot(Floor floor, int numberOfSpot, VehicleType vehicleType){
        int i = 0;
        while(i<numberOfSpot){
            Spot spot = new Spot(i,vehicleType);
            floor.addSpot(spot);
            i++;
        }
    }

    public void bookSlot(){
        System.out.println("Please enter 1 for CAR, 2 for Bike, 3 for Truck");
        int vehicleInput = scanner.nextInt();
        System.out.println("Please enter the numberplate details");
        String numberPlateNumber = String.valueOf(scanner.nextInt());
        Vehicle vehicle = switch (vehicleInput) {
            case 1 -> new Car(Integer.parseInt(numberPlateNumber));
            case 2 -> new Bike(Integer.parseInt(numberPlateNumber));
            case 3 -> new Truck(Integer.parseInt(numberPlateNumber));
            default -> null;
        };
        for(Floor floor : this.floors){
            assert vehicle != null;
            if(floor.isSpotAvailable(vehicle.getVehicleType())){
                Spot spot = floor.getAvailableSpot(vehicle.getVehicleType());
                if(!spot.book()){
                    System.out.println("System Error!");
                }
                Slip bookingSlip = new Slip(floor.getFloorNo(),spot.getSpotId(),vehicle);
                this.slipMap.put(vehicle.getLicensePlate(),bookingSlip);
                System.out.println("You got the spot for parking level : "+floor.getFloorNo()+" and spot : "+bookingSlip.getSpotNo());
                return;
            }
        }
        System.out.println("Not Slot available, Sorry!");
    }

    public void viewAllBookingSlip(){
        if(this.slipMap.isEmpty()){
            System.out.println("No booking available");
            return;
        }
        System.out.println("Please find below all the booking details : ");
        for (Map.Entry<Integer,Slip> entry : this.slipMap.entrySet()){
            Integer numberPlate = entry.getKey();
            Slip bookingSlip = entry.getValue();
            System.out.println("License Plate: " + numberPlate +
                    ", Level: " + bookingSlip.getFloorNo() +
                    ", Spot: " + bookingSlip.getSpotNo());
        }
    }

    public void releaseSpot(){
        System.out.println("Please enter the vehicle number : ");
        int vehicleNumber = scanner.nextInt();
        boolean releaseFlag = false;

        for(Map.Entry<Integer,Slip> entry : this.slipMap.entrySet()){
            int numberPlateId = entry.getKey();
            if(numberPlateId==vehicleNumber){
                for (Floor floor : floors){
                    if(floor.getFloorNo()==entry.getValue().getFloorNo()){
                        Spot spot = floor.getSpot(entry.getValue().getSpotNo());
                        if(spot!=null){
                            this.slipMap.remove(numberPlateId);
                            releaseFlag = true;
                        }
                    }
                }
            }
        }
        if(releaseFlag){
            System.out.println(vehicleNumber+" is released from the parking lot.");
        }else{
            System.out.println("Unable to release : "+vehicleNumber);
        }
    }
}
