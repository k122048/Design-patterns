package weather.app.example;

import java.util.ArrayList;

public class WeatherData implements Subject {

	private ArrayList observers;
	private float humidity;
	private float tempurature;
	private float pressure;
	
	
	public WeatherData()
	{
		observers = new ArrayList();
		
	}
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(Observer o) {
	
		int i = observers.indexOf(o);
		
		if(i>=0)
		{
			observers.remove(o);
		}

	}

	@Override
	public void notifyObserver() {
         for(int i=0;i<observers.size();i++)
         {
        	 Observer observer = (Observer)observers.get(i);
        	 observer.update(tempurature, humidity, pressure);
        	 
         }
		
	}
	
	public void measurementsChanged()
	{
		notifyObserver();
	}
	
	public void setMeasurements(float tempurature,float humidity,float pressure)
	{
		this.humidity = humidity;
		this.pressure = pressure;
		this.tempurature = tempurature;
		measurementsChanged();
	}

}
