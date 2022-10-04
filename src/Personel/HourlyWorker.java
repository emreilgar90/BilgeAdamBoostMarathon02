package Personel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HourlyWorker extends Employee implements Workable {
	private static final long serialVersionUID = 3145096547693120359L;
	private List<Integer> workHours = new ArrayList<>();
	private int hourlyWage;
	

	public HourlyWorker(String name, String surname, LocalDate startDate, LocalDate endDate, List<Integer> workHours,
			int hourlyWage) {
		super(name, surname, startDate, endDate);
		this.workHours = workHours;
		this.hourlyWage = hourlyWage;
		calcSalary();
	}


	@Override
	public void calcSalary() {
		super.setSalary(this.totalWorkHours(this.getWorkHours())*this.hourlyWage*1.08);
	}
	
	public double totalWorkHours(List<Integer> workHours) {
		double totalhours = 0; 
		for (Integer hour : workHours) {
			return totalhours += hour;
		}
		return totalhours;
	}

	public List<Integer> getWorkHours() {
		return workHours;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getHourlyWage() {
		return hourlyWage;
	}

	public void setWorkHours(Integer workHours) {
		this.workHours.add(workHours);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}


	public void setHourlyWage(int hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

}
