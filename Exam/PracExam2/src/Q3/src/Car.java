package Q3.src;

/**
 * TODO: 
 * 		- Define a class Car in this file below these comments.
 * 		-  Provide the private instance variable mileage of type double
 *			-  Provide a constructor 
 *				public Car(String make, String model, int year, double mileage)
 *               This initializes the instance variables. 
 *			Provide a getter function for  mileage
 *			Provide a print() that overrides that of the parent class- prints 
 *			the vehicle make, model and year. then displays the mileage in the NEXT line as "Mileage: 12000.0"
 *			where mileage=12000.0 in the above example.  
 *
 * NOTE: You do not need to do error checking. You can assume that the values 
 * of mileage for testing will be non-negative.
 */

public class Car extends Vehicle {
    private double mileage;
    public Car(String make, String model, int year, double mileage) {
        super(make, model, year);
        this.mileage = mileage;
    }
    //instantiate mileage here

    //provide constructor here

    //getter for mileage
    double getMileage() {
        return this.mileage;
    }

    //overrides print() from Vehicle
    @Override
    public void print() {
        super.print();
        System.out.printf("Mileage: %.2f\n", this.mileage);
    }
}