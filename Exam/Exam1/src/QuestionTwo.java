/**
 * Write your solution to Question Two in the isPrime() method below.
 */
public final class QuestionTwo {
    /**
     * Determine whether or not the specified number is prime. A number is prime if is only divisible by 1 and itself.
     * Note that 1 is a special case, and is NOT considered prime.
     *
     * Sample usage:
     *     Input:        -11
     *     Return value: false
     *
     *     Input:        0
     *     Return value: false
     *
     *     Input:        1
     *     Return value: false
     *
     *     Input:        2
     *     Return value: true
     *
     *     Input:        462
     *     Return value: false
     *
     *     Input:        11
     *     Return value: true
     *
     *     Input:        5659
     *     Return value: true
     *
     * @param number the number to be tested for primality
     * @return true, if the specified number is prime, and false otherwise
     */
    public static boolean isPrime(long number) {
        if (number <=1){
            return false;
        }
        else{
            for (long i=2;i*i<=number;i++){
                if (number % i == 0){
                    return false;
                }
            }
        }
        return true;

    } //isPrime
}