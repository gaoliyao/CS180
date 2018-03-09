import org.junit.Test;
import org.junit.Assert;

/**
 * Student test cases for the QuestionOne class.
 */
public final class ArrayAddTest {
    /*
     * Constants used during testing.
     */
    private static final String TEST_ONE_FUNCTION_ARGUMENT;
    private static final String TEST_TWO_FUNCTION_ARGUMENT;
    private static final String TEST_THREE_FUNCTION_ARGUMENT;
    private static final String TEST_FOUR_FUNCTION_ARGUMENT;
    private static final String TEST_FIVE_FUNCTION_ARGUMENT;
    private static final String TEST_SIX_FUNCTION_ARGUMENT;
    private static final String TEST_SEVEN_FUNCTION_ARGUMENT;
    private static final String TEST_EIGHT_FUNCTION_ARGUMENT;
    private static final String TEST_NINE_FUNCTION_ARGUMENT;
    private static final String TEST_TEN_FUNCTION_ARGUMENT;
    private static final String TEST_ELEVEN_FUNCTION_ARGUMENT;
    private static final String TEST_TWELVE_FUNCTION_ARGUMENT;

    private static final String TEST_ONE_EXPECTED_RETURN_VALUE;
    private static final String TEST_TWO_EXPECTED_RETURN_VALUE;
    private static final String TEST_THREE_EXPECTED_RETURN_VALUE;
    private static final String TEST_FOUR_EXPECTED_RETURN_VALUE;
    private static final String TEST_FIVE_EXPECTED_RETURN_VALUE;
    private static final String TEST_SIX_EXPECTED_RETURN_VALUE;
    private static final String TEST_SEVEN_EXPECTED_RETURN_VALUE;
    private static final String TEST_EIGHT_EXPECTED_RETURN_VALUE;
    private static final String TEST_NINE_EXPECTED_RETURN_VALUE;
    private static final String TEST_TEN_EXPECTED_RETURN_VALUE;
    private static final String TEST_ELEVEN_EXPECTED_RETURN_VALUE;
    private static final String TEST_TWELVE_EXPECTED_RETURN_VALUE;

    private static final String TEST_FAILURE_MESSAGE;

    /*
     * Fields used during testing.
     */
    private String returnValue;

    static {
        TEST_ONE_FUNCTION_ARGUMENT = "0";
        TEST_TWO_FUNCTION_ARGUMENT = "5346";
        TEST_THREE_FUNCTION_ARGUMENT = "x";
        TEST_FOUR_FUNCTION_ARGUMENT = "423132x";
        TEST_FIVE_FUNCTION_ARGUMENT = "20 / x";
        TEST_SIX_FUNCTION_ARGUMENT = "x^0";
        TEST_SEVEN_FUNCTION_ARGUMENT = "x^2";
        TEST_EIGHT_FUNCTION_ARGUMENT = "x^546";
        TEST_NINE_FUNCTION_ARGUMENT = "12x^5";
        TEST_TEN_FUNCTION_ARGUMENT = "93 / x^0";
        TEST_ELEVEN_FUNCTION_ARGUMENT = "88 / x^31";
        TEST_TWELVE_FUNCTION_ARGUMENT = "20x^20";

        TEST_ONE_EXPECTED_RETURN_VALUE = "[\\s]*0[\\s]*";
        TEST_TWO_EXPECTED_RETURN_VALUE = "[\\s]*0[\\s]*";
        TEST_THREE_EXPECTED_RETURN_VALUE = "[\\s]*1[\\s]*";
        TEST_FOUR_EXPECTED_RETURN_VALUE = "[\\s]*423132[\\s]*";
        TEST_FIVE_EXPECTED_RETURN_VALUE = "[\\s]*-20[\\s]*/[\\s]*x[\\s]*\\^[\\s]*2[\\s]*";
        TEST_SIX_EXPECTED_RETURN_VALUE = "[\\s]*0[\\s]*";
        TEST_SEVEN_EXPECTED_RETURN_VALUE = "[\\s]*2[\\s]*x[\\s]*";
        TEST_EIGHT_EXPECTED_RETURN_VALUE = "[\\s]*546[\\s]*x[\\s]*\\^[\\s]*545[\\s]*";
        TEST_NINE_EXPECTED_RETURN_VALUE = "[\\s]*60[\\s]*x[\\s]*\\^[\\s]*4[\\s]*";
        TEST_TEN_EXPECTED_RETURN_VALUE = "[\\s]*0[\\s]*";
        TEST_ELEVEN_EXPECTED_RETURN_VALUE = "[\\s]*-2728[\\s]*/[\\s]*x[\\s]*\\^[\\s]*32[\\s]*";
        TEST_TWELVE_EXPECTED_RETURN_VALUE = "[\\s]*400[\\s]*x[\\s]*\\^[\\s]*19[\\s]*";

        TEST_FAILURE_MESSAGE = "Ensure that your return value matches the expected return value!\nexpected: %s\nactual:   %s";
    } //static

    @Test(timeout = 1000)
    public void testOne() {
        this.returnValue = ArrayAdd.add(TEST_ONE_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "0", this.returnValue), this.returnValue.matches(TEST_ONE_EXPECTED_RETURN_VALUE));
    } //testOne

    @Test(timeout = 1000)
    public void testTwo() {
        this.returnValue = QuestionOne.getDerivative(TEST_TWO_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "0", this.returnValue), this.returnValue.matches(TEST_TWO_EXPECTED_RETURN_VALUE));
    } //testTwo

    @Test(timeout = 1000)
    public void testThree() {
        this.returnValue = QuestionOne.getDerivative(TEST_THREE_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "1", this.returnValue), this.returnValue.matches(TEST_THREE_EXPECTED_RETURN_VALUE));
    } //testThree

    @Test(timeout = 1000)
    public void testFour() {
        this.returnValue = QuestionOne.getDerivative(TEST_FOUR_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "423132", this.returnValue), this.returnValue.matches(TEST_FOUR_EXPECTED_RETURN_VALUE));
    } //testFour

    @Test(timeout = 1000)
    public void testFive() {
        this.returnValue = QuestionOne.getDerivative(TEST_FIVE_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "-20 / x^2", this.returnValue), this.returnValue.matches(TEST_FIVE_EXPECTED_RETURN_VALUE));
    } //testFive

    @Test(timeout = 1000)
    public void testSix() {
        this.returnValue = QuestionOne.getDerivative(TEST_SIX_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "0", this.returnValue), this.returnValue.matches(TEST_SIX_EXPECTED_RETURN_VALUE));
    } //testSix

    @Test(timeout = 1000)
    public void testSeven() {
        this.returnValue = QuestionOne.getDerivative(TEST_SEVEN_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "2x", this.returnValue), this.returnValue.matches(TEST_SEVEN_EXPECTED_RETURN_VALUE));
    } //testSeven

    @Test(timeout = 1000)
    public void testEight() {
        this.returnValue = QuestionOne.getDerivative(TEST_EIGHT_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "546x^545", this.returnValue), this.returnValue.matches(TEST_EIGHT_EXPECTED_RETURN_VALUE));
    } //testEight

    @Test(timeout = 1000)
    public void testNine() {
        this.returnValue = QuestionOne.getDerivative(TEST_NINE_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "60x^4", this.returnValue), this.returnValue.matches(TEST_NINE_EXPECTED_RETURN_VALUE));
    } //testNine

    @Test(timeout = 1000)
    public void testTen() {
        this.returnValue = QuestionOne.getDerivative(TEST_TEN_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "0", this.returnValue), this.returnValue.matches(TEST_TEN_EXPECTED_RETURN_VALUE));
    } //testTen

    @Test(timeout = 1000)
    public void testEleven() {
        this.returnValue = QuestionOne.getDerivative(TEST_ELEVEN_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "-2728 / x^32", this.returnValue), this.returnValue.matches(TEST_ELEVEN_EXPECTED_RETURN_VALUE));
    } //testEleven

    @Test(timeout = 1000)
    public void testTwelve() {
        this.returnValue = QuestionOne.getDerivative(TEST_TWELVE_FUNCTION_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "400x^19", this.returnValue), this.returnValue.matches(TEST_TWELVE_EXPECTED_RETURN_VALUE));
    } //testTwelve
}