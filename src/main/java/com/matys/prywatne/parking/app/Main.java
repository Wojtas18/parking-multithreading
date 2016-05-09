package com.matys.prywatne.parking.app;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.matys.prywatne.parking.customer.Car;
import com.matys.prywatne.parking.customer.Driver;
import com.matys.prywatne.parking.parkinglot.ParkingLot;
import com.matys.prywatne.parking.parkingservice.Valet;

public class Main {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Valet valet = new Valet(ParkingLot.createParkingLot(50));
		
		Queue<Driver> driverQueue = new LinkedBlockingQueue<>();
		
		for (int i = 0; i < 100000; i++) {
			Car car = new Car("Samochód nr: " + i);
			Driver driver = new Driver(car);
			driverQueue.add(driver);
		}
		
		for (int i = 0; i < 20; i++) {
			
			Executor executor = new Executor(driverQueue, valet);
			executorService.execute(executor);
		}
		
		executorService.shutdown();
	}

}
