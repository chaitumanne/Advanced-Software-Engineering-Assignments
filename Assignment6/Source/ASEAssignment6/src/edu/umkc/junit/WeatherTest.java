package edu.umkc.junit;

import org.junit.Test;

import edu.umkc.restservices.WeatherService;

public class WeatherTest {
	WeatherService weatherService = new WeatherService();
	@Test
	public void test1() throws Exception{
	String jsonstr=weatherService.getWeatherStatus();
	if(jsonstr!=null)
	{
		System.out.println("Successfully fetched all the details of weather");
	}
	}

}
