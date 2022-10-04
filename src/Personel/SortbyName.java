package Personel;

import java.util.Comparator;

public class SortbyName implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.getName().getName().equals(o2.getName().getName())) {
			int x = o1.getRegistrationNumber().compareTo(o2.getRegistrationNumber());
			return x;
		} else {
			int x = (o1.getName().getName() + o1.getName().getSurName()).compareTo((o2.getName().getName() + o2.getName().getSurName()));
			return x;
		}
	}
}
