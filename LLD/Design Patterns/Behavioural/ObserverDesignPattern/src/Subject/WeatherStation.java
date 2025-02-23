package Subject;

import Observer.*;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{
    ArrayList<Observer> observerArrayList = new ArrayList<>();
    public String weather = "";

    @Override
    public void add(Observer observer) {
        this.observerArrayList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        this.observerArrayList.remove(observer);
    }

    @Override
    public void notifyObservers(String weather) {
        this.weather = weather;
        for (Observer observer : this.observerArrayList){
            observer.update();
        }
    }

}
