package com.aurionpro.model;

public class Employee {
    public int employeeId;
    public String empName;
    public String empDepartment;
    public double empSalary;

    public Employee(int id, String name, String dept, double salary) {
        employeeId = id;
        empName = name;
        empDepartment = dept;
        empSalary = salary;
    }

    public void display() {
        System.out.println("Employee ID: " + employeeId + ", Employee Name: " + empName + ",Employee Department: " + empDepartment + ",Employee Salary: " + empSalary);
    }
}
