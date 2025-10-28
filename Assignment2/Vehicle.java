/*
 * Name: Saifeddin Saleh
 * ID: 1231474
 * Lab section: 3
 * Lecture section: 2
 */
package Assignment2;
public class Vehicle {
	private String type;
	private String registrationNumber;
	private String brand;
	private double rentalRatePerDay;
	private int rentDays;
	private boolean available;
	public Vehicle() {
		
	}
	public Vehicle(String type, String registrationNumber, String brand, double rentalRatePerDay, boolean available) {
		this.type = type;
		this.registrationNumber = registrationNumber;
		this.brand = brand;
		this.rentalRatePerDay = rentalRatePerDay;
		this.available = available;
	}
	public void printInfo() {
		System.out.printf("%s (Registration: %s), %s - $%.1f/day\n", type, registrationNumber, brand, rentalRatePerDay);
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return brand;
	}
	public void setRentalRatePerDay(double rentalRatePerDay) {
		this.rentalRatePerDay = rentalRatePerDay;
	}
	public double getRentalRatePerDay() {
		return rentalRatePerDay;
	}
	public void setRentDays(int rentDays) {
		this.rentDays = rentDays;
	}
	public int getRentDays() {
		return rentDays;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public boolean getAvailable() {
		return available;
	}
}


