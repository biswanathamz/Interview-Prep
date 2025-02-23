package CoffeeDecorator;

import CoffeeComponent.Coffee;

public class ExtraMilkDecorator extends CoffeeDecorator{
    public ExtraMilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription(){
        return "Extra milk added!";
    }

    @Override
    public double getPrice(){
        return coffee.getPrice()+25.00;
    }
}
