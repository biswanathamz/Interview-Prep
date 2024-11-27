public class TvDiaplay implements Observer{
    WeatherStation weatherStation;

    public TvDiaplay(WeatherStation weatherStation){
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        display(weatherStation.weather);
    }

    public void display(String weather){
        System.out.println("Tv Display: Weather updated - " + weather);
    }
}
