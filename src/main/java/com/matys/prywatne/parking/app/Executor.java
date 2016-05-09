package com.matys.prywatne.parking.app;

import java.util.Queue;

import com.matys.prywatne.parking.customer.Driver;
import com.matys.prywatne.parking.parkingservice.Valet;

public class Executor implements Runnable {

	Queue<Driver> driverQueue;
	Valet valet;

	public Executor(Queue<Driver> driverQueue, Valet valet) {
		this.driverQueue = driverQueue;
		this.valet = valet;
	}

	@Override
	public void run() {
		while (true) {
			if (driverQueue.isEmpty()) {
				break;
			}
			Driver driver = driverQueue.poll();
			if (driver != null) {
				boolean park = false;
				int numberOfTryingPark = 2;
				System.out.println("Kierowca przyjeżdża na parking samochodem: " + driver);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0; i < numberOfTryingPark; i++) {
					if (driver.askValetForAvailableSpace(valet)) {
						Integer freeSpace = driver.askValetForIdParkingSpace(valet);
						if (freeSpace != -1) {
							if (driver.askValetForParkCar(valet, freeSpace)) {
								System.out.println(
										"Kierowca zaparkował samochód: " + driver + " na miejscu " + freeSpace);
								try {
									int parkTime = (int) (Math.random() * 10);
									Thread.sleep(parkTime);
									System.out.println("Kierowca: " + driver + " był na parkingu na miejscu: "
											+ freeSpace + " " + " przez " + (parkTime / 1000) + " sekund");
									park = true;
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								driver.leaveParkingLot(valet, freeSpace);
								break;
							}
						}
					}

					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (!park) {
					System.out.println("Kierowca: " + driver + " wyjeżdża z parkingu BEZ PARKOWANIA!");
				}

				System.out.println("Aktualna ilosc miejsc: " + valet.ilsscMiejsc());
			}
		}
		System.out.println("Zakończyłem swoją pracę! :)");
	}
}
