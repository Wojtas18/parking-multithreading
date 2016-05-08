package com.matys.prywatne.parking.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.matys.prywatne.parking.customer.Car;
import com.matys.prywatne.parking.customer.Driver;
import com.matys.prywatne.parking.parkinglot.ParkingLot;
import com.matys.prywatne.parking.parkingservice.Valet;

public class Main {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		Valet valet = new Valet(ParkingLot.createParkingLot(50));
		for (int i = 0; i < 1000; i++) {
			Car car = new Car("Samochód nr: " + i);
			Driver driver = new Driver(car);
			Executor executor = new Executor(driver, valet);
			executorService.execute(executor);
		}
		
		executorService.shutdown();
	}

}
