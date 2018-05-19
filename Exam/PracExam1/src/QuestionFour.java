/**
 * Write your solution to Question Four in the group() method below.
 */
public final class QuestionFour {
    /**
     * Groups the characters in the specified String in the order they appear in, and returns the new String.
     *
     * Sample usage:
     *     Input:        null
     *     Return value: null
     *
     *     Input:        ""
     *     Return value: ""
     *
     *     Input:        "bacddacbd"
     *     Return value: "bbaaccddd"
     *
     *     Input:        "^% ##dt()&^(#)%("
     *     Return value: "^^%% ###dt((())&"
     *
     * @param aString the String whose characters are going to be grouped
     * @return the new String whose characters are grouped
     */
    public static String group(String aString) {
        if (aString == null){
            return null;
        }
        if (aString.isEmpty()){
            return "";
        }
        String newString = "";
        int len = aString.length();
        for (int i=0;i<len;i++) {
            if (aString.isEmpty()){
                break;
            }
            int index = 0;
            char c = aString.charAt(0);
            while (aString.indexOf(c + "") != -1) {
                index = aString.indexOf(c + "");
                newString += c;
                aString = aString.substring(0, index) + aString.substring(index+1);
            }
        }
        return newString;
    } //group
}