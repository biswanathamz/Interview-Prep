public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Observer phoneDisplay  = new PhoneDisplay(weatherStation);
        Observer TvDisplay = new TvDiaplay(weatherStation);
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(TvDisplay);

        weatherStation.setValue("Sunny");
        weatherStation.setValue("Rainy");
    }
}