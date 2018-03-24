package Q3.src;

/**
 * TODO:
 * 		- Define a class Truck in this file below these comments.
 * 		-  Provide the private instance variable tonnage of type double
 *			-  Provide a constructor
 *				public Truck(String make, String model, int year, double tonnage)
 *               This initializes the instance variables.
 *			Provide a getter function for  tonnage
 *			Provide a print() that overrides that of the parent class- prints
 *			the vehicle make, model and year. then displays the tonnage in the NEXT line as "Tonnage: 12000.0"
 *			where tonnage=12000.0 in the above example.
 *
 * NOTE: You do not need to do error checking. You can assume that the values
 * of mileage for testing will be non-negative.
 */

public class Truck extends Vehicle {
    private double tonnage;
    public Truck(String make, String model, int year, double tonnage) {
        super(make, model, year);
        this.tonnage = tonnage;
    }
    //instantiate tonnage here

    //provide constructor here

    //getter for tonnage
    public double getTonnage() {
        return tonnage;
    }

    //overrides print() from Vehicle
    @Override
    public void print() {
        super.print();
        System.out.printf("Tonnage: %.2f\n", this.tonnage);
    }
}