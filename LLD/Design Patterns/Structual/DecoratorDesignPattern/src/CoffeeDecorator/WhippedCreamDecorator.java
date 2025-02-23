package CoffeeDecorator;

import CoffeeComponent.Coffee;

public class WhippedCreamDecorator extends CoffeeDecorator{
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription(){
        return "Whipped Cream Added!";
    }

    @Override
    public double getPrice(){
        return coffee.getPrice()+50.00;
    }
}
