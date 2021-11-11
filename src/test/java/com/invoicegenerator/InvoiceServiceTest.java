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
	public void givenMultipleRides_TotalFare() {
		Ride[] rides = {new Ride(2.0, 5),
				new Ride(2.0, 5),
		};
		InvoiceGenerator invoiceService = new InvoiceGenerator();
		double totalFare = invoiceService.calculateTotalFare(rides);
		Assert.assertEquals(30, totalFare, 0);
	}

	@Test
	public void givenDistanceAndTime_PremiumTotalFare() {
		InvoiceGenerator invoiceService = new InvoiceGenerator();
		double distance = 5.0;
		int time = 12;
		String type = "premium";
		double fare = invoiceService.calculateFare(distance, time, type);
		Assert.assertEquals(99, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTimePremiumMinFare() {
		InvoiceGenerator invoiceService = new InvoiceGenerator();
		double distance = 1.1;
		int time = 2;
		String type = "premium";
		double fare = invoiceService.calculateFare(distance, time, type);
		Assert.assertEquals(20.5, fare, 0.0);
	}

	@Test
	public void givenMultipleRidesWhenGivenPremiumShouldReturnTotalFare() {
		InvoiceGenerator invoiceService = new InvoiceGenerator();
		Ride[] rides = {new Ride(2.0, 5),
				new Ride(0.1, 1)};
		String type = "premium";
		double totalFare = invoiceService.calculateFare(rides, type);
		Assert.assertEquals(60, totalFare, 0.0);
	}

}