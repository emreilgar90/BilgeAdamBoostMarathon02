package Personell;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import Personel.Employee;
import Personel.FullTimeWorker;
import Personel.HourlyWorker;
import Personel.SortByStartDate;
import Personel.SortbyId;
import Personel.SortbyName;

public class Menu {
	public final static String MAIN_WORKING_DIRECTORY = "C:\\Users\\snozd\\eclipse-workspace\\BilgeAdamBoostMarathon2\\src\\com";
	public final static File EMPLOYEE_COUNTER_PATH = new File(MAIN_WORKING_DIRECTORY, "Employee.dat");
	public static List<Employee> employeList = new ArrayList<Employee>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		listEmployeesByNumber(employeList);
		menuLoop();
	}

	private static void menuLoop() {

		while (true) {
			showMenuItems();
			int option = sc.nextInt();
			selectMenu(option);
		}

	}

	private static void showMenuItems() {
		System.out.println("\n#########################################################");
		System.out.println(Messages.getString("Menu.2"));
		System.out.println("#########################################################");
		System.out.println(Messages.getString("Menu.NEW_EMPLOYEES"));
		System.out.println(Messages.getString("Menu.EMPLOYEE_LIST"));
		System.out.println(Messages.getString("Menu.SALARY_PAYMENT_LIST"));
		System.out.println(Messages.getString("Menu.EXIT"));
		System.out.println("#########################################################");

	}

	public static void selectMenu(int choice) {
		switch (choice) {
		case 1:
			newEmployes();
			System.out.println(Messages.getString("Menu.EMPLOYEES_ADDED"));
			break;
		case 2:
			showList();
			int option = sc.nextInt();
			selectList(option);
			break;
		case 3:
			payrollCalculation();
			break;
		case 0:
			endLoop();
			break;
		default:
			System.out.println(Messages.getString("Menu.WRONGINPUT"));
		}
	}

	private static void payrollCalculation() {

		System.out.println(Messages.getString("Menu.ENTER_YEAR"));
		int year = sc.nextInt();
		System.out.println(Messages.getString("Menu.ENTER_MONTH"));
		int month = sc.nextInt();

		List<Employee> filteredList = employeList.stream()
				.filter(p -> p.getStartDate().isBefore(LocalDate.of(year, month, 2)))
				.filter(p -> p.getEndDate().isAfter(LocalDate.of(year, month, 2))).collect(Collectors.toList());

		listEmployeesByNumber(filteredList);
	}

	private static void showList() {
		System.out.println("#########################################################");
		System.out.println(Messages.getString("Menu.BY_EMPLOYE_NUMBER"));
		System.out.println(Messages.getString("Menu.BY_NAME"));
		System.out.println(Messages.getString("Menu.BY_EMP_YEAR"));
		System.out.println("#########################################################");

	}

	public static void selectList(int choice) {
		switch (choice) {
		case 1:
			listEmployeesByNumber(employeList);
			break;
		case 2:
			listEmployeesByName();
			break;
		case 3:
			listEmployeesByDate();
			break;
		case 0:
			endLoop();
			break;
		default:
			System.out.println(Messages.getString("Menu.WRONGINPUT"));
		}
	}

	private static void listEmployeesByDate() {
		Collections.sort(employeList, new SortByStartDate());
		for (Employee employee : employeList) {
			System.out.println(employee);
		}
	}

	private static void listEmployeesByName() {
		Collections.sort(employeList, new SortbyName());
		for (Employee employee : employeList) {
			System.out.println(employee);
		}

	}

	private static void listEmployeesByNumber(List<Employee> employe) {
		Collections.sort(employe, new SortbyId());
		for (Employee employee : employe) {
			System.out.println(employee);
		}
	}

	private static void newEmployes() {
		List<Integer> workinghour = new ArrayList<>();
		workinghour.add(10);
		workinghour.add(20);
		workinghour.add(30);
		Employee hworker1 = new HourlyWorker("Emre ", "ILGAR", LocalDate.of(2022, 1, 1), null, workinghour, 150); //$NON-NLS-1$ //$NON-NLS-2$

		employeList.add(hworker1);
		workinghour.clear();
		workinghour.add(20);
		workinghour.add(30);
		workinghour.add(100);
		workinghour.add(50);
		Employee hworker2 = new HourlyWorker("Barlas", "ILGAR", LocalDate.of(1989, 1, 1), LocalDate.of(2009, 1, 1), //$NON-NLS-1$ //$NON-NLS-2$
				workinghour, 80);

		employeList.add(hworker2);
		workinghour.clear();
		workinghour.add(200);

		Employee hworker3 = new HourlyWorker("Memati", "BAŞ", LocalDate.of(1989, 1, 1), null, workinghour, 50); //$NON-NLS-1$ //$NON-NLS-2$
		workinghour.clear();
		workinghour.add(200);

		employeList.add(hworker3);
		Employee fullworker = new FullTimeWorker("Polat", "	ALEMDAR", LocalDate.of(2022, 1, 1), null, 8000); //$NON-NLS-1$ //$NON-NLS-2$

		employeList.add(fullworker);
		Employee fullworker2 = new FullTimeWorker("Pala", "RIZA", LocalDate.of(2022, 1, 1), null, 10000); //$NON-NLS-1$ //$NON-NLS-2$

		employeList.add(fullworker2);
		Employee fullworker3 = new FullTimeWorker("Ayse", "KADIN", LocalDate.of(2020, 3, 1), null, 15000); //$NON-NLS-1$ //$NON-NLS-2$

		employeList.add(fullworker3);

		writeObjectToFile(employeList, EMPLOYEE_COUNTER_PATH);
	}

	private static void writeObjectToFile(Object serObj, File file) {
		try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(file))) {
			objectOut.writeObject(serObj);
			objectOut.close();
			System.out.println("The Object was succesfully written to a file"); //$NON-NLS-1$
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void endLoop() {
		System.out.println(Messages.getString("Menu.WANNA_LOGOUT")); //$NON-NLS-1$
		if (sc.next().equalsIgnoreCase(Messages.getString("Menu.TYPE_Y"))) { //$NON-NLS-1$
			System.out.println(Messages.getString("Menu.BYE")); //$NON-NLS-1$
			sc.close();
			System.exit(0);
		}
	}
}
