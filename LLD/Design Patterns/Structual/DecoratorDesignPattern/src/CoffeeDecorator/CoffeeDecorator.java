package CoffeeDecorator;

import CoffeeComponent.Coffee;

public class CoffeeDecorator implements Coffee {

    Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription();
    }

    @Override
    public double getPrice() {
        return this.coffee.getPrice();
    }
}
