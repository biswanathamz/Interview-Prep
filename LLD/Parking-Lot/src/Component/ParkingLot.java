package Component;

import DTO.BookingSlip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {
    int noOfFloor= 0;
    Scanner scanner = new Scanner(System.in);
    List<Floor> floorList = new ArrayList<>();

    public ParkingLot(){
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
            int numberOfSlotForCar = scanner.nextInt();
            System.out.println("Please enter the number of Bike slot for leavel : "+(i+1));
            int numberOfSlotForBike = scanner.nextInt();
            System.out.println("Please enter the number of Truck slot for leavel : "+(i+1));
            int numberOfSlotForTruck = scanner.nextInt();
            Floor floor = new Floor((i+1),numberOfSlotForCar,numberOfSlotForBike,numberOfSlotForTruck);
            this.floorList.add(floor);
        }
    }

    public void bookSlot(){
        System.out.println("Please enter 1 for CAR, 2 for Bike, 3 for Truck");
        int vehicleInput = scanner.nextInt();
        System.out.println("Please enter the numberplate details");
        String numberPlateNumber = String.valueOf(scanner.nextInt());
        Vehicle vehicle = switch (vehicleInput) {
            case 1 -> new Car(numberPlateNumber);
            case 2 -> new Bike(numberPlateNumber);
            case 3 -> new Truck(numberPlateNumber);
            default -> null;
        };
        for(Floor floor : floorList){
            assert vehicle != null;
            BookingSlip bookingSlip = floor.bookSpot(vehicle);
            if(bookingSlip.getLevelNumber()==floor.levelNumber){
                System.out.println("You got the spot for parking level : "+bookingSlip.getLevelNumber()+" and spot : "+bookingSlip.getSpotNumber());
                return;
            }
        }
        System.out.println("Not Slot available, Sorry!");
    }
}
