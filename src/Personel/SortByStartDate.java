package Personel;

import java.util.Comparator;

public class SortByStartDate implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		int x = 0;
		
		if (o1.getStartDate().getYear() == o2.getStartDate().getYear()) {
			if (o1.getStartDate().getMonthValue() > o2.getStartDate().getMonthValue()) {
				return 1;
			} else if (o1.getStartDate().getMonthValue() < o2.getStartDate().getMonthValue()) {
				return -1;
			} else {
				x = o1.getName().getName().compareTo(o2.getName().getName());
				return x;
			}
		}else if (o1.getStartDate().getYear() > o2.getStartDate().getYear()) {
			return 1;
		}else {
			return -1;
		}
	}

}
