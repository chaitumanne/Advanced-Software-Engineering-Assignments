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
public class SuperMarketService {
	
			@Path("/marketservice")	
			@GET
			@Produces("application/xml")
			public String getSuperMarketDetails() throws IOException{
				String url = "http://www.supermarketapi.com/api.asmx/SearchByProductName?APIKEY=236a7ba5f9&ItemName=beer";
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

	public static void main(String[] args) throws IOException {
		SuperMarketService superMarketService= new SuperMarketService();
		superMarketService.getSuperMarketDetails();

	}

}
