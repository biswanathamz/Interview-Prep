package Component;

import DTO.BookingSlip;

import java.util.*;
import Enum.VehicleType;

@Componect
public class ParkingLot {
    int noOfFloor= 0;
    Scanner scanner = new Scanner(System.in);
    List<Floor> floorList = new ArrayList<>();
    Map<String,BookingSlip> bookingSlipMap = new HashMap<>();

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
                bookingSlipMap.put(numberPlateNumber,bookingSlip);
                System.out.println("You got the spot for parking level : "+bookingSlip.getLevelNumber()+" and spot : "+bookingSlip.getSpotNumber());
                return;
            }
        }
        System.out.println("Not Slot available, Sorry!");
    }

    public void viewAllBookingSlip(){
        if(this.bookingSlipMap.isEmpty()){
            System.out.println("No booking available");
            return;
        }
        System.out.println("Please find below all the booking details : ");
        for (Map.Entry<String,BookingSlip>entry : this.bookingSlipMap.entrySet()){
            String numberPlate = entry.getKey();
            BookingSlip bookingSlip = entry.getValue();
            System.out.println("License Plate: " + numberPlate +
                    ", Level: " + bookingSlip.getLevelNumber() +
                    ", Spot: " + bookingSlip.getSpotNumber());
        }
    }

    public void releaseSpot(){
        System.out.println("Please enter the vehicle number : ");
        String vehicleNumber = scanner.nextLine();
        BookingSlip bookingSlip = new BookingSlip();
        bookingSlip = this.bookingSlipMap.get(vehicleNumber);
        boolean releaseFlag = false;
        if(bookingSlip.getLevelNumber()>0){
            VehicleType vehicleType = bookingSlip.getVehicleType();
            for(Floor floor : floorList){
                if(floor.levelNumber==bookingSlip.getLevelNumber()){
                    if(floor.releaseBooking(vehicleType,bookingSlip.getSpotNumber())){
                        this.bookingSlipMap.remove(vehicleNumber);
                        releaseFlag = true;
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
