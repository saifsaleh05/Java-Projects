/*
Name: Saifeddin Saleh
Id: 1231474
Lab section#: 3
Lecture section#: 2
*/
package project;
import java.util.*;
public class Department{
	private String departmentId;
	private String name;
	private ArrayList<Doctor> doctors;
	private ArrayList<PatientBase> patientBase;
	public Department(String departmentId, String name) {
		setDepartmentId(departmentId);
		setName(name);
		doctors = new ArrayList<Doctor>();
		patientBase = new ArrayList<PatientBase>();
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId){
		this.departmentId = departmentId;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public ArrayList<Doctor> getDoctors(){
		return doctors;
	}
	public void setDoctors(ArrayList<Doctor> doctors){
		this.doctors = new ArrayList<Doctor>(doctors);
	}
	public ArrayList<PatientBase> getPatientBase(){
		return patientBase;
	}
	public void setPatientBase(ArrayList<PatientBase> patientBase){
		this.patientBase = new ArrayList<PatientBase>(patientBase);
	}
	public void addDoctor(Doctor doctor){
		doctors.add(doctor);
	}
	public void addPatient(PatientBase Patient){
		patientBase.add(Patient);
	}
	public String toString(){
		return "Department Id: "+getDepartmentId()+" Department Name: "+getName()+" Number of Doctors: "+getDoctors().size()+" Number of Patients: "+getPatientBase().size();
	}
}
