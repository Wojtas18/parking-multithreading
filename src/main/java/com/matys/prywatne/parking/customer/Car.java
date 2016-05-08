package com.matys.prywatne.parking.customer;

public class Car {

	private String carName;

	public Car(String carName) {
		this.carName = carName;
	}

	public Car() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carName == null) ? 0 : carName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Car))
			return false;
		Car other = (Car) obj;
		if (carName == null) {
			if (other.carName != null)
				return false;
		} else if (!carName.equals(other.carName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return carName;
	}

}
