package Q1.src;

/**
 * Created by mars on 4/3/18.
 */
/**
 * Write your solution to Question One in the getMode() method below.
 */
public final class Question {
    /**
     * Gets the mode of the specified array of values. The mode of an array is the value that occurs most often.
     *
     * You may assume the following:
     *   - the values parameter will never be {@code null}
     *   - the values parameter will have a length of one or more
     *
     * Sample usage:
     *   Input:        {5, 3, 6, 3, 3, 4, 6, 1, 6, 9, 14, 6}
     *   Return value: 6
     *
     *   Input:        {79}
     *   Return value: 79
     *
     *   Input:        {0, 3, 1, 2, 4, -1}
     *   Return value: any value in the array will be accepted
     *
     * @param values the array of values to be used in calculation
     * @return the mode of the specified array of values
     */
    public static int getMode(int[] values) {
        //TODO declare getMode() method
        int maxCount = -1;
        int maxValue = -1;
        for (int i=0;i<values.length;i++){
            int count = 0;
            for (int j = i+1; j < values.length; j++) {
                if (values[i] == values[j]){
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = values[i];
            }
        }
        System.out.println(maxValue);
        return maxValue;
    } //getMode

    public static void main(String[] args){
        int result = Question.getMode(new int[]{1, 2, 2, 3, 4, 5});
        int result2 = QuestionOne.getMode(new int[]{1, 2, 2, 3, 4, 5});
    }
}