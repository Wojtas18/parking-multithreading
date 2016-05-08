package com.matys.prywatne.parking.parkinglot;

import com.matys.prywatne.parking.customer.Car;

public class ParkingLot {

	final int maxParkingSpace;
	private ParkingSpace parkingSpace;

	private ParkingLot(int maxParkingSpace) {
		this.maxParkingSpace = maxParkingSpace;
		parkingSpace = new ParkingSpace();
	}

	public static ParkingLot createParkingLot(int parkingSpace) {
		int incorrectParkingSpace = 0;
		if(parkingSpace <= incorrectParkingSpace) {
			throw new IllegalArgumentException("Niewłaściwa ilość miejsc na parkingu: " + parkingSpace);
		}
		return new ParkingLot(parkingSpace);
	}

	public boolean isAvailableParkingSpace() {
		if(parkingSpace.numberOfOccupiedParkingSpace() < maxParkingSpace) {
			return true;
		} else {
			return false;
		}
	}

	public boolean takeAParkingSpace(Integer idParkingSpace, Car carToPark) {
		return parkingSpace.takeAParkingSpace(idParkingSpace, carToPark);
	}

	public Integer firstFreeParkingSpace() {
		return parkingSpace.firstFreeParkingSpace(maxParkingSpace);
	}

	public boolean releaseAParkingSpace(int idParkingSpace, Car carToUnpark) {
		return parkingSpace.releaseParkingSpace(idParkingSpace, carToUnpark);
	}


}
