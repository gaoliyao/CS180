/**
 * Exam 2 
 * Question 3
 *
 * DO NOT edit the Vehicle class.
 * Go through the class carefully and then scroll down to the TODO section.
 *
 */

public class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void print() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
    }
}