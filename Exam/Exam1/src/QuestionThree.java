/**
 * Write your solution to Question Three in the toPigLatin() method below.
 */
public final class QuestionThree {
    /**
     * Translates, and returns, the specified English word to Pig Latin.
     *
     * Rules:
     *     - If the word begins with a vowel (a, e, i, o, u, or y), the phrase "way" is appended to the end of the word
     *
     *     - If the word does not begin with a vowel, the consonant, or group of consonants, before the vowel are
     *       moved to the back of the word, then "ay" is appended to the end
     *           # A consonant is a letter that is NOT considered a vowel
     *
     *     - If the word does not contain a vowel, the phrase "ay" is just appended to the end of the word
     *
     *     - If englishWord is not null or an empty String, you may assume that it will only consist of lowercase letters
     *
     * Sample usage:
     *     Input:        null
     *     Return value: null
     *
     *     Input:        ""
     *     Return value: ""
     *
     *     Input:        "apple"
     *     Return value: "appleway"
     *
     *     Input:        "computer"
     *     Return value: "omputercay"
     *
     *     Input:        "umbrella"
     *     Return value: "umbrellaway"
     *
     *     Input:        "streak"
     *     Return value: "eakstray"
     *
     *     Input:        "brr"
     *     Return value: "brray"
     *
     * @param englishWord the English word to be translated
     * @return the English word in Pig Latin
     */
    public static String toPigLatin(String englishWord) {
        String vowel = "aeiouy";
        if (englishWord == null){
            return null;
        }
        if (englishWord.isEmpty()){
            return "";
        }
        if (vowel.contains(""+englishWord.charAt(0))){
            return englishWord + "way";
        }
        int index = -1;
        for (int i=0;i < englishWord.length();i++){
            if (vowel.contains(""+englishWord.charAt(i))){
                index = i;
                break;
            }
        }
        if (index == -1){
            return englishWord + "ay";
        }

        if (!vowel.contains(""+englishWord.charAt(0))){
            String first = englishWord.substring(0, index);
            String second = englishWord.substring(index);
            return second + first + "ay";
        }

        return null;
    } //toPigLatin
}