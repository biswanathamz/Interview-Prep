import Component.ParkingLot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot();
        while (true){
            System.out.println("Please enter 1 to book slot for parking!");
            System.out.println("Please enter 2 to release slot for parking!");
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    parkingLot.bookSlot();
                    break;
                default:
                    break;
            }
        }
    }
}