package com.aurionpro.project.test;

import com.aurionpro.project.model.Car;
import com.aurionpro.project.model.ElectricCar;
import com.aurionpro.project.model.Vehicle;

public class VehicleTest {
	public static void main(String[] args) {
		Vehicle vehile1 = new Vehicle("Mercedes-Benz", "C-Class", 100);
		Vehicle vehile2 = new Vehicle("Audi", "A4", 150);
		vehile1.displayInfo();
		vehile1.accelerate();
		vehile1.brake();
		System.out.println("\n------------------------------------------------------------------------");

		Car car = new Car("Rolls-Royce","Ghost",330,"Petrol", 4) ;
		car.displayInfo();
		car.accelerate();
		car.brake();
		
		System.out.println("\n-----------------------------------------------------------------------");
		ElectricCar eCar = new ElectricCar("Tesla","CyberTruck",200,"Electric",5,75,2);
		eCar.displayInfo();
		eCar.accelerate();
		eCar.brake();

	}
}
