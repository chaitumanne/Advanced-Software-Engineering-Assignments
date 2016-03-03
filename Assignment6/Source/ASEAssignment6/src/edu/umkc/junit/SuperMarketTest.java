package edu.umkc.junit;

import org.junit.Test;

import edu.umkc.restservices.SuperMarketService;

public class SuperMarketTest {
	SuperMarketService superMarketService = new SuperMarketService();
	@Test
	public void test1() throws Exception{
	String jsonstr=superMarketService.getSuperMarketDetails();
	if(jsonstr!=null)
	{
		System.out.println("Successfully fetched all the details");
	}
	}
}
