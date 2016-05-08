package com.matys.prywatne.parking.parkingservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.matys.prywatne.parking.customer.Car;
import com.matys.prywatne.parking.parkinglot.ParkingLot;

public class ValetTest {
	
	static ParkingLot parkingLot;
	static Valet valet;
	
	@BeforeMethod
	public static void prepareMethod() {
		parkingLot = ParkingLot.createParkingLot(50);
		valet = new Valet(parkingLot);
	}

	@Test
	public static void testIsAvailableParkingSpaceOnParkingLot() {
		//given
		//when
		boolean availablePlace = valet.checkAvailablePlace();
		//then
		assertThat(availablePlace).isTrue();
	}
	
	@Test
	public static void testPointToTheFirstFreeSpaceReturn0() {
		//given
		Integer zero = 0;
		//when
		Integer firstFreeSpace = valet.pointToTheFirstFreeSpace();
		//then
		assertThat(zero).isEqualTo(firstFreeSpace);
	}
	
	@Test
	public static void testIfTakeParkingPlaceAndReleaseItWillBeFree() {
		//given
		Car car = new Car();
		Integer one = 1;
		parkingLot.takeAParkingSpace(0, car);
		parkingLot.takeAParkingSpace(one, car);
		parkingLot.releaseAParkingSpace(one, car);
		
		//when
		Integer firstFreeSpace = valet.pointToTheFirstFreeSpace();
		//then
		assertThat(one).isEqualTo(firstFreeSpace);
	}
}
