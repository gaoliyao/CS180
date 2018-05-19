package Q1.src;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import java.util.Arrays;
import org.junit.Assert;

/**
 * Student test cases for the QuestionOne class.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public final class QuestionOneStudentTest {
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
        GET_MODE_TEST_ZERO_VALUES_ARGUMENT = new int[] {-42};
        GET_MODE_TEST_ZERO_EXPECTED_RETURN_VALUE = -42;

        GET_MODE_TEST_ONE_VALUES_ARGUMENT = new int[] {6_573};
        GET_MODE_TEST_ONE_EXPECTED_RETURN_VALUE = 6_573;

        GET_MODE_TEST_TWO_VALUES_ARGUMENT = new int[] {4, 2, 1, 56, 5, 17, 4, 92, 0, 16, 94, 3, 4};
        GET_MODE_TEST_TWO_EXPECTED_RETURN_VALUE = 4;

        GET_MODE_TEST_THREE_VALUES_ARGUMENT = new int[] {5, 32, -12, 4, 683, 2, 0, 5, 0, 4, 0, 0, 0};
        GET_MODE_TEST_THREE_EXPECTED_RETURN_VALUE = 0;

        GET_MODE_TEST_FOUR_VALUES_ARGUMENT = new int[] {45, 1, 0, 93, 2, -2, 45, 1, 0};

        GET_MODE_TEST_FIVE_VALUES_ARGUMENT = new int[] {-1, -5, -3, -1, -23, 73, -5};
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

        Assert.assertTrue("Ensure that the `getMode` method returns the mode of the specified array! The mode of an array is the element that occurs most often! If there is more than one, any will be accepted.", returnValue == 45 || returnValue == 1 || returnValue == 0);
    } //_4_getModeTestFour

    @Test(timeout = 1000)
    public void _5_getModeTestFive() {
        System.out.printf("Test Five Input: %s\n", Arrays.toString(GET_MODE_TEST_FIVE_VALUES_ARGUMENT));

        int returnValue = QuestionOne.getMode(GET_MODE_TEST_FIVE_VALUES_ARGUMENT);

        Assert.assertTrue("Ensure that the `getMode` method returns the mode of the specified array! The mode of an array is the element that occurs most often! If there is more than one, any will be accepted.",returnValue == -1 || returnValue == -5);
    } //_5_getModeTestFive
}