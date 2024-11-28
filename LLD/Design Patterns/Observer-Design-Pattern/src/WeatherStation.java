import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{
    List<Observer> observerList = new ArrayList<>();
    public String weather;
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList){
            observer.update();
        }
    }

    @Override
    public boolean setValue(String value) {
        this.weather = value;
        notifyObservers();
        return true;
    }
}
