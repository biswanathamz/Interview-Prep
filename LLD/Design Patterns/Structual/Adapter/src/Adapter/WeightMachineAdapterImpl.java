package Adapter;

import Adaptee.WeightCalculator;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{
    WeightCalculator weightCalculator;
    public WeightMachineAdapterImpl(WeightCalculator weightCalculator){
        this.weightCalculator = weightCalculator;
    }
    @Override
    public double getWeightInKg() {
        double weightInPound = this.weightCalculator.getWeightInPound();
        return weightInPound*.45;
    }
}
