package com.matys.prywatne.parking.parkingservice;

import com.matys.prywatne.parking.customer.Car;
import com.matys.prywatne.parking.parkinglot.ParkingLot;

public class Valet {

	private ParkingLot parkingLot;
	
	public Valet(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public boolean checkAvailablePlace() {
		return parkingLot.isAvailableParkingSpace();
	}

	synchronized public Integer pointToTheFirstFreeSpace() {
		return parkingLot.firstFreeParkingSpace();
	}

	public boolean parkCar(Integer idParkingSpace, Car carToPark) {
		return parkingLot.takeAParkingSpace(idParkingSpace, carToPark);
	}

	public boolean unparkCar(Integer idFreeParkingSpace, Car carToUnpark) {
		return parkingLot.releaseAParkingSpace(idFreeParkingSpace, carToUnpark);
	}

}
