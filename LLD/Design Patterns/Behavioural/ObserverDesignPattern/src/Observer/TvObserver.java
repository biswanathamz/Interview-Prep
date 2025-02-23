package Observer;

import Subject.WeatherStation;

public class TvObserver implements Observer{
    WeatherStation weatherStation;
    public TvObserver(WeatherStation weatherStation){
        this.weatherStation = weatherStation;
    }
    @Override
    public void update() {
        show(this.weatherStation.weather);
    }

    public void show(String weather){
        System.out.println("Current weather is : "+weather+" showing on TV");
    }
}
