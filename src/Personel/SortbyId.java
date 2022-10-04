package Personel;

import java.util.Comparator;

public class SortbyId implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		int x = o1.getRegistrationNumber().compareTo(o2.getRegistrationNumber());
		return x;
	}

}
