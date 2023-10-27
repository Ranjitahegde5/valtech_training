package com.valtech.training.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(4, 6, "Ankita", 40, 60000.0));
		employees.add(new Employee(3, 9, "Bhuvan", 45, 70000.0));
		employees.add(new Employee(4, 7, "Chaya", 38, 58000.0));
		employees.add(new Employee(2, 6, "Dhruv", 42, 65000.0));
		
		Collections.sort(employees, new EmployeeComparator());
		
		for(Employee employee : employees) {
			System.out.println("Name: " + employee.getName() + ", Seniority: " + employee.getSeniority() + ", Experience: " + employee.getExperience());
		}
	}
}