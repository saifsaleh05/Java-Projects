/*
Name: Saifeddin Saleh
Id: 1231474
Lab section#: 3
Lecture section#: 2
*/
package project;
public class LongTermPatient extends PatientBase{
	private int daysAdmitted;
	private double dailyRate;
	public LongTermPatient(String patientId, String name, int age, String medicalHistory, Department department, int daysAdmitted, double dailyRate){
		super(patientId, name, age, medicalHistory, department);
		setDaysAdmitted(daysAdmitted);
		setDailyRate(dailyRate);
	}
	public int getDaysAdmitted(){
		return daysAdmitted;
	}
	public void setDaysAdmitted(int daysAdmitted){
		if(daysAdmitted<0) System.out.println("Invalid input");
		this.daysAdmitted = daysAdmitted;
	}
	public double getDailyRate(){
		return dailyRate;
	}
	public void setDailyRate(double dailyRate){
		if(dailyRate<0) System.out.println("Invalid input");
		this.dailyRate = dailyRate;
	}
	public double calculateBill(){
		double bill = 0;
		for(HospitalService service : getServices()){
			bill += service.getServiceCost();
		}
		return (((getDaysAdmitted()*getDailyRate())+bill)*(1+TAX_RATE));
	}
	public String toString() {
		return super.toString()+" Days Admitted: "+getDaysAdmitted()+" Daily Rate: "+getDailyRate();
	}
}
