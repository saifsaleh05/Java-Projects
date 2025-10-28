/*
Name: Saifeddin Saleh
Id: 1231474
Lab section#: 3
Lecture section#: 2
*/
package project;
public class HospitalService{
	private String serviceName;
	private double serviceCost;
	private PatientBase patient;
	public HospitalService(String serviceName, double serviceCost, PatientBase patient){
		setServiceName(serviceName);
		setServiceCost(serviceCost);
		setPatient(patient);
	}
	public String getServiceName(){
		return serviceName;
	}
	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}
	public double getServiceCost(){
		return serviceCost;
	}
	public void setServiceCost(double serviceCost){
		if(serviceCost<0) System.out.println("Invalid input");
		this.serviceCost = serviceCost;
	}
	public PatientBase getPatient(){
		return patient;
	}
	public void setPatient(PatientBase patient){
		this.patient = patient;
	}
	public String toString(){
		return "Service Name: "+getServiceName()+" Service Cost: "+getServiceCost();
	}
}
