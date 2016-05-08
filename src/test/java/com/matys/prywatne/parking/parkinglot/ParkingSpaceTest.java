package com.matys.prywatne.parking.parkinglot;

import  static org.assertj.core.api.Assertions.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParkingSpaceTest {
	
	static ParkingSpace ps;
	static Car car;
	
	@BeforeMethod
	public static void beforeMethod() {
		ps = new ParkingSpace();
		car = new Car();
	}

	@Test
	public static void testTakeAParkingSpace() {
		//given
		//when
		boolean park = ps.takeAParkingSpace(1, car);
		//then
		assertThat(park).isTrue();
	}
	
	@Test
	public static void testReturnNumberOfOccupiedParkingSpaceReturn2() {
		//given
		ps.takeAParkingSpace(1, car);
		ps.takeAParkingSpace(2, car);
		int twoOccupiedParkingSpace = 2;
		//when
		int occupiedParkingSpace = ps.numberOfOccupiedParkingSpace();	
		//then
		assertThat(twoOccupiedParkingSpace).isEqualTo(occupiedParkingSpace);
	}
	
	@Test
	public static void testReleaseParkingSpaceReturnTrue() {
		//given
		ps.takeAParkingSpace(1, car);
		
		//when
		boolean releaseParkingSpace = ps.releaseParkingSpace(1, car);
		
		//then
		assertThat(releaseParkingSpace).isTrue();
	}
	
	@Test
	public static void testReleaseParkingSpaceReturnFalse() {
		//given
		ps.takeAParkingSpace(1, car);
		
		//when
		boolean releaseParkingSpace = ps.releaseParkingSpace(2, car);
		
		//then
		assertThat(releaseParkingSpace).isFalse();
	}
}
