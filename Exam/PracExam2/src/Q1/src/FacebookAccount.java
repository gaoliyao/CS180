package Q1.src; /**
 * Exam 2
 * Question 1
 *
 * DO NOT edit the interfaces Friendable and Likeable.
 * Go through the interfaces carefully and then scroll down to the TODO section.
 *
 *
 */



/**
 * TODO:
 * 		- Define a public class FacebookAccount in this file below these comments.
 * 		- The class FacebookAccount implements the interfaces Friendable and Likeable .
 * 		- Provide two private instance variables 'numFriends' and 'numLikes' within
 * 		  the class. 'numFriends' is of type int and 'numLikes' is of type int.
 * 		- Provide a constructor 'public FacebookAccount(int numFriends, int numLikes)'.
 * 		  The constructor initializes the instance variables.
 * 		- DO NOT include additional INSTANCE VARIABLES or CONSTRUCTORS.
 *
 * NOTE: You do not need to do error checking. You can assume that the values
 * of age and weight for testing will be non-negative.
 */

public final class FacebookAccount implements Friendable, Likeable{
    private int numFriends;
    private int numLikes;

    public FacebookAccount(int numFriends, int numLikes){
        this.numFriends = numFriends;
        this.numLikes = numLikes;
    }

    @Override
    public int getLikes() {
        return this.numLikes;
    }

    @Override
    public int getFriends() {
        return this.numFriends;
    }
}