import CoffeeComponent.CappuccinoComponent;
import CoffeeComponent.Coffee;
import CoffeeDecorator.ExtraMilkDecorator;
import CoffeeDecorator.WhippedCreamDecorator;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new CappuccinoComponent();

        System.out.println(coffee.getDescription());

        coffee = new ExtraMilkDecorator(coffee);
        System.out.println(coffee.getDescription());

        coffee = new WhippedCreamDecorator(coffee);
        System.out.println(coffee.getDescription());

        System.out.println("Total Cost : "+coffee.getPrice());
    }
}