import org.junit.Test;
import org.junit.Assert;

/**
 * Student test cases for the QuestionTwo class.
 */
public final class QuestionTwoStudentTest {
    /*
     * Constants used during testing.
     */
    private static final int TEST_ONE_NUMBER_ARGUMENT;
    private static final int TEST_TWO_NUMBER_ARGUMENT;
    private static final int TEST_THREE_NUMBER_ARGUMENT;
    private static final int TEST_FOUR_NUMBER_ARGUMENT;
    private static final int TEST_FIVE_NUMBER_ARGUMENT;
    private static final int TEST_SIX_NUMBER_ARGUMENT;
    private static final int TEST_SEVEN_NUMBER_ARGUMENT;
    private static final int TEST_EIGHT_NUMBER_ARGUMENT;
    private static final int TEST_NINE_NUMBER_ARGUMENT;
    private static final int TEST_TEN_NUMBER_ARGUMENT;
    private static final int TEST_ELEVEN_NUMBER_ARGUMENT;
    private static final int TEST_TWELVE_NUMBER_ARGUMENT;

    private static final String TEST_FAILURE_MESSAGE;

    static {
        TEST_ONE_NUMBER_ARGUMENT = 0;
        TEST_TWO_NUMBER_ARGUMENT = 1;
        TEST_THREE_NUMBER_ARGUMENT = 2;
        TEST_FOUR_NUMBER_ARGUMENT = 45;
        TEST_FIVE_NUMBER_ARGUMENT = 236;
        TEST_SIX_NUMBER_ARGUMENT = 1259;
        TEST_SEVEN_NUMBER_ARGUMENT = 99999;
        TEST_EIGHT_NUMBER_ARGUMENT = 24782387;
        TEST_NINE_NUMBER_ARGUMENT = 7919;
        TEST_TEN_NUMBER_ARGUMENT = 246824682;
        TEST_ELEVEN_NUMBER_ARGUMENT = 4647581;
        TEST_TWELVE_NUMBER_ARGUMENT = 2047;

        TEST_FAILURE_MESSAGE = "Ensure that isPrime() correctly determines whether or not number is prime! A number is prime if it is only divisible by one and itself!";
    } //static

    @Test(timeout = 1000)
    public void testOne() {
        Assert.assertFalse(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_ONE_NUMBER_ARGUMENT));
    } //testOne

    @Test(timeout = 1000)
    public void testTwo() {
        Assert.assertFalse(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_TWO_NUMBER_ARGUMENT));
    } //testTwo

    @Test(timeout = 1000)
    public void testThree() {
        Assert.assertTrue(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_THREE_NUMBER_ARGUMENT));
    } //testThree

    @Test(timeout = 1000)
    public void testFour() {
        Assert.assertFalse(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_FOUR_NUMBER_ARGUMENT));
    } //testFour

    @Test(timeout = 1000)
    public void testFive() {
        Assert.assertFalse(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_FIVE_NUMBER_ARGUMENT));
    } //testFive

    @Test(timeout = 1000)
    public void testSix() {
        Assert.assertTrue(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_SIX_NUMBER_ARGUMENT));
    } //testSix

    @Test(timeout = 1000)
    public void testSeven() {
        Assert.assertFalse(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_SEVEN_NUMBER_ARGUMENT));
    } //testSeven

    @Test(timeout = 1000)
    public void testEight() {
        Assert.assertFalse(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_EIGHT_NUMBER_ARGUMENT));
    } //testEight

    @Test(timeout = 1000)
    public void testNine() {
        Assert.assertTrue(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_NINE_NUMBER_ARGUMENT));
    } //testNine

    @Test(timeout = 1000)
    public void testTen() {
        Assert.assertFalse(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_TEN_NUMBER_ARGUMENT));
    } //testTen

    @Test(timeout = 1000)
    public void testEleven() {
        Assert.assertTrue(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_ELEVEN_NUMBER_ARGUMENT));
    } //testEleven

    @Test(timeout = 1000)
    public void testTwelve() {
        Assert.assertFalse(TEST_FAILURE_MESSAGE, QuestionTwo.isPrime(TEST_TWELVE_NUMBER_ARGUMENT));
    } //testTwelve
}