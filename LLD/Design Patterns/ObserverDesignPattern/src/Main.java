import Observer.PhoneObserver;
import Observer.TvObserver;
import Subject.*;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        PhoneObserver phoneObserver = new PhoneObserver(weatherStation);
        TvObserver tvObserver = new TvObserver(weatherStation);

        weatherStation.add(phoneObserver);
        weatherStation.add(tvObserver);

        weatherStation.notifyObservers("Sunny");
        weatherStation.notifyObservers("Rainy");
    }
}