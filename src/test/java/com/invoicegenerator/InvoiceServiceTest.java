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

	@Test
	public void givenMultipleRides_ShouldReturnTotalOfTotalFare() {
		Ride[] rides = {new Ride(2.0, 5),
				new Ride(2.0, 5),
		};
		InvoiceGenerator invoiceService = new InvoiceGenerator();
		double totalFare = invoiceService.calculateTotalFare(rides);
		Assert.assertEquals(30, totalFare, 0);
	}
}