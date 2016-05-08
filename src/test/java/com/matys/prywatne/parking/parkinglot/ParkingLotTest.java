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

}
