import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot();
        while (true){
            System.out.println("Please enter 1 to book slot for parking!");
            System.out.println("Please enter 2 to release slot for parking!");
            System.out.println("Please enter 3 to See all booking slip");
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    parkingLot.bookSlot();
                    break;
                case 2:
                    parkingLot.releaseSpot();
                    break;
                case 3:
                    parkingLot.viewAllBookingSlip();
                    break;
                default:
                    break;
            }
        }
    }
}