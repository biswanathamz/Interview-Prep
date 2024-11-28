public class PhoneDisplay implements Observer{
    WeatherStation weatherStation;

    public PhoneDisplay(WeatherStation weatherStation){
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        display(weatherStation.weather);
    }

    public void display(String weather){
        System.out.println("Phone Display: Weather updated - " + weather);
    }
}
