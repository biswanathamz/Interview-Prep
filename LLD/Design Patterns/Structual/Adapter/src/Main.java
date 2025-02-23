import Adaptee.WeightCalculatorForBabies;
import Adapter.WeightMachineAdapter;
import Adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightCalculatorForBabies());
        System.out.println("Baby's weight is : "+weightMachineAdapter.getWeightInKg()+" Kilogram");
    }
}