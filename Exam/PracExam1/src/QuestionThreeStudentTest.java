import org.junit.Test;
import org.junit.Assert;

/**
 * Student test cases for the QuestionThree class.
 */
public final class QuestionThreeStudentTest {
    /*
     * Constants used during testing.
     */
    private static final String TEST_ONE_ENGLISH_WORD_ARGUMENT;
    private static final String TEST_TWO_ENGLISH_WORD_ARGUMENT;
    private static final String TEST_THREE_ENGLISH_WORD_ARGUMENT;
    private static final String TEST_FOUR_ENGLISH_WORD_ARGUMENT;
    private static final String TEST_FIVE_ENGLISH_WORD_ARGUMENT;
    private static final String TEST_SIX_ENGLISH_WORD_ARGUMENT;
    private static final String TEST_SEVEN_ENGLISH_WORD_ARGUMENT;
    private static final String TEST_EIGHT_ENGLISH_WORD_ARGUMENT;
    private static final String TEST_NINE_ENGLISH_WORD_ARGUMENT;
    private static final String TEST_TEN_ENGLISH_WORD_ARGUMENT;
    private static final String TEST_ELEVEN_ENGLISH_WORD_ARGUMENT;
    private static final String TEST_TWELVE_ENGLISH_WORD_ARGUMENT;

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
     * Fields used in testing.
     */
    private String returnValue;

    static {
        TEST_ONE_ENGLISH_WORD_ARGUMENT = null;
        TEST_TWO_ENGLISH_WORD_ARGUMENT = "";
        TEST_THREE_ENGLISH_WORD_ARGUMENT = "rock";
        TEST_FOUR_ENGLISH_WORD_ARGUMENT = "conclusion";
        TEST_FIVE_ENGLISH_WORD_ARGUMENT = "reinforce";
        TEST_SIX_ENGLISH_WORD_ARGUMENT = "few";
        TEST_SEVEN_ENGLISH_WORD_ARGUMENT = "sticky";
        TEST_EIGHT_ENGLISH_WORD_ARGUMENT = "ego";
        TEST_NINE_ENGLISH_WORD_ARGUMENT = "noise";
        TEST_TEN_ENGLISH_WORD_ARGUMENT = "top";
        TEST_ELEVEN_ENGLISH_WORD_ARGUMENT = "negative";
        TEST_TWELVE_ENGLISH_WORD_ARGUMENT = "appendix";

        TEST_TWO_EXPECTED_RETURN_VALUE = "[\\s]*";
        TEST_THREE_EXPECTED_RETURN_VALUE = "[\\s]*ockray[\\s]*";
        TEST_FOUR_EXPECTED_RETURN_VALUE = "[\\s]*onclusioncay[\\s]*";
        TEST_FIVE_EXPECTED_RETURN_VALUE = "[\\s]*einforceray[\\s]*";
        TEST_SIX_EXPECTED_RETURN_VALUE = "[\\s]*ewfay[\\s]*";
        TEST_SEVEN_EXPECTED_RETURN_VALUE = "[\\s]*ickystay[\\s]*";
        TEST_EIGHT_EXPECTED_RETURN_VALUE = "[\\s]*egoway[\\s]*";
        TEST_NINE_EXPECTED_RETURN_VALUE = "[\\s]*oisenay[\\s]*";
        TEST_TEN_EXPECTED_RETURN_VALUE = "[\\s]*optay[\\s]*";
        TEST_ELEVEN_EXPECTED_RETURN_VALUE = "[\\s]*egativenay[\\s]*";
        TEST_TWELVE_EXPECTED_RETURN_VALUE = "[\\s]*appendixway[\\s]*";

        TEST_FAILURE_MESSAGE = "Ensure that your return value matches the expected return value!";
    } //static

    @Test(timeout = 1000)
    public void testOne() {
        this.returnValue = QuestionThree.toPigLatin(TEST_ONE_ENGLISH_WORD_ARGUMENT);

        Assert.assertNull(String.format(TEST_FAILURE_MESSAGE, "null", this.returnValue), this.returnValue);
    } //testOne

    @Test(timeout = 1000)
    public void testTwo() {
        this.returnValue = QuestionThree.toPigLatin(TEST_TWO_ENGLISH_WORD_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "", this.returnValue), this.returnValue.matches(TEST_TWO_EXPECTED_RETURN_VALUE));
    } //testTwo

    @Test(timeout = 1000)
    public void testThree() {
        this.returnValue = QuestionThree.toPigLatin(TEST_THREE_ENGLISH_WORD_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "oisonpay", this.returnValue), this.returnValue.matches(TEST_THREE_EXPECTED_RETURN_VALUE));
    } //testThree

    @Test(timeout = 1000)
    public void testFour() {
        this.returnValue = QuestionThree.toPigLatin(TEST_FOUR_ENGLISH_WORD_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "admirationway", this.returnValue), this.returnValue.matches(TEST_FOUR_EXPECTED_RETURN_VALUE));
    } //testFour

    @Test(timeout = 1000)
    public void testFive() {
        this.returnValue = QuestionThree.toPigLatin(TEST_FIVE_ENGLISH_WORD_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "ysicsphay", this.returnValue), this.returnValue.matches(TEST_FIVE_EXPECTED_RETURN_VALUE));
    } //testFive

    @Test(timeout = 1000)
    public void testSix() {
        this.returnValue = QuestionThree.toPigLatin(TEST_SIX_ENGLISH_WORD_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "airfay", this.returnValue), this.returnValue.matches(TEST_SIX_EXPECTED_RETURN_VALUE));
    } //testSix

    @Test(timeout = 1000)
    public void testSeven() {
        this.returnValue = QuestionThree.toPigLatin(TEST_SEVEN_ENGLISH_WORD_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "allway", this.returnValue), this.returnValue.matches(TEST_SEVEN_EXPECTED_RETURN_VALUE));
    } //testSeven

    @Test(timeout = 1000)
    public void testEight() {
        this.returnValue = QuestionThree.toPigLatin(TEST_EIGHT_ENGLISH_WORD_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "uckplay", this.returnValue), this.returnValue.matches(TEST_EIGHT_EXPECTED_RETURN_VALUE));
    } //testEight

    @Test(timeout = 1000)
    public void testNine() {
        this.returnValue = QuestionThree.toPigLatin(TEST_NINE_ENGLISH_WORD_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "inearlay", this.returnValue), this.returnValue.matches(TEST_NINE_EXPECTED_RETURN_VALUE));
    } //testNine

    @Test(timeout = 1000)
    public void testTen() {
        this.returnValue = QuestionThree.toPigLatin(TEST_TEN_ENGLISH_WORD_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "trainer", this.returnValue), this.returnValue.matches(TEST_TEN_EXPECTED_RETURN_VALUE));
    } //testTen

    @Test(timeout = 1000)
    public void testEleven() {
        this.returnValue = QuestionThree.toPigLatin(TEST_ELEVEN_ENGLISH_WORD_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "andfathergray", this.returnValue), this.returnValue.matches(TEST_ELEVEN_EXPECTED_RETURN_VALUE));
    } //testEleven

    @Test(timeout = 1000)
    public void testTwelve() {
        this.returnValue = QuestionThree.toPigLatin(TEST_TWELVE_ENGLISH_WORD_ARGUMENT);

        Assert.assertTrue(String.format(TEST_FAILURE_MESSAGE, "hmmay", this.returnValue), this.returnValue.matches(TEST_TWELVE_EXPECTED_RETURN_VALUE));
    } //testTwelve
}