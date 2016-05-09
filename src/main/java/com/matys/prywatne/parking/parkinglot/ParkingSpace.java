package com.matys.prywatne.parking.parkinglot;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.matys.prywatne.parking.customer.Car;

public class ParkingSpace {
	
	private ConcurrentMap<Integer, Car> concurrentMap;
	
	public ParkingSpace() {
		concurrentMap = new ConcurrentHashMap<>();
	}

	public boolean takeAParkingSpace(Integer idParkingSpace, Car carToPark) {
		concurrentMap.put(idParkingSpace, carToPark);
		return true;
	}

	public int numberOfOccupiedParkingSpace() {
		return concurrentMap.size();
	}

	public boolean releaseParkingSpace(Integer idParkingSpace, Car carToUnpark) {
		return concurrentMap.remove(idParkingSpace, carToUnpark);
	}

	public synchronized HashMap<ParkingSpace, Integer> firstFreeParkingSpace(int maxParkingSpace) {
		HashMap<ParkingSpace, Integer> reservationParkingSpace = new HashMap<>();
		for (int i = 0; i < maxParkingSpace; i++) {
			if(concurrentMap.get(i) == null) {
				//rezerwacja miejsca
				concurrentMap.put(i, new Car());
				reservationParkingSpace.put(this, i);
				return reservationParkingSpace;
			}
		}
		return reservationParkingSpace;
	}

}
