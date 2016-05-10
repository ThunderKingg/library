package pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;
	
	public void measurementsChanged(){
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
	
	public static void main(String[] args) {
		WeatherData w = new WeatherData();
		Observer o = new CurrentConditionsDisplay(w);
		w.setMeasurements(1.1f, 2.1f, 3.1f);
		w.setMeasurements(4.1f, 5.1f, 6.1f);
		w.setMeasurements(7.1f, 8.1f, 9.1f);
	}

}
