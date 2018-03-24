import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * VehicleTest: Test cases for Vehicle.java
 *
 * CS180:S17 Exam 2 Test Cases
 *
 * @author Tori Shurman
 * @version March 20, 2017
 */
public class VehicleTest {

    public static final double DELTA = .01;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private enum VEHICLE_TYPE {CAR, TRUCK};


    @Test(timeout=100)
    public void testCarClass() {
        Car car = new Car("Ford", "De Luxe Convertible", 1948, 5089.72);
        Class clazz = car.getClass();
        Class superClass = clazz.getSuperclass();
        String message = "The class Car should exhibit proper inheritance";
        assertEquals(message, "Vehicle", superClass.getName());

        message = "Check that mileage is instantiated properly";
        try {
            Field[] fields = clazz.getDeclaredFields();
            assertEquals(message, 1, fields.length);

            Field field = clazz.getDeclaredField("mileage");
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            assertEquals(message, 5089.72, field.getDouble(car), DELTA);

            if (field.isAccessible()) {
                field.setAccessible(false);
            }
        } catch (NoSuchFieldException e) {
            assertTrue(message, false);
        } catch (IllegalAccessException e) {
            assertTrue(message, false);
        }
    }

    @Test(timeout=100)
    public void testCarConstructorGetter() {
        Car car = new Car("DeLorean", "DMC-12", 1985, 734.37);
        String message = "Car: check that all fields are instantiated properly";
        assertEquals(message, "DeLorean", car.getMake());
        assertEquals(message, "DMC-12", car.getModel());
        assertEquals(message, 1985, car.getYear());
        assertEquals(message, 734.37, car.getMileage(), DELTA);
    }

    @Test(timeout = 100)
    public void testCarPrint() throws IOException{
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));
        Car car = new Car("Oldsmobile", "Vista Cruiser", 1969, 8730.4839);
        car.print();
        String expected = "Make: Oldsmobile, Model: Vista Cruiser, Year: 1969\nMileage: 8730.48\n";
        String message = "Car.print() should override Vehicle.print() and print the vehicle details followed by the " +
                "mileage.";
        assertEquals(message, expected, outContent.toString("UTF-8"));
        outContent.close();
        System.setOut(originalOut);
    }

    @Test(timeout=100)
    public void testTruckClass() {
        Truck truck = new Truck("Obnoxiously Large Trucks", "Lane Hog", 2008, 50.563);
        Class clazz = truck.getClass();
        Class superClass = clazz.getSuperclass();
        String message = "The class Truck should exhibit proper inheritance";
        assertEquals(message, "Vehicle", superClass.getName());

        message = "Check that tonnage is instantiated properly";
        try {
            Field[] fields = clazz.getDeclaredFields();
            assertEquals(message, 1, fields.length);

            Field field = clazz.getDeclaredField("tonnage");
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            assertEquals(message, 50.563, field.getDouble(truck), DELTA);

            if (field.isAccessible()) {
                field.setAccessible(false);
            }
        } catch (NoSuchFieldException e) {
            assertTrue(message, false);
        } catch (IllegalAccessException e) {
            assertTrue(message, false);
        }
    }

    @Test(timeout=100)
    public void testTruckConstructorGetter() {
        Car car = new Car("Try Hard Trucks", "The Little Truck that Could", 2004, 3.27423);
        String message = "Truck: check that all fields are instantiated properly";
        assertEquals(message, "Try Hard Trucks", car.getMake());
        assertEquals(message, "The Little Truck that Could", car.getModel());
        assertEquals(message, 2004, car.getYear());
        assertEquals(message, 3.27423, car.getMileage(), DELTA);
    }

    @Test(timeout = 100)
    public void testTruckPrint() throws IOException {
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));
        Truck truck = new Truck("Fairy Tale Truck Company", "The Big Bad Truck", 2011, 2489.499);
        truck.print();
        String expected = "Make: Fairy Tale Truck Company, Model: The Big Bad Truck, Year: 2011\n" +
                "Tonnage: 2489.50\n";
        String message = "Truck.print() should override Vehicle.print() and print the vehicle details followed by the" +
                " tonnage.";
        assertEquals(message, expected, outContent.toString("UTF-8"));
        outContent.close();
        System.setOut(originalOut);
    }

    private String getFormattedString(String make, String model, int year, double feature, VEHICLE_TYPE type) {
        String ret = "Make: " + make + ", Model: " + model + ", Year: " +
                year + "\n";

        switch(type) {
            case CAR:
                ret += "Mileage: " + feature + "\n";
                break;
            case TRUCK:
                ret += "Tonnage: " + feature + "\n";
                break;
        }

        return ret;
    }
}
