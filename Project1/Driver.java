/*
Name: Saifeddin Saleh
Id: 1231474
Lab section#: 3
Lecture section#: 2
*/
package project;
import java.util.*;
public class Driver {
	public static void main(String[] args) {
		Department[] departments = new Department[3];
		departments[0] = new Department("1", "Emergency");
		departments[1] = new Department("2", "ICU");
		departments[2] = new Department("3", "Child Care Department");
		ArrayList<PatientBase> patients = new ArrayList<PatientBase>();
		patients.add(new EmergencyPatient("1234", "Saif",25, "ADHD", departments[0], 2423.55));
		patients.add(new EmergencyPatient("1111", "Omar", 19, "Cancer", departments[1], 4500.99));
		patients.add(new LongTermPatient("3333", "Saleh", 11, "Diabetes", departments[2], 8, 130.0));
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		doctors.add(new Doctor("4422", "Ali", "Neuro surgeon", "PhD", 25000.0, 40.5, 250.0, departments[1]));
		doctors.add(new Doctor("5245", "Ameer", "Orthopedic Surgeon", "PhD", 22000.0, 22.0, 150.0, departments[1]));
		ArrayList<HospitalService> hospitalServices = new ArrayList<HospitalService>();
		hospitalServices.add(new HospitalService("Blood Test", 120.0, patients.get(0)));
		hospitalServices.add(new HospitalService("Heart Surgery", 7800.0, patients.get(1)));
		hospitalServices.add(new HospitalService("Vaccine", 70.0, patients.get(2)));
		hospitalServices.add(new HospitalService("Blood Test", 120.0, patients.get(2)));
		patients.get(0).getServices().add(hospitalServices.get(0));
        patients.get(1).getServices().add(hospitalServices.get(1));
        patients.get(2).getServices().add(hospitalServices.get(2));
        patients.get(2).getServices().add(hospitalServices.get(3));
        generateBill(patients.get(2));
		Collections.sort(patients);
		sortDoctorsBySalary(doctors);
		System.out.println("----------------------------------------");
		System.out.println("Sorted patients names and age:");
		for(PatientBase patient:patients) {
			System.out.println("|Patient Name: "+patient.getName()+" Age: "+patient.getAge()+"|");
		}
		System.out.println("----------------------------------------");
		System.out.printf("|The total patient's bill is: $%.2f|\n", calculateTotalpatientsBill(patients));
		System.out.println("----------------------------------------");
		
	}
	public static void sortDoctorsBySalary(ArrayList<Doctor> doctors) {
		Collections.sort(doctors);
		for(Doctor doctor: doctors) {
			System.out.println("----------------------------------------");
			System.out.println(doctor);
			System.out.println("----------------------------------------");
		}
	}
	public static double calculateTotalpatientsBill(ArrayList<PatientBase> patients) {
		double bill = 0;
		for(PatientBase patient: patients) {
			bill += patient.calculateBill();
		}
		return bill;
	}
	public static void generateBill(PatientBase patient) { 
		System.out.println("--------------------------------------");
		System.out.println("|The third patient's bill is: "+patient.calculateBill()+"|");
		System.out.println("--------------------------------------");
	}
}
