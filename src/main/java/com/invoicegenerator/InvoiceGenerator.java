package com.invoicegenerator;

public class InvoiceGenerator {
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KILOMETER = 5;
	private static final double MINIMUM_FARE = 5.0;
	private static final double MINIMUM_COST_PER_KILOMETER_NORMAL = 5;
	private static final double COST_PER_TIME_NORMAL = 1;
	private static final double MINIMUM_FARE_NORMAL = 5.0;
	private static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15;
	private static final double COST_PER_TIME_PREMIUM = 2;
	private static final double MINIMUM_FARE_PREMIUM = 20.0;

	//calculating fare for a ride
	public double calculateFare(double distance, int time) {
		double totalFare =  distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	//calculating fare for multiple ride
	public double calculateTotalFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;
	}

	//calculating fare for a ride whether it s normal or Premium
	public double calculateFare(double distance, int time, String type) {
		if (type.equalsIgnoreCase("Normal")) {
			double totalFare = distance * MINIMUM_COST_PER_KILOMETER_NORMAL + time * COST_PER_TIME_NORMAL;
			return Math.max(totalFare, MINIMUM_FARE_NORMAL);
		}
		else if (type.equalsIgnoreCase("Premium")) {
			double totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
			return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
		}
		else {
			return 0;
		}
	}

	//calculating fare for multiple ride whether it s normal or Premium
	public double calculateFare(Ride[] rides, String type) {
		double totalFare = 0.0;
		if (type.equalsIgnoreCase("Normal")) {
			for (Ride ride : rides) {
				totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
			}
			return totalFare;

		} 
		else if (type.equalsIgnoreCase("Premium")) {
			for (Ride ride : rides) {
				totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
			}
			return totalFare;
		}
		return 0;
	}
}
