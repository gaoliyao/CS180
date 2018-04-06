package Q1.src;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import java.util.Arrays;
import org.junit.Assert;

/**
 * Instructor test cases for the QuestionOne class.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public final class QuestionOneInstructorTest {
    /*
     * Constants used in testing.
     */
    private static final int[] GET_MODE_TEST_ZERO_VALUES_ARGUMENT;
    private static final int GET_MODE_TEST_ZERO_EXPECTED_RETURN_VALUE;

    private static final int[] GET_MODE_TEST_ONE_VALUES_ARGUMENT;
    private static final int GET_MODE_TEST_ONE_EXPECTED_RETURN_VALUE;

    private static final int[] GET_MODE_TEST_TWO_VALUES_ARGUMENT;
    private static final int GET_MODE_TEST_TWO_EXPECTED_RETURN_VALUE;

    private static final int[] GET_MODE_TEST_THREE_VALUES_ARGUMENT;
    private static final int GET_MODE_TEST_THREE_EXPECTED_RETURN_VALUE;

    private static final int[] GET_MODE_TEST_FOUR_VALUES_ARGUMENT;

    private static final int[] GET_MODE_TEST_FIVE_VALUES_ARGUMENT;

    static {
        GET_MODE_TEST_ZERO_VALUES_ARGUMENT = new int[] {-5};
        GET_MODE_TEST_ZERO_EXPECTED_RETURN_VALUE = -5;

        GET_MODE_TEST_ONE_VALUES_ARGUMENT = new int[] {10_000};
        GET_MODE_TEST_ONE_EXPECTED_RETURN_VALUE = 10_000;

        GET_MODE_TEST_TWO_VALUES_ARGUMENT = new int[] {6, 2, 1, 56, 5, 17, 6, 92, 0, 16, 94, 3, 6, 7};
        GET_MODE_TEST_TWO_EXPECTED_RETURN_VALUE = 6;

        GET_MODE_TEST_THREE_VALUES_ARGUMENT = new int[] {5, 32, -12, 4, 683, 2, 1, 5, 1, 4, 1, 1, 1, -4};
        GET_MODE_TEST_THREE_EXPECTED_RETURN_VALUE = 1;

        GET_MODE_TEST_FOUR_VALUES_ARGUMENT = new int[] {50, 3, -1, 93, 2, -2, 50, 3, -1};

        GET_MODE_TEST_FIVE_VALUES_ARGUMENT = new int[] {-2, -7, -3, -2, -23, 73, -7, 0};
    } //static

    @Test(timeout = 1000)
    public void _0_getModeTestZero() {
        System.out.printf("Test Zero Input: %s\n", Arrays.toString(GET_MODE_TEST_ZERO_VALUES_ARGUMENT));

        Assert.assertEquals("Ensure that the `getMode` method returns the mode of the specified array! The mode of an array is the element that occurs most often!", GET_MODE_TEST_ZERO_EXPECTED_RETURN_VALUE, QuestionOne.getMode(GET_MODE_TEST_ZERO_VALUES_ARGUMENT));
    } //_0_getModeTestZero

    @Test(timeout = 1000)
    public void _1_getModeTestOne() {
        System.out.printf("Test One Input: %s\n", Arrays.toString(GET_MODE_TEST_ONE_VALUES_ARGUMENT));

        Assert.assertEquals("Ensure that the `getMode` method returns the mode of the specified array! The mode of an array is the element that occurs most often!", GET_MODE_TEST_ONE_EXPECTED_RETURN_VALUE, QuestionOne.getMode(GET_MODE_TEST_ONE_VALUES_ARGUMENT));
    } //_1_getModeTestOne

    @Test(timeout = 1000)
    public void _2_getModeTestTwo() {
        System.out.printf("Test Two Input: %s\n", Arrays.toString(GET_MODE_TEST_TWO_VALUES_ARGUMENT));

        Assert.assertEquals("Ensure that the `getMode` method returns the mode of the specified array! The mode of an array is the element that occurs most often!", GET_MODE_TEST_TWO_EXPECTED_RETURN_VALUE, QuestionOne.getMode(GET_MODE_TEST_TWO_VALUES_ARGUMENT));
    } //_2_getModeTestTwo

    @Test(timeout = 1000)
    public void _3_getModeTestThree() {
        System.out.printf("Test Three Input: %s\n", Arrays.toString(GET_MODE_TEST_THREE_VALUES_ARGUMENT));

        Assert.assertEquals("Ensure that the `getMode` method returns the mode of the specified array! The mode of an array is the element that occurs most often!", GET_MODE_TEST_THREE_EXPECTED_RETURN_VALUE, QuestionOne.getMode(GET_MODE_TEST_THREE_VALUES_ARGUMENT));
    } //_3_getModeTestThree

    @Test(timeout = 1000)
    public void _4_getModeTestFour() {
        System.out.printf("Test Four Input: %s\n", Arrays.toString(GET_MODE_TEST_FOUR_VALUES_ARGUMENT));

        int returnValue = QuestionOne.getMode(GET_MODE_TEST_FOUR_VALUES_ARGUMENT);

        Assert.assertTrue("Ensure that the `getMode` method returns the mode of the specified array! The mode of an array is the element that occurs most often! If there is more than one, any will be accepted.", returnValue == 50 || returnValue == 3 || returnValue == -1);
    } //_4_getModeTestFour

    @Test(timeout = 1000)
    public void _5_getModeTestFive() {
        System.out.printf("Test Five Input: %s\n", Arrays.toString(GET_MODE_TEST_FIVE_VALUES_ARGUMENT));

        int returnValue = QuestionOne.getMode(GET_MODE_TEST_FIVE_VALUES_ARGUMENT);

        Assert.assertTrue("Ensure that the `getMode` method returns the mode of the specified array! The mode of an array is the element that occurs most often! If there is more than one, any will be accepted.",returnValue == -2 || returnValue == -7);
    } //_5_getModeTestFive
}