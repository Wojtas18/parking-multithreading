package com.matys.prywatne.parking.parkinglot;

public class ParkingLot {

	public final int maxParkingSpace;

	private ParkingLot(int parkingSpace) {
		maxParkingSpace = parkingSpace;
	}

	public static ParkingLot createParkingLot(int parkingSpace) {
		int incorrectParkingSpace = 0;
		if(parkingSpace <= incorrectParkingSpace) {
			throw new IllegalArgumentException("Niewłaściwa ilość miejsc na parkingu: " + parkingSpace);
		}
		return new ParkingLot(parkingSpace);
	}


}
