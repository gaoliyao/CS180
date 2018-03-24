package Q2.src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Test cases for AreaCheck (Exam 2 - Version 2).
 */
public class AreaCheckTest {
    private AreaCheckDummy a;

    @Before
    public void setUp() {
        a = new AreaCheckDummy();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test(timeout = 100)
    public void testArithmeticOverflowExceptionDefaultConstructor() {
        boolean hasDefaultConstructor = false;
        try {
            Constructor<?> c = ArithmeticOverflowException.class
                    .getDeclaredConstructor();
            if (c != null) {
                hasDefaultConstructor = true;
            }
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        String message = "ArithmeticOverflowException(): you must include the "
                + "default constructor in your custom exception.";

        assertTrue(message, hasDefaultConstructor);
    }

    @Test(timeout = 100)
    public void testArithmeticOverflowExceptionConstructorStringArgument() {
        boolean hasConstructorWithStringArgument = false;
        try {
            Constructor<?> c = ArithmeticOverflowException.class
                    .getDeclaredConstructor(String.class);
            if (c != null) {
                hasConstructorWithStringArgument = true;
            }
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        String message = "ArithmeticOverflowException(): you must include a "
                + "constructor that takes a String argument which is the "
                + "message for your custom exception.";

        assertTrue(message, hasConstructorWithStringArgument);
    }

    @Test(timeout = 100)
    public void testArithmeticOverflowExceptionIsSubclassOfException() {
        Class<?> superclass = (ArithmeticOverflowException.class)
                .getSuperclass();

        String message = "ArithmeticOverflowException: your custom exception "
                + "class must directly inherit from the appropriate class for "
                + "custom exceptions.";

        assertTrue(message, Exception.class == superclass);
    }

    @Test(timeout = 100)
    public void testMultiplyThrowsArithmeticOverflowException1()
            throws ArithmeticOverflowException {
        exception.expect(ArithmeticOverflowException.class);
        a.multiply(1073741824, 2);
    }

    @Test(timeout = 100)
    public void testMultiplyThrowsArithmeticOverflowException2()
            throws ArithmeticOverflowException {
        exception.expect(ArithmeticOverflowException.class);
        a.multiply(501737281, 910371772);
    }

    @Test(timeout = 100)
    public void testMultiplyNoExceptionThrown()
            throws ArithmeticOverflowException {

        String message = "multiply(): this method should return the integer "
                + "product of arguments 'a' and 'b'.";
        int expectedResult = 42;
        int actualResult = a.multiply(7, 6);

        assertEquals(message, expectedResult, actualResult);
    }

    @Test(timeout = 100)
    public void testIsEqualAreaTrue() {
        String message = "isEqualArea(): this method determines if two "
                + "rectangles, with dimensions passed as arguments, have "
                + "equal areas. If the are equal, it should return true and "
                + "false otherwise.";
        boolean actualResult = a.isEqualArea(5, 10, 25, 2);

        assertTrue(message, actualResult);
    }

    @Test(timeout = 100)
    public void testIsEqualAreaFalse() {
        String message = "isEqualArea(): this method determines if two "
                + "rectangles, with dimensions passed as arguments, have "
                + "equal areas. If the are equal, it should return true and "
                + "false otherwise.";
        boolean actualResult = a.isEqualArea(10, 10, 100, 2);

        assertFalse(message, actualResult);
    }

    @Test(timeout = 100)
    public void testIsEqualAreaCallsMultiply1() {
        String message = "isEqualArea(): you must call multiply() when "
                + "calculating the area of the rectangles. Do not use the "
                + "multiplication operator (*). Also, make sure that the "
                + "ArithmeticOverflowException is thrown from multiply(), not "
                + "from isEqualArea().";

        a.isEqualArea(1, 1, 1, 1);

        assertTrue(message, a.multiplyCalled);
    }

    @Test(timeout = 100)
    public void testIsEqualAreaCallsMultiply2() {
        String message = "isEqualArea(): you must call multiply() when "
                + "calculating the area of the rectangles. Do not use the "
                + "multiplication operator (*). Also, make sure that the "
                + "ArithmeticOverflowException is thrown from multiply(), not "
                + "from isEqualArea().";

        PrintStream ps = new PrintStream(new ByteArrayOutputStream());
        PrintStream old = System.err;
        System.setErr(ps);
        a.isEqualArea(3, 2, 572132, 37928);
        System.err.flush();
        System.setErr(old);

        assertTrue(message, a.multiplyCalled);
    }

    class AreaCheckDummy extends AreaCheck {
        public boolean multiplyCalled = false;

        @Override
        public int multiply(int a, int b) throws ArithmeticOverflowException {
            multiplyCalled = true;
            return super.multiply(a, b);
        }
    }
}
