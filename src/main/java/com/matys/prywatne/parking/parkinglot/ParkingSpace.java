package com.matys.prywatne.parking.parkinglot;

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

	public synchronized Integer firstFreeParkingSpace(int maxParkingSpace) {
		Integer allParkingSpaceIsOccupied = -1;
		for (int i = 0; i < maxParkingSpace; i++) {
			if(concurrentMap.get(i) == null) {
				//rezerwacja miejsca
				concurrentMap.put(i, new Car());
				return i;
			}
		}
		return allParkingSpaceIsOccupied;
	}

}
