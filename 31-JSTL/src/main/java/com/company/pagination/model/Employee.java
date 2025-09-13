package com.company.pagination.model;

public class Employee {
    private int id;
    private String name;
    private String department;

    // Constructor
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters (important for EL/JSTL)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
}