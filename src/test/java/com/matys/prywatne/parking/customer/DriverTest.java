package com.matys.prywatne.parking.customer;

import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.matys.prywatne.parking.parkinglot.ParkingLot;
import com.matys.prywatne.parking.parkingservice.Valet;

public class DriverTest {

	static Valet valet;
	static Driver driver;
	static Car car;

	@BeforeMethod
	public static void prepareMethod() {
		car = new Car("audi");
		valet = new Valet(ParkingLot.createParkingLot(50));
		driver = new Driver(car);
	}

	@Test
	public static void testAskValetForAvailablePlaceReturnTrue() {
		// given
		// when
		boolean availableSpace = driver.askValetForAvailableSpace(valet);
		// then
		assertThat(availableSpace).isTrue();
	}

	@Test
	public static void testAskValetForIdParkingSpaceWhichIsFree() {
		// given
		Integer zero = new Integer(0);
		// when
		Integer idFreeParkingPlace = driver.askValetForIdParkingSpace(valet);
		// then
		assertThat(zero).isEqualTo(idFreeParkingPlace);
	}

	@Test
	public static void testAskValetForParkCar() {
		// given
		Integer idFreeParkingPlace = driver.askValetForIdParkingSpace(valet);
		// when
		boolean park = driver.askValetForParkCar(valet, idFreeParkingPlace);
		// then
		assertThat(park).isTrue();
	}

	@Test
	public static void testTellValetYouLeaveParkingLot() {
		// given
		Integer idFreeParkingPlace = driver.askValetForIdParkingSpace(valet);
		driver.askValetForParkCar(valet, idFreeParkingPlace);
		// when
		boolean park = driver.leaveParkingLot(valet, idFreeParkingPlace);
		// then
		assertThat(park).isTrue();
	}

}
