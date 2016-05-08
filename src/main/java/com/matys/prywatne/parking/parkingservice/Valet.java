package com.matys.prywatne.parking.parkingservice;

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

}
