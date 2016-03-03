package edu.umkc.restservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

@Path("/")
public class WeatherService {
		@Path("/weatherservice")	
		@GET
		@Produces("application/json")
		public String getWeatherStatus() throws IOException{
			String url = "http://api.openweathermap.org/data/2.5/weather?q=KansasCity,Missouri&mode=json&appid=aecc1ada15291787e9f4ec95ab382165&units=metric";
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse resp = closeableHttpClient.execute(httpGet);
            BufferedReader reader = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
            StringBuffer response = new StringBuffer();
            String inputLine = "";
            while ((inputLine = reader.readLine()) != null) {
            	response.append(inputLine);
            }
            reader.close();
            closeableHttpClient.close();
            System.out.println(response.toString());
            return response.toString();

		}
			/*public static void main(String args[]) throws IOException{
				WeatherService weatherService = new WeatherService();
				weatherService.getWeatherStatus();
			}*/
}
