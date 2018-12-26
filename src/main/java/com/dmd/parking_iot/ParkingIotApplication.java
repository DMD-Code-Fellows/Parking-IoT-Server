package com.dmd.parking_iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Spring Boot parking lot application.
 *
 * An Internet-of-Things (IoT) application, that automates parking space availability in a parking lot, so that drivers can
 * quickly locate the nearest available space, in order to save time and fuel, and that also helps parking lot owners and attendants,
 * monitor and manage their lots.
 */
@SpringBootApplication
public class ParkingIotApplication {

	/**
	 * Standard Java application entry point.
	 * @param args An array of application input arguments. Not used.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ParkingIotApplication.class, args);
	}

}

