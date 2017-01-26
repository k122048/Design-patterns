package weather.app.example;

public class CurrentConditionDisplay implements Observer, DisplayElement {

	private float tempurature;
	private float humidity;
	private float pressure;
	private Subject WeatherData;
	
	public CurrentConditionDisplay(Subject weatherData)
	{
		this.WeatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Tempurature = "+this.tempurature+
				" pressure "+this.pressure+" Humidity = "+this.humidity);
		
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.tempurature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
		
		// TODO Auto-generated method stub

	}

}
