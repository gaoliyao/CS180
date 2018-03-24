/**
 * Exam 2
 * Question 2 -- Complete the classes AreaCheck and ArithmeticOverflowException
 *
 * Note: The AreaCheckTest.java file within this module has compile time errors.
 * 		These errors will automatically get fixed on completing the classes AreaCheck
 * 		and ArithmeticOverflowException
 *
 * The class AreaCheck defined below contains two methods which perform some
 * simple calculations:
 *
 * 		- boolean isEqualArea(int w1, int h1, int w2, int h2): determines if
 * 		  two rectangles have equal area, where the first rectangle is given
 * 		  as a pair of dimensions w1 and h1 and the second rectangle is given
 * 		  as a pair of dimensions w2 and h2.
 * 			- The area is calculated as width times height.
 * 			- You can assume that all arguments passed will be positive.
 * 			- You must NOT use the multiplication operator, '*'. You must call
 * 			  the multiply() method that you write.
 * 			- Returns true if the the two rectangles have equal area and false
 * 			  otherwise.
 *
 * 		- int multiply(int a, int b): calculates the product as argument 'a'
 * 		  multiplied by argument 'b'.
 * 			- This method must throw an ArithmeticOverflowException. This
 * 			  exception will be thrown if the result of multiplying 'a' and 'b'
 * 			  is too large to fit in a signed int. You can determine if the
 * 			  result will overflow by checking if 'a' is greater than the
 * 			  quotient of Integer.MAX_VALUE and 'b'. While throwing
 * 			  the exception you may or may not include a message.
 * 			- Returns the product of 'a' and 'b'. You may use the multiplication
 * 			  operator, '*', in this method.
 *
 * The class ArithmeticOverflowException is a custom Exception which will be
 * used when performing multiplication. You must write this class in the separate
 * file in this module. This class should have two constructors:
 * 		- public ArithmeticOverflowException()
 * 		- public ArithmeticOverflowException(String message)
 *
 * Examples:
 * 		- isEqualArea(4, 8, 16, 2) is true
 * 		- isEqualArea(9, 7, 2, 3) is false
 * 		- isEqualArea(2, 3, 37928, 572132) is false
 *
 *		- multiply(1, 42) is 42
 *		- multiply(7, 2) is 14
 *		- multiply(1872, 92823) is 173764656
 *		- multiply(1073741824, 2) throws an ArithmeticOverflowException
 */
public class AreaCheck {

    // Write the two methods described above

}
