package com.matys.prywatne.parking.parkingservice;

import java.util.HashMap;

import com.matys.prywatne.parking.customer.Car;
import com.matys.prywatne.parking.parkinglot.ParkingLot;
import com.matys.prywatne.parking.parkinglot.ParkingSpace;

public class Valet {

	private ParkingLot parkingLot;
	
	public Valet(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public boolean checkAvailablePlace() {
		return parkingLot.isAvailableParkingSpace();
	}

	public HashMap<ParkingSpace, Integer> pointToTheFirstFreeSpace() {
		return parkingLot.firstFreeParkingSpace();
	}

	public boolean parkCar(Integer idParkingSpace, Car carToPark) {
		return parkingLot.takeAParkingSpace(idParkingSpace, carToPark);
	}

	public boolean unparkCar(Integer idFreeParkingSpace, Car carToUnpark) {
		return parkingLot.releaseAParkingSpace(idFreeParkingSpace, carToUnpark);
	}
	
	public int ilsscMiejsc() {
		return parkingLot.getIloscMiejsc();
	}

}
