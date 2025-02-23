package CoffeeComponent;

public class CappuccinoComponent implements Coffee{
    @Override
    public String getDescription() {
        return "This is a Cappuccino Coffee!";
    }

    @Override
    public double getPrice() {
        return 100.00;
    }
}
