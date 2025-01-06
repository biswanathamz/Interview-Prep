package Observer;

import Subject.WeatherStation;

public class PhoneObserver implements Observer{
    WeatherStation weatherStation;
    public PhoneObserver(WeatherStation weatherStation){
        this.weatherStation = weatherStation;
    }
    @Override
    public void update() {
        show(this.weatherStation.weather);
    }

    public void show(String weather){
        System.out.println("Current weather is : "+weather+" showing on Phone");
    }
}
