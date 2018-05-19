import org.junit.Test;
import org.junit.Assert;

/**
 * Student test cases for the QuestionFour class.
 */
public final class QuestionFourStudentTest {
    /*
     * Constants used during testing.
     */
    private static final String TEST_ONE_A_STRING_ARGUMENT;
    private static final String TEST_TWO_A_STRING_ARGUMENT;
    private static final String TEST_THREE_A_STRING_ARGUMENT;
    private static final String TEST_FOUR_A_STRING_ARGUMENT;
    private static final String TEST_FIVE_A_STRING_ARGUMENT;
    private static final String TEST_SIX_A_STRING_ARGUMENT;
    private static final String TEST_SEVEN_A_STRING_ARGUMENT;
    private static final String TEST_EIGHT_A_STRING_ARGUMENT;
    private static final String TEST_NINE_A_STRING_ARGUMENT;
    private static final String TEST_TEN_A_STRING_ARGUMENT;
    private static final String TEST_ELEVEN_A_STRING_ARGUMENT;
    private static final String TEST_TWELVE_A_STRING_ARGUMENT;

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

    static {
        TEST_ONE_A_STRING_ARGUMENT = null;
        TEST_TWO_A_STRING_ARGUMENT = "";
        TEST_THREE_A_STRING_ARGUMENT = "z";
        TEST_FOUR_A_STRING_ARGUMENT = "aBCdeFg";
        TEST_FIVE_A_STRING_ARGUMENT = "asdfasdf";
        TEST_SIX_A_STRING_ARGUMENT = "47as*&*)( KL2678JH@$^@*#@)+";
        TEST_SEVEN_A_STRING_ARGUMENT = "Logan is awesome!";
        TEST_EIGHT_A_STRING_ARGUMENT = "*&^*&()#(!((*)~(*&(*&`(*&*&%_)(*+_)+_:^*&^*'&^%&^%(*&&^$%^#^&^@&*($&^!$#@*&^&$%";
        TEST_NINE_A_STRING_ARGUMENT = "23457789127981439874287614389056010345234519872413954201347682347814871243014012340123401278147814378787";
        TEST_TEN_A_STRING_ARGUMENT = "41398714789*&(&)(^&^%&^5576%$^%$*&^*(&^kjhkjhsfdaKJHLKJH79087*&^%&^$%^%$^%*^&*&KKJHSKJ(*&987987safklfskl+_()*)(*  14982%^$^%$*&^&^    fjkasd$^%$^%$^%fkjsadfjkl(*&*(&*)ask";
        TEST_ELEVEN_A_STRING_ARGUMENT = "s1+BLH6JOa/%,_9,oFHd47l.gz!@xO>E3w)b|l2BN}JJ>OXK||SiTWHh*$40E.S]PtQWJU@,O>D5k#!uxY+Jm,,7_2NbD1EKgvI6DF[veN\\o}K_W/OVvY@@BlG8B3WFKt4d@+TmmbFZVz`D,T4eazanH,w+[f&8(lVtQPT+k&D%2IDgyG$xtnw4jgEsxul0Ua)T0GO9V/t}8J_0aUzw8Uc]YR,dd9U*>&]|CeY3JU9e|*##?|D>3_9XJDeHnLZ)HcCbQRV/Qf#1!,j+.&^M{m{@,E+M5*mvzUN&cl[{qOOO>";
        TEST_TWELVE_A_STRING_ARGUMENT = "T8yB}P0Ix0,SDo}NGSil0\\n@KV26oE#~%>C)7H8D\"fa\"@lD[%e";

        TEST_ONE_EXPECTED_RETURN_VALUE = null;
        TEST_TWO_EXPECTED_RETURN_VALUE = "";
        TEST_THREE_EXPECTED_RETURN_VALUE = "z";
        TEST_FOUR_EXPECTED_RETURN_VALUE = "aBCdeFg";
        TEST_FIVE_EXPECTED_RETURN_VALUE = "aassddff";
        TEST_SIX_EXPECTED_RETURN_VALUE = "477as***&))( KL268JH@@@$^#+";
        TEST_SEVEN_EXPECTED_RETURN_VALUE = "Loogaan  issweem!";
        TEST_EIGHT_EXPECTED_RETURN_VALUE = "*************&&&&&&&&&&&&&&&&^^^^^^^^^^^(((((((((())))###!!~`%%%%%___++:'$$$$@@";
        TEST_NINE_EXPECTED_RETURN_VALUE = "22222222222333333333333444444444444444445555577777777777777888888888888899999911111111111111166600000000";
        TEST_TEN_EXPECTED_RETURN_VALUE = "44411139999998888887777777*************&&&&&&&&&&&&&&&(((((((())))^^^^^^^^^^^^^^^^^^%%%%%%%%%%%%556$$$$$$$$$kkkkkkkkjjjjjhhssssssffffffdddaaaaaKKKKKJJJJHHHL0Slll+_      2";
        TEST_ELEVEN_EXPECTED_RETURN_VALUE = "ss111+++++++BBBBLLHHHHHH66JJJJJJJJOOOOOOOOOaaaaa////%%,,,,,,,,,,_____99999ooFFFFdddd4444477llllll...ggggzzzzz!!!@@@@@@xxxx>>>>>>EEEEE3333wwww)))bbbb||||||222NNNN}}}XXKKKKSSiTTTTTWWWWh****$$0000]]]PPtttttQQQQUUUUUUUDDDDDDDD55kk####uuYYYYmmmmmvvvvII[[[eeeee\\VVVVVGGG8888ZZ`nnnff&&&&&(yjjcccRRCC?^MM{{{q";
        TEST_TWELVE_EXPECTED_RETURN_VALUE = "T88yB}}P000Ix,SSDDDooNGill\\n@@KV26E#~%%>C)7H\"\"fa[e";

        TEST_FAILURE_MESSAGE = "Ensure that your return value matches the expected return value!";
    } //static

