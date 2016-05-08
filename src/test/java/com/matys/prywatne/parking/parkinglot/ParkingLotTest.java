package com.matys.prywatne.parking.parkinglot;

import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParkingLotTest {

	@DataProvider(name = "correctParkingSpace")
	public Object[][] prepareTestCreateParkingLotWithSpecifiedParkingSpace() {
		return new Object[][] { { 50 }, { 40 }, { 60 }, { 5 } };
	}

	@Test(dataProvider = "correctParkingSpace")
	public static void createParkingLotWithSpecifiedParkingSpace(int parkingSpace) {
		// given
		ParkingLot pl = null;
		// when
		pl = ParkingLot.createParkingLot(parkingSpace);
		int result = pl.maxParkingSpace;
		// then
		assertThat(parkingSpace).isEqualTo(result);
	}

	@DataProvider(name = "incorrectParkingSpace")
	public Object[][] prepareTestCreateParkingLotThrowsExeception() {
		return new Object[][] { { -50 }, { 0 }, { -2 }, { -5 } };
	}

	@Test(dataProvider = "incorrectParkingSpace")
	public static void createParkingLotThrowsExecption(int parkingSpace) {
		// given
		ParkingLot pl = null;
		// when
		try {
			pl = ParkingLot.createParkingLot(parkingSpace);
			failBecauseExceptionWasNotThrown(IllegalArgumentException.class);
		} catch (IllegalArgumentException e) {
			// then
			assertThatExceptionOfType(e.getClass()).isThrownBy(() -> {
				throw new IllegalArgumentException();
			});
		}
	}

	@DataProvider(name = "availableParkingSpace")
	public Object[][] prepareTestIsAvailableParkingSpace() {
		return new Object[][] { { 10, 5 }, { 3, 2 }, { 6, 4 } };
	}

	@Test(dataProvider = "availableParkingSpace")
	public static void testIsAvailableParkingSpace(int parkingSpace, int numberOfCarsOnParkingLot) {
		// given
		ParkingLot pl = ParkingLot.createParkingLot(parkingSpace);
		for (int i = 0; i < numberOfCarsOnParkingLot; i++) {
			pl.takeAParkingSpace(i, new Car());
		}
		// when
		boolean availableParkingSpace = pl.isAvailableParkingSpace();
		// then
		assertThat(availableParkingSpace).isTrue();
	}
	
	@DataProvider(name = "unavailableParkingSpace")
	public Object[][] prepareTestUnavailableParkingSpace() {
		return new Object[][] { { 10, 10 }, { 1, 2 }, { 6, 6 } };
	}

	@Test(dataProvider = "unavailableParkingSpace")
	public static void testUnavailableParkingSpace(int parkingSpace, int numberOfCarsOnParkingLot) {
		// given
		ParkingLot pl = ParkingLot.createParkingLot(parkingSpace);
		for (int i = 0; i < numberOfCarsOnParkingLot; i++) {
			pl.takeAParkingSpace(i, new Car());
		}
		// when
		boolean availableParkingSpace = pl.isAvailableParkingSpace();
		// then
		assertThat(availableParkingSpace).isFalse();
	}

}
