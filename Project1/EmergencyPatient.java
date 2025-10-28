/*
Name: Saifeddin Saleh
Id: 1231474
Lab section#: 3
Lecture section#: 2
*/
package project;
public class EmergencyPatient extends PatientBase{
	private double emergencyFee;
	public EmergencyPatient(String patientId, String name, int age, String medicalHistory, Department department, double emergencyFee){
		super(patientId, name, age, medicalHistory, department);
		setEmergencyFee(emergencyFee);
	}
	public double getEmergencyFee(){
		return emergencyFee;
	}
	public void setEmergencyFee(double emergencyFee){
		if(emergencyFee<0) System.out.println("Invalid input");
		this.emergencyFee = emergencyFee;
	}
	public double calculateBill(){
		double bill = 0;
		for(HospitalService service : getServices()){
			bill += service.getServiceCost();
		}
		return getEmergencyFee()+bill*(1+TAX_RATE);
	}
	public String toString() {
		return super.toString()+" Emergency fee: "+getEmergencyFee();
	}
}
