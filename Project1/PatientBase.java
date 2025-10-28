/*
Name: Saifeddin Saleh
Id: 1231474
Lab section#: 3
Lecture section#: 2
*/
package project;
import java.util.*;
public abstract class PatientBase implements Comparable<PatientBase> ,Billable{
	private String patientId;
	private String name;
	private int age;
	private String medicalHistory;
	private Department department;
	private	ArrayList<HospitalService> services;
	public PatientBase(String patientId, String name, int age, String medicalHistory, Department department){
		setPatientId(patientId);
		setName(name);
		setAge(age);
		setMedicalHistory(medicalHistory);
		setDepartment(department);
		services = new ArrayList<HospitalService>();
	}
	public String getPatientId(){
		return patientId;
	}
	public void setPatientId(String patientId){
		this.patientId = patientId;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		if(age<0) {
			System.out.println("Invalid age input");
		}
		this.age = age;
	}
	public String getMedicalHistory(){
		return medicalHistory;
	}
	public void setMedicalHistory(String medicalHistory){
		this.medicalHistory = medicalHistory;
	}
	public Department getDepartment(){
		return department;
	}
	public void setDepartment(Department department){
		this.department = department;
	}
	public ArrayList<HospitalService> getServices(){
		return services;
	}
	public void setServices(ArrayList<HospitalService> services){
		this.services = new ArrayList<HospitalService>(services);
	}
	public abstract double calculateBill();
	public String toString(){
		return "Patient Id: "+getPatientId()+" Name: "+getName()+" Age: "+getAge()+" Medical History: "+getMedicalHistory()+" Department: "+department.getName()+" Services: "+getServices()+" Bill: "+calculateBill();
	}
	public int compareTo(PatientBase p){
		double x = calculateBill() - p.calculateBill();
		if(x<0) return -1;
		else if(x>0) return 1;
		else return 0;
	}
}
