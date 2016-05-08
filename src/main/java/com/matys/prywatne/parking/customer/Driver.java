package com.matys.prywatne.parking.customer;

import com.matys.prywatne.parking.parkingservice.Valet;

public class Driver {

	private Car car;

	public Driver(Car car) {
		this.car = car;
	}

	public boolean askValetForAvailableSpace(Valet valet) {
		return valet.checkAvailablePlace();
	}

	public Integer askValetForIdParkingSpace(Valet valet) {
		return valet.pointToTheFirstFreeSpace();
	}

	public boolean askValetForParkCar(Valet valet, Integer idParkingSpace) {
		return valet.parkCar(idParkingSpace, car);
	}

	public boolean leaveParkingLot(Valet valet, Integer idFreeParkingPlace) {
		return valet.unparkCar(idFreeParkingPlace, car);
	}

}
