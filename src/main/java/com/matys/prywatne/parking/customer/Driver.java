package com.matys.prywatne.parking.customer;

import java.util.HashMap;

import com.matys.prywatne.parking.parkinglot.ParkingSpace;
import com.matys.prywatne.parking.parkingservice.Valet;

public class Driver {

	private Car car;

	public Driver(Car car) {
		this.car = car;
	}

	public boolean askValetForAvailableSpace(Valet valet) {
		return valet.checkAvailablePlace();
	}

	public HashMap<ParkingSpace, Integer> askValetForIdParkingSpace(Valet valet) {
		return valet.pointToTheFirstFreeSpace();
	}

	public boolean askValetForParkCar(Valet valet, Integer idParkingSpace) {
		return valet.parkCar(idParkingSpace, car);
	}

	public boolean leaveParkingLot(ParkingSpace ps, Integer idParkingPlace) {
		return ps.releaseParkingSpace(idParkingPlace, car);
	}
	
	@Override
	public String toString() {
		return car.toString();
	}

	public boolean parkCar(ParkingSpace ps, Integer idParkingSpace) {
		return ps.takeAParkingSpace(idParkingSpace, car);
	}
}