    @Test(timeout = 1000)
    public void testOne() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_ONE_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_ONE_A_STRING_ARGUMENT));
    } //testOne

    @Test(timeout = 1000)
    public void testTwo() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_TWO_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_TWO_A_STRING_ARGUMENT));
    } //testTwo

    @Test(timeout = 1000)
    public void testThree() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_THREE_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_THREE_A_STRING_ARGUMENT));
    } //testThree

    @Test(timeout = 1000)
    public void testFour() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_FOUR_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_FOUR_A_STRING_ARGUMENT));
    } //testFour

    @Test(timeout = 1000)
    public void testFive() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_FIVE_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_FIVE_A_STRING_ARGUMENT));
    } //testFive

    @Test(timeout = 1000)
    public void testSix() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_SIX_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_SIX_A_STRING_ARGUMENT));
    } //testSix

    @Test(timeout = 1000)
    public void testSeven() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_SEVEN_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_SEVEN_A_STRING_ARGUMENT));
    } //testSeven

    @Test(timeout = 1000)
    public void testEight() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_EIGHT_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_EIGHT_A_STRING_ARGUMENT));
    } //testEight

    @Test(timeout = 1000)
    public void testNine() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_NINE_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_NINE_A_STRING_ARGUMENT));
    } //testNine

    @Test(timeout = 1000)
    public void testTen() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_TEN_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_TEN_A_STRING_ARGUMENT));
    } //testTen

    @Test(timeout = 1000)
    public void testEleven() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_ELEVEN_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_ELEVEN_A_STRING_ARGUMENT));
    } //testEleven

    @Test(timeout = 1000)
    public void testTwelve() {
        Assert.assertEquals(TEST_FAILURE_MESSAGE, TEST_TWELVE_EXPECTED_RETURN_VALUE, QuestionFour.group(TEST_TWELVE_A_STRING_ARGUMENT));
    } //testTwelve
}