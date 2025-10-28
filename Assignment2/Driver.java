/*
 * Name: Saifeddin Saleh
 * ID: 1231474
 * Lab section: 3
 * Lecture section: 2
 */
package Assignment2;
import java.util.*;
public class Driver {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Vehicle[] availableVehicles = {
			new Vehicle("Car", "ABC123", "Toyota", 50.0, true),
			new Vehicle("Bike", "DEF456", "Honda", 20.0, true),
			new Vehicle("Truck", "GHI789", "Ford", 80.0, true),
			new Vehicle("Car", "JKL012", "Hyundai", 55.0, true),
			new Vehicle("Bike", "MNO345", "Yamaha", 25.0, true)
		};
		System.out.println("Enter number of customers: ");
		int n = scan.nextInt();
		scan.nextLine();
		Customer[] customer = new Customer[n];
		for(int i=0;i<n;i++) {
			System.out.println("Enter details for customer "+(i+1)+":");
			System.out.print("Enter name: ");
			String name = scan.nextLine();
			System.out.print("Enter ID: ");
			int id = scan.nextInt();
			scan.nextLine();
			System.out.print("Enter license number: ");
			String license = scan.next();
			System.out.print("Enter Maximum number of vehicles can rent by this customer:");
			int maxnumber = scan.nextInt();
			System.out.print("Enter the number of vehicles to rent now: ");
			int rentnow = scan.nextInt();
			scan.nextLine();
			customer[i] = new Customer(name, id, license, maxnumber);
			if(rentnow==0) {
			continue;
			}
			System.out.println("Available vehicles for rental: ");
			for(int j=0; j<availableVehicles.length;j++) {
				if(availableVehicles[j].getAvailable()) {
					System.out.print(j+1+". ");
					availableVehicles[j].printInfo();
				}
			}
			for(int k=0;k<rentnow;k++) {
				System.out.println("Enter registration number of vehicle "+(k+1)+" to rent or type exit to stop:");
				String regnum = scan.next();
				if(regnum.equals("exit")) return;
				
				Vehicle vehicle = findVehicleByRegistrationNumber(availableVehicles, regnum);
				if(vehicle!=null) {
					System.out.println("Enter rental days: ");
					int rentdays = scan.nextInt();
					scan.nextLine();
					customer[i].rentVehicle(vehicle, rentdays);
				}
			}
		}
		
		int v=0;
		while(v!=1) {
		System.out.println("Main Menu:");
		System.out.println("1: Print Customer Information");
		System.out.println("2: Display Total Rental Cost for a Customer");
		System.out.println("3: Count Rented Vehicles by Type");
		System.out.println("4: Rent a New Vehicle");
		System.out.println("5: Return a Vehicle");
		System.out.println("6: Display All Available Vehicles in Ascending Order of Price");
		System.out.println("7: Display All Available Vehicles in Alphabetical Order of Type");
		System.out.println("8: Exit");
		System.out.println("Enter your choice:");
		int choice = scan.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Enter customer ID:");
				int customerID = scan.nextInt();
					Customer c = findCustomerById(customer,customerID);
					if(c!=null) {
						c.printInfo();
						break;
					}
					else {
						System.out.println("Customer not found");
					}
				break;
			case 2:
				System.out.println("Enter customer ID:");
				int cID = scan.nextInt();
				Customer cc = findCustomerById(customer,cID);
					if(cc!=null) {
						System.out.printf("Total Rental Cost for %s: $%.1f\n", cc.getName(), cc.calculateRent());
						break;
					}
					else {
						System.out.println("Customer not found");
					}
				break;
			case 3:
				System.out.println("Enter customer ID:");
				int ccID = scan.nextInt();
				Customer ccc = findCustomerById(customer,ccID);
					if(ccc!=null) {
						System.out.println("Enter vehicle type to count (e.g., Car, Bike):");
						String V = scan.next();
						System.out.printf("Number of %s(s) rented by %s: %d\n", V, ccc.getName(), ccc.countVehiclesByType(V));
						break;
					}
					else {
						System.out.println("Customer not found");
					}
				
				break;
			case 4:
				System.out.println("Enter customer ID:");
				int cccID = scan.nextInt();
				Customer cU = findCustomerById(customer,cccID);
					if(cU!=null) {
						if(cU.getMaxVehicles()<=cU.getNumberOfCurrentRented()) {
							System.out.println("You have reached your rental limit!");
							break;
						}
						System.out.println("Enter the type of vehicle to rent (e.g., Car, Bike):");
						String R = scan.next();
							int count = 0;
							for(int g=0;g<availableVehicles.length;g++) {
								if(availableVehicles[g].getType().equals(R)) {
									count++;
								}
							}
							if(count==0) {
								System.out.println("There are no available vehicles of type "+R);
								break;
							}
							else {	
							System.out.printf("Available vehicles of type '%s':\n", R);
							for(int j=0;j<availableVehicles.length;j++) {
								if(R.equals(availableVehicles[j].getType()) && availableVehicles[j].getAvailable()==true) {
									System.out.printf("%d. (Registration: %s), %s - $%.1f/day\n",(j+1) ,availableVehicles[j].getRegistrationNumber(), availableVehicles[j].getBrand(), availableVehicles[j].getRentalRatePerDay());									
								}
							}
							System.out.println("Enter registration number of the vehicle to rent:");
							String reg = scan.next();
							Vehicle vec = findVehicleByRegistrationNumber(availableVehicles, reg);
							if(vec!=null) {
								System.out.println("Enter rental days:");
								int rentaldays = scan.nextInt();
								cU.rentVehicle(vec, rentaldays);	
							}
						
						
						break;
					}
					
				}
					else {
						System.out.println("Customer not found");
					}
				break;
			case 5:
				System.out.println("Enter customer ID:");
				int ccccID = scan.nextInt();
				Customer d = findCustomerById(customer,ccccID);
					if(d!=null) {
						System.out.println("List of vehicles currently rented:");
							d.printRentedVehicles();
						System.out.println("Enter registration number of the vehicle to return:");
						String returnReg = scan.next();
						Vehicle returnV = findVehicleToReturn(d.getVehiclesRented(), returnReg);
						if(returnV!=null) {
							d.reternVehicle(returnV);
							break;
						}
					}
				
				break;
			case 6:
				displayVehiclesByPrice(availableVehicles);
				break;
			case 7:
				displayVehiclesByType(availableVehicles);
				break;
			case 8:
				System.out.println("Goodbye");
				v=1;
				break;
			default:
				System.out.println("Invalid input");
		}
		
	}
		

	}
	public static Customer findCustomerById(Customer[] customers, int customerId) {
		for(int i=0;i<customers.length;i++) {
			if(customers[i].getId()==customerId) {
				return customers[i];
			}
		}
		return null;
	}
	
	public static Vehicle findVehicleByRegistrationNumber(Vehicle[] vehicles, String regNumber) {
	    while (!regNumber.equals("exit")) {
	        boolean x =false;
	        for (int i=0;i<vehicles.length;i++) {
	            if (vehicles[i].getRegistrationNumber().equals(regNumber)) {
	                if (vehicles[i].getAvailable()) {
	                    return vehicles[i];
	                } 
	                else {
	                    System.out.println("Vehicle not available, please choose another.");
	                    x= true;
	                    break;
	                }
	            }
	        }
	        if (!x) {
	            System.out.println("Vehicle not found. Please enter a valid registration number.");
	        }
	        regNumber = scan.next();
	    }
	    return null;
	}
	
	public static Vehicle findVehicleToReturn(Vehicle[] vehicles, String regNumber) {
		boolean x = false;
		for(int i=0;i<vehicles.length;i++) {
			if(vehicles[i].getRegistrationNumber().equals(regNumber)) { 
				x = true;
				return vehicles[i];
			}
		}
		if(!x) {
			System.out.println("Invalid registration number!");
		}
		return null;
	}

	public static void displayVehiclesByPrice(Vehicle[] vehicles) {
		System.out.println("Available Vehicles Sorted by Rental Rate:");
		for(int i=0;i<vehicles.length-1;i++) {
			for(int j=i;j<vehicles.length;j++) {
				if(vehicles[j].getRentalRatePerDay()>vehicles[i].getRentalRatePerDay()) {
					Vehicle tmp = vehicles[j];
					vehicles[j] = vehicles[i];
					vehicles[i] = tmp;
				}
			}
		}
		for(int k=0;k<vehicles.length;k++) {
			if(vehicles[k].getAvailable())
			System.out.printf("%d. %s (Registration: %s), %s - $%.1f/day\n", (k+1),vehicles[k].getType() ,vehicles[k].getRegistrationNumber(), vehicles[k].getBrand(), vehicles[k].getRentalRatePerDay());
		}
	}
	
	public static void displayVehiclesByType(Vehicle[] vehicles) {
		for(int i=0;i<(vehicles.length-1);i++) {
			for(int k=i;k<vehicles.length;k++) {
			if(vehicles[k].getType().compareTo(vehicles[i].getType())<0) {
				Vehicle tmp = vehicles[k];
				vehicles[k] = vehicles[i];
				vehicles[i] = tmp;
			}
			}
		}
		for(int j=0;j<vehicles.length;j++) {
			if(vehicles[j].getAvailable()) {
				System.out.printf("%d. %s (Registration: %s), %s - $%.1f/day\n", (j+1),vehicles[j].getType() ,vehicles[j].getRegistrationNumber(), vehicles[j].getBrand(), vehicles[j].getRentalRatePerDay());
			}
		}
	}
}
