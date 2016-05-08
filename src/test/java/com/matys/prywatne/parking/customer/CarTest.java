package com.matys.prywatne.parking.customer;

import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

import com.matys.prywatne.parking.customer.Car;

public class CarTest {

	@Test
	public static void testTwoCarAreEqual() {
		// given
		Car firstCar = new Car("audi");
		Car secondCar = new Car("audi");
		// when
		boolean equal = firstCar.equals(secondCar);
		// then
		assertThat(equal).isTrue();
	}
	
	@Test
	public static void testTwoCarAreNotEqual() {
		// given
		Car firstCar = new Car("audi");
		Car secondCar = new Car("bmw");
		// when
		boolean equal = firstCar.equals(secondCar);
		// then
		assertThat(equal).isFalse();
	}
	
	
}
