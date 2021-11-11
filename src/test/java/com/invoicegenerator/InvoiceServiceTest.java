package com.invoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
	@Test
	public void givenDistanceandTime_Totalfare() {
		InvoiceGenerator invoicegenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoicegenerator.calculateFare(distance, time);
		Assert.assertEquals(15, fare, 0.0);
	}
	
	@Test
	public void givenDistanceandTime_MinimumFare() {
		InvoiceGenerator invoicegenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoicegenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
}