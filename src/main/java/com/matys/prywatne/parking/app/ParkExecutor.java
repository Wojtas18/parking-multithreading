package com.matys.prywatne.parking.app;

import java.util.HashMap;

import com.matys.prywatne.parking.customer.Driver;
import com.matys.prywatne.parking.parkinglot.ParkingSpace;

public class ParkExecutor implements Runnable {

	Driver driver;
	HashMap<ParkingSpace, Integer> reservation;

	public ParkExecutor(Driver driver, HashMap<ParkingSpace, Integer> reservation) {
		this.driver = driver;
		this.reservation = reservation;
	}

	@Override
	public void run() {
		ParkingSpace ps = reservation.keySet().iterator().next();
		Integer idParkingSpace = reservation.values().iterator().next();
		if (driver.parkCar(ps, idParkingSpace)) {
			System.out.println("Kierowca zaparkował: " + driver + " na miejscu " + idParkingSpace);
			try {
				int parkTime = (int) (Math.random());
				Thread.sleep(parkTime);
				System.out.println("Kierowca: " + driver + " był na parkingu na miejscu: " + idParkingSpace + " "
						+ " przez " + (parkTime / 1000) + " sekund");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.leaveParkingLot(ps, idParkingSpace);
			System.out.println("Kierowca: " + driver + " opuścił parking");
		}
	}

}
