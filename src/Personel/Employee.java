package Personel;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
	private HourlyWorker hourlyWorker;
	private static final long serialVersionUID = 5579771019530958872L;
	private Name name;
	private LocalDate startDate;
	private LocalDate endDate;
	private double salary;
	private String registrationNumber;
	private static int idcounter = 1;

	public Employee(double salary) {
		this.salary = salary;
	}

	public Employee(String name, String surname, LocalDate startDate, LocalDate endDate) {
		this.name = new Name(name, surname);
		this.startDate = startDate;
		if(endDate==null) {
			this.endDate = LocalDate.now();
		}
		else {
			this.endDate = endDate;
		}
		this.registrationNumber = Employee.setId(startDate);
		idcounter++;
	}

	private static String setId(LocalDate startDate) {
		if (Employee.idcounter > 999) {
			Employee.idcounter = 1;
		}
		String number = String.format("%04d", Employee.idcounter);
		return startDate.getYear() + "/" + number;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Name getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	@Override
	public String toString() {
		return registrationNumber + "-" + name + ">> startDate=" + startDate + ", endDate=" + endDate + ", salary="
				+ salary + "]";
	}

	public Employee compareToByName(Employee i2) {
		if (this.name == i2.name) {
			int x = this.getRegistrationNumber().compareTo(i2.getRegistrationNumber());
			if (x == 1) {
				return this;
			} else
				return i2;
		} else {
			int name = (this.getName().getName() + this.getName().getSurName())
					.compareTo((i2.getName().getName() + i2.getName().getSurName()));
			if (name == 1) {
				return this;
			} else
				return i2;
		}
	}
}
