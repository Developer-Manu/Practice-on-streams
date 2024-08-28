package com.practice.operations.using.stream.apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class OperationsUsingStreamApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperationsUsingStreamApisApplication.class, args);
		List<Integer> list = Arrays.asList(1,4,3,6,2,9,5,8,7,10);

		StreamApiOperations streamApiOperations = new StreamApiOperations();
		streamApiOperations.sumOfArrayList(list);
		streamApiOperations.averageOfList(list);
		streamApiOperations.squareFilter(list);
		streamApiOperations.listOfEvenOdd(list);
		streamApiOperations.numWithOne(list);
		streamApiOperations.duplicateNumbers(list);
		streamApiOperations.findMaxMin(list);
		streamApiOperations.sortedList(list);
		streamApiOperations.getSkip(list);
		streamApiOperations.secHighestLowest(list);


		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1,60000));
		employees.add(new Employee(2,55000));
		employees.add(new Employee(3,96000));
		employees.add(new Employee(4,35000));
		employees.add(new Employee(5,21000));
		employees.add(new Employee(6,50000));
		employees.add(new Employee(7,74000));
		employees.add(new Employee(8,84000));
		employees.add(new Employee(9,19000));

		System.out.println("\n");
		System.out.println("\n");

		List<Employee> sortedList = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		System.out.println(sortedList);

		System.out.println("\n");
		System.out.println("\n");

		List<Employee> reverseSortedList = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		System.out.println(reverseSortedList);

		System.out.println("\n");
		System.out.println("\n");

		System.out.println(employees.stream().max(Comparator.comparing(Employee::getSalary)).get());

		System.out.println("\n");
		System.out.println("\n");

		System.out.println(employees.stream().max(Comparator.comparing(Employee::getSalary)).get().getSalary());

		System.out.println("\n");
		System.out.println("\n");

		System.out.println(employees.stream().min(Comparator.comparing(Employee::getSalary)).get());

		System.out.println("\n");
		System.out.println("\n");

		System.out.println(employees.stream().min(Comparator.comparing(Employee::getSalary)).get().getSalary());

		System.out.println("\n");
		System.out.println("\n");

		List<Employee> empListMoreThan50 = employees.stream().filter(employee -> employee.getSalary() > 50000).collect(Collectors.toList());
		System.out.println(empListMoreThan50);

		System.out.println("\n");
		System.out.println("\n");

		List<Employee> topThree = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());
		System.out.println(topThree);

		System.out.println("\n");
		System.out.println("\n");

		List<Integer> topThreeSalary = employees.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		System.out.println(topThreeSalary);

		System.out.println("\n");
		System.out.println("\n");

		List<Employee> leastThree = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).limit(3).collect(Collectors.toList());
		System.out.println(leastThree);

		System.out.println("\n");
		System.out.println("\n");

		List<Integer> leastThreeSalary = employees.stream().map(Employee::getSalary).sorted().limit(3).collect(Collectors.toList());
		System.out.println(leastThreeSalary);

		System.out.println("\n");
		System.out.println("\n");

		int sumOfSalary = employees.stream().mapToInt(Employee::getSalary).sum();
		System.out.println(sumOfSalary);

		streamApiOperations.stringCharCount();
		streamApiOperations.duplicateChar();

	}

}
