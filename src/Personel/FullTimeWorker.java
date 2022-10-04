package Personel;

import java.time.LocalDate;

public class FullTimeWorker extends Employee implements Workable {
	private static final long serialVersionUID = 3145096547693120359L;
	private int netSalary;
	
	public FullTimeWorker(String name, String surname, LocalDate startDate, LocalDate endDate, int netSalary) {
		super(name, surname, startDate, endDate);
		this.netSalary = netSalary;
		calcSalary();
	}
	
	@Override
	public void calcSalary() {
		super.setSalary(this.netSalary*1.25);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getNetSalary() {
		return netSalary;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
}
