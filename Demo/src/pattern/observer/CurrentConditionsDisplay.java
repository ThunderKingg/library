package pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
	private Observable observable;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println(temperature + " + " + humidity);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData){
			WeatherData wetherData = (WeatherData)o;
			this.temperature = wetherData.getTemperature();
			this.humidity = wetherData.getHumidity();
			display();
		}
	}

}
