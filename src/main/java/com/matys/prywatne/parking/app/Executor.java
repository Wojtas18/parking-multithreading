package com.matys.prywatne.parking.app;

import java.util.HashMap;
import java.util.Queue;

import com.matys.prywatne.parking.customer.Driver;
import com.matys.prywatne.parking.parkinglot.ParkingSpace;
import com.matys.prywatne.parking.parkingservice.Valet;

public class Executor implements Runnable {
	Queue<Driver> driverQueue;
	Valet valet;

	public Executor(Queue<Driver> driverQueue, Valet valet) {
		this.driverQueue = driverQueue;
		this.valet = valet;
	}

	@Override
	public void run() {
		while (true) {
			if (driverQueue.isEmpty()) {
				break;
			}
			Driver driver = driverQueue.poll();
			if (driver != null) {
				int numberOfTryingPark = 2;
				HashMap<ParkingSpace, Integer> reservationCarSpace = null;
				System.out.println("Kierowca przyjeżdża na parking samochodem: " + driver);
				for (int i = 0; i < numberOfTryingPark; i++) {
					if (driver.askValetForAvailableSpace(valet)) {
						reservationCarSpace = driver.askValetForIdParkingSpace(valet);
						if (reservationCarSpace.size() != 0) {
							Thread parkExecutor = new Thread(new ParkExecutor(driver, reservationCarSpace));
							parkExecutor.start();
							break;
						}
					}

				}

				System.out.println("Aktualna ilosc miejsc: " + valet.ilsscMiejsc());
			}
		}
		System.out.println("Zakończyłem swoją pracę! :)");
	}
}
