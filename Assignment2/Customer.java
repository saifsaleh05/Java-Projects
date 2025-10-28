/*
 * Name: Saifeddin Saleh
 * ID: 1231474
 * Lab section: 3
 * Lecture section: 2
 */
package Assignment2;
public class Customer {
	private String name;
	private int id;
	private String licenseNumber;
	private int numberOfCurrentRented;
	private Vehicle[] vehiclesRented;
	private int maxVehicles;
	public Customer() {

	}
	public Customer(String name, int id, String licenseNumber, int maxVehicles) {
		this.name = name;
		this.id = id;
		this.licenseNumber = licenseNumber;
		this.maxVehicles = maxVehicles;
		numberOfCurrentRented = 0;
		this.vehiclesRented = new Vehicle[maxVehicles];
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setNumberOfCurrentRented(int numberOfCurrentRented) {
		this.numberOfCurrentRented = numberOfCurrentRented;
	}
	public int getNumberOfCurrentRented() {
		return numberOfCurrentRented;
	}
	public void setMaxVehicles(int maxVehicles) {
		this.maxVehicles = maxVehicles;
		}
	public int getMaxVehicles() {
		return maxVehicles;
	}
	public void setVehiclesRented(Vehicle[] vehiclesRented) {
		this.vehiclesRented = vehiclesRented;
	}
	public Vehicle[] getVehiclesRented() {
		return vehiclesRented;
	}
	public void rentVehicle(Vehicle vehicle, int days) {
		vehiclesRented[numberOfCurrentRented] = vehicle;
		vehiclesRented[numberOfCurrentRented].setAvailable(false);
		vehiclesRented[numberOfCurrentRented].setRentDays(days);
		System.out.println("Vehicle rented successfully.");
		numberOfCurrentRented++;
	}
	public void reternVehicle(Vehicle vehicle) {
		vehicle.setAvailable(true);
		numberOfCurrentRented--;
		System.out.printf("Vehicle %s returned successfully.\n", vehicle.getRegistrationNumber());
	}
	public double calculateRent() {
		double rent = 0;
		for(int i=0;i<numberOfCurrentRented;i++) {
			rent += (vehiclesRented[i].getRentalRatePerDay())*(vehiclesRented[i].getRentDays());
		}
		return rent;
	}
	public double calculateRent(String type) {
		double rent = 0;
		for(int i=0;i<numberOfCurrentRented;i++) {
			if(vehiclesRented[i].getType().equals(type)){
				rent = vehiclesRented[i].getRentalRatePerDay()*vehiclesRented[i].getRentDays();
			}
		}
		return rent;
	}
	public int countVehiclesByType(String type) {
		int count = 0;
		for(int i=0;i<numberOfCurrentRented;i++) {
			if(type.equals(vehiclesRented[i].getType())) {
				count++;
			}
		}
		return count;
	}
	public void printInfo() {
		System.out.println("Customer Information:");
		System.out.println("Name: "+getName());
		System.out.println("ID: "+getId());
		System.out.println("License Number: "+getLicenseNumber());
		if(numberOfCurrentRented==0) {
			System.out.println("No vehicles rented currently");
			return;
		}
		else {
		System.out.println("Vehicles rented:");
		for(int i=0;i<numberOfCurrentRented;i++) {
			String vehicleCode = vehiclesRented[i].getType().concat(vehiclesRented[i].getRegistrationNumber());
			System.out.printf("\t- Vehicle Code: %s, Type: %s, Brand: %s, Daily Rate: $%.1f\n", vehicleCode, vehiclesRented[i].getType(), vehiclesRented[i].getBrand(), vehiclesRented[i].getRentalRatePerDay());
		}
		}
	}
	
	public void printRentedVehicles() {
		for(int i=0;i<numberOfCurrentRented;i++) {
			String vehicleCode = vehiclesRented[i].getType().concat(vehiclesRented[i].getRegistrationNumber());
			System.out.printf("\t- Vehicle Code: %s, Type: %s, Brand: %s, Daily Rate: %.1f\n", vehicleCode, vehiclesRented[i].getType(), vehiclesRented[i].getBrand(), vehiclesRented[i].getRentalRatePerDay());
		}
	}
}
