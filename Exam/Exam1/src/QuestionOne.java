/**
 * Write your solution to Question One in the getDerivative() method below.
 */
public final class QuestionOne {
    /**
     * Gets the derivative of the specified function.
     *
     * You may assume the following:
     *     - the specified function will always valid (not null, an empty String, etc.)
     *
     *     - the specified function will only contain one term
     *
     *     - the specified function's variable will be x
     *
     *     - the specified function will be in one of the forms below. c represents the coefficient, and p represents
     *       the exponent.
     *           # c
     *           # x
     *           # cx
     *           # c / x
     *           # x^p
     *           # cx^p
     *           # c / x^p
     *
     *     - the coefficient and exponent of the specified function will be of type int
     *
     * Sample usage:
     *     Input:        "0"
     *     Return value: "0"
     *
     *     Input:        "500"
     *     Return value: "0"
     *
     *     Input:        "x"
     *     Return value: "1"
     *
     *     Input:        "18000x"
     *     Return value: "18000"
     *
     *     Input:        "6 / x"
     *     Return value: "-6 / x^2"
     *
     *     Input:        "x^0"
     *     Return value: "0"
     *
     *     Input:        "x^2"
     *     Return value: "2x"
     *
     *     Input:        "x^100"
     *     Return value: "100x^99"
     *
     *     Input:        "87x^4"
     *     Return value: "348x^3"
     *
     *     Input:        "30 / x^0"
     *     Return value: "0"
     *
     *     Input:        "30 / x^6"
     *     Return value: "-180 / x^7"
     *
     * @param function the function to be differentiated
     * @return the derivative of the specified function
     */
    public static String getDerivative(String function) {
        //TODO
        if (!function.contains("x")){
            return "0";
        }
        else{
            int index = function.indexOf("^");
            int indexX = function.indexOf("x");
            if (index == -1){
                if (function.contains("/")){
                    return Integer.toString(Integer.parseInt(function.substring(0, indexX - 3))*-1) + " / x^2";
                }
                else{
                    if (function.substring(0, indexX).isEmpty()){
                        return "1";
                    }
                    else {
                        return function.substring(0, indexX);
                    }
                }
            }
            String c = function.substring(index + 1);
            if (c.equals("0")){
                return "0";
            }
            else{
                int power = Integer.parseInt(c + "");
                if (!function.contains("/")){
                    String num = function.substring(0, index-1);
                    int resultNum = -1;
                    if (num.isEmpty()){
                        resultNum = 1 * power;
                    }
                    else{
                        resultNum = Integer.parseInt(num) * power;
                    }
                    power = power - 1;
                    if (power == 0){
                        return Integer.toString(resultNum);
                    }
                    else if (power == 1){
                        return Integer.toString(resultNum) + "x";
                    }
                    else{
                        return Integer.toString(resultNum) + "x^" + Integer.toString(power);
                    }
                }
                else{
                    int indexDivision = function.indexOf("/");
                    String num = function.substring(0, indexDivision - 1);
                    int resultNum = -1;
                    if (num.isEmpty()){
                        resultNum = 1 * power;
                    }
                    else{
                        resultNum = Integer.parseInt(num) * power * (-1);
                    }
                    power = power + 1;
                    return Integer.toString(resultNum) + " / x^" + Integer.toString(power);
                }
            }
        }

    } //getDerivative
}