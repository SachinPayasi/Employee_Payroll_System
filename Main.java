package com.sachin.payroll;

import java.util.Scanner;

import java.util.ArrayList;

abstract class Employee{
	
	private String name;
	private int id;
	
	// Constructor to set the values for instance variable
	public Employee(String name , int id){
		
		this.name=name;
		this.id=id;	
    }
	
	
	//getter's to get the value,s of instance variable
	
	//for name
	public String getName() {
		
		return name;
		
	}
	
	//for id
	public int getid() {
		
		return id;
		
	}
	
	// abstract method to calculate the employee salary
	public abstract double calculateSalary();
	
	// Overridden toString() method to print result according to our need 
	 
	@Override
	 
	public String toString() {
		
		return "Employee[name="+name +" , id="+id+" ,salary= "+calculateSalary()+"]"; 
		
	}	
}

//class for the Full time employee detail's

class FullTimeEmployee extends Employee{
	private double monthlySalary;
	
	
	public FullTimeEmployee(String name, int id, double monthlySalary){
		super(name,id);
		this.monthlySalary=monthlySalary;
	}
	
	//Calculating salary of full time employee
	
	@Override
	public double calculateSalary() {
		return monthlySalary;
	}
}



//class for part time employee's detail,s  

class PartTimeEmployee extends Employee{
	
	private int hoursWorked;
	private double hourlyRate;
	
	public PartTimeEmployee(String name, int id, int hoursWorked,double hoursRate) {
		
		super(name , id);
		this.hoursWorked=hoursWorked;
		this.hourlyRate=hoursRate;
		
	}
	
	// Calculating salary of part time employee
	 
	@Override
	public double calculateSalary() {
		
		return hoursWorked*hourlyRate;
	}
	
}


// Payroll System class 

class Payrollsystem{
	
	private ArrayList<Employee> employeeList;
	
	public Payrollsystem() {
		employeeList = new ArrayList<>();
	}
	
	// Method to add employee's in list
	
	public void addEmployee(Employee e)
	{
		employeeList.add(e);
	}
	
	//method to remove employee's in list
	
	public void removeEmployee(int id) {
		
		Employee employeeToRemove = null;
		
		for(Employee employee : employeeList) {
			if(employee.getid()==id) {
			  employeeToRemove = employee;
			  break;
			}
		}
		
		if(employeeToRemove!=null) {
			employeeList.remove(employeeToRemove);
		}	
	}
	
	 
	// method to display the employees from the list
	
	public void displayEmployees() {
		for(Employee employees : employeeList) {
			System.out.println(employees);
		}
	}
}


public class Main {

	public static void main(String[] args) {

		 Payrollsystem payrollSystem = new Payrollsystem();
   
   FullTimeEmployee emp1 = new FullTimeEmployee("Virat Kohli", 101, 500000.0);
   FullTimeEmployee emp2 = new FullTimeEmployee("Rohit Sharma", 103, 5500.0);
   FullTimeEmployee emp3 = new FullTimeEmployee("Jasprit Bumrah", 105, 6200.0);
   FullTimeEmployee emp4 = new FullTimeEmployee("Rishabh Pant", 107, 1700.0);

   // Adding multiple Part-Time Employees
   PartTimeEmployee emp5 = new PartTimeEmployee("Jane Smith", 102, 30, 15.0);
   PartTimeEmployee emp6 = new PartTimeEmployee("Michael Lee", 104, 20, 18.0);
   PartTimeEmployee emp7 = new PartTimeEmployee("Emily Davis", 106, 25, 17.0);
   PartTimeEmployee emp8 = new PartTimeEmployee("Kl Rahul", 108, 30, 19.0);
   PartTimeEmployee emp9 = new PartTimeEmployee("Chinna", 103,23 , 19.6);
   

   // Adding employees to the payroll (system ArrayList)
   payrollSystem.addEmployee(emp1);
   payrollSystem.addEmployee(emp2);
   payrollSystem.addEmployee(emp3);
   payrollSystem.addEmployee(emp4);
   payrollSystem.addEmployee(emp5);
   payrollSystem.addEmployee(emp6);
   payrollSystem.addEmployee(emp7);
   payrollSystem.addEmployee(emp8);
   payrollSystem.addEmployee(emp9);
    
   Scanner scanner = new Scanner(System.in);
    System.out.println("1:- Detils Of Employee");
    System.out.println("2:- Remaining Employees After Removing");
    
    System.out.println("\nEnter Your Choice ");
    int choice = scanner.nextInt();
    if(choice ==1) {
    	System.out.println("Initial Employee Details:");
    	payrollSystem.displayEmployees();
    	
    }else if(choice==2) {
    	
   
    	
    	System.out.println("\nRemaining Employee Details:");
    	payrollSystem.displayEmployees();
    	
    	
    }
    else {
    	System.out.println("Invalid Input");
    }
    //System.out.println("\nRemoving Employee with ID 101 , 103");
    payrollSystem.removeEmployee(101);
    payrollSystem.removeEmployee(103);

   
    	    	
    
	}

}
