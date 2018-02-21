package com.github;

import java.util.Random;

public class Employee {
    private int idNumber = 0;
    private String name = "";
    private String position = "";
    private double salary = 25000;

    public Employee(String name, String position){
        this.idNumber = generateIdNumber();
        if (name == null){
            this.name = "";
        }
        else {
            this.name = name;
        }
        if (position == null){
            this.position = "";
        }
        else {
            this.position = position;
            if (position.equalsIgnoreCase("manager")) {
                this.salary = 50000;
            } else {
                this.salary = 25000;
            }
        }
    }
    private int generateIdNumber(){
        Random random = new Random();
        return random.nextInt(899999) + 100000;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null){
            this.name = "";
        }
        else {
            this.name = name;
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position == null){
            this.position = "";
            this.salary = 25000;
        }
        else {
            this.position = position;
            if (this.position.equalsIgnoreCase("manager")) {
                setSalary(50000);
            }
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0){
            this.salary = 0;
        }
        else {
            this.salary = salary;
        }
    }

    public String toString(){
        String output = "";
        output += "ID number: " + Integer.toString(this.idNumber) + "\n";
        output += "Name: " + this.name + "\n";
        output += "Position: " + this.position + "\n";
        output += String.format("Salary: $%.2f", this.salary);
        return output;
    }

    public static void main(String[] args) {
        Employee emp = new Employee(null, null);
        System.out.println(emp.getIdNumber());
        System.out.println(emp.getName());
        System.out.println(emp.getPosition());
        System.out.println(emp.getSalary());
        emp.setPosition(null);
        emp.setSalary(-1000);
        System.out.println(emp.getSalary());
        System.out.println(emp.toString());
    }
}
