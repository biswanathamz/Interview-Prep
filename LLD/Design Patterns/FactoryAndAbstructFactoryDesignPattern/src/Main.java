import Shape.Shape;
import Shape.ShapeFactory;
import VehicleFactory.*;
import Vehicles.Bike;
import Vehicles.Car;

public class Main {
    public static void main(String[] args) {

        // Factory Design Pattern
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("circle");
        Shape rectangle = shapeFactory.getShape("rectangle");

        circle.draw();
        rectangle.draw();

        // Abstract Factory Design Pattern
        VehicleFactory vehicleFactory;
        Car car;
        Bike bike;

        vehicleFactory = new LuxuryVehicleFactory();
        car = vehicleFactory.showCar();
        bike = vehicleFactory.showBike();

        car.show();
        bike.show();

        vehicleFactory = new EconomyVehicleFactory();
        car = vehicleFactory.showCar();
        bike = vehicleFactory.showBike();

        car.show();
        bike.show();
    }
}