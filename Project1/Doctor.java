/*
Name: Saifeddin Saleh
Id: 1231474
Lab section#: 3
Lecture section#: 2
*/
package project;
public class Doctor implements Comparable<Doctor>{
	private String doctorId;
	private String name;
	private String specialty;
	private String degree;
	private double baseSalary;
	private double overtimeHours;
	private double overtimeRate;
	private Department department;
	public Doctor(String doctorId, String name, String specialty, String degree, double baseSalary, double overtimeHours, double overtimeRate, Department department){
		setDoctorId(doctorId);
		setName(name);
		setSpecialty(specialty);
		setDegree(degree);
		setBaseSalary(baseSalary);
		setOvertimeHours(overtimeHours);
		setOvertimeRate(overtimeRate);
		setDepartment(department);
	}
	public String getDoctorId(){
		return doctorId;
	}
	public void setDoctorId(String doctorId){
		this.doctorId = doctorId;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getSpecialty(){
		return specialty;
	}
	public void setSpecialty(String specialty){
		this.specialty = specialty;
	}
	public String getDegree(){
		return degree;
	}
	public void setDegree(String degree){
		this.degree = degree;
	}
	public double getBaseSalary(){
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary){
		this.baseSalary = baseSalary;
	}
	public double getOvertimeHours(){
		return overtimeHours;
	}
	public void setOvertimeHours(double overtimeHours){
		this.overtimeHours = overtimeHours;
	}
	public double getOvertimeRate(){
		return overtimeRate;
	}
	public void setOvertimeRate(double overtimeRate){
		this.overtimeRate = overtimeRate;
	}
	public Department getDepartment(){
		return department;
	}
	public void setDepartment(Department department){
		this.department = department;
	}
	public double calculateSalary(){
		if(getDegree().equalsIgnoreCase("bachelor")){
			return (getBaseSalary()*0.1)+getBaseSalary()+calculateOvertimePay();
		}
		if(getDegree().equalsIgnoreCase("master")){
			return (getBaseSalary()*0.2)+getBaseSalary()+calculateOvertimePay();
		}
		return (getBaseSalary()*0.3)+getBaseSalary()+calculateOvertimePay();
	}
	public double calculateOvertimePay(){
		return (getOvertimeHours()*getOvertimeRate());
	}
	public String toString(){
		return "Doctor Id: "+getDoctorId()+" Name: "+getName()+" Specialty: "+getSpecialty()+" Degree: "+getDegree()+" Department name: "+department.getName()+" Department Id: "+department.getDepartmentId()+" Base Salary: "+getBaseSalary()+" Overtime Hours: "+getOvertimeHours()+" Overtime Rate: $"+getOvertimeRate()+" Salary: $"+calculateSalary()+" Overtime Pay: $"+calculateOvertimePay();
	}
	public int compareTo(Doctor x){
		double salary = calculateSalary()-x.calculateSalary();
		if(salary>0) return -1;
		else if(salary<0) return 1;
		else return 0;
	}
}
