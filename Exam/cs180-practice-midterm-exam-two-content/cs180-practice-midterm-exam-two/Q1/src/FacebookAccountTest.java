
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * FacebookAccountTest: Test cases for FacebookAccount.java
 *
 * CS180:S17 Exam 2 Test Cases
 *
 * @author Sahil Pujari (pujari@purdue.edu)
 * @version March 22, 2017
 */
public class FacebookAccountTest {
    private FacebookAccount facebookAccount;
    private String message;

    @Test(timeout=100)
    public void testGetLikes0() {
        facebookAccount = new FacebookAccount(5, 3);
        int expectedLikes = 3;

        message = "Check if you have implemented a getter for numLikes properly";
        assertEquals(message, facebookAccount.getLikes(), expectedLikes);
    }

    @Test(timeout=100)
    public void testGetLikes1() {
        facebookAccount = new FacebookAccount(234, 125);
        int expectedLikes = 125;

        message = "Check if you have implemented a getter for numLikes properly";
        assertEquals(message, facebookAccount.getLikes(), expectedLikes);
    }

    @Test(timeout=100)
    public void testGetLikes2() {
        facebookAccount = new FacebookAccount(3499, 4325);
        int expectedLikes = 4325;

        message = "Check if you have implemented a getter for numLikes properly";
        assertEquals(message, facebookAccount.getLikes(), expectedLikes);
    }

    @Test(timeout=100)
    public void testGetFriends0() {
        facebookAccount = new FacebookAccount(5, 3);
        int expectedFriends = 5;

        message = "Check if you have implemented a getter for numFriends properly";
        assertEquals(message, facebookAccount.getFriends(), expectedFriends);
    }

    @Test(timeout=100)
    public void testGetFriends1() {
        facebookAccount = new FacebookAccount(234, 125);
        int expectedFriends = 234;

        message = "Check if you have implemented a getter for numFriends properly";
        assertEquals(message, facebookAccount.getFriends(), expectedFriends);
    }

    @Test(timeout=100)
    public void testGetFriends2() {
        facebookAccount = new FacebookAccount(3499, 4325);
        int expectedFriends = 3499;

        message = "Check if you have implemented a getter for numFriends properly";
        assertEquals(message, facebookAccount.getFriends(), expectedFriends);
    }

    @Test(timeout=100)
    public void testImplementsFriendable() {
        facebookAccount = new FacebookAccount(3499, 4325);

        message = "Check if you are implementing the Friendable interface properly";
        boolean isImplementingFriendable = Friendable.class.isAssignableFrom(facebookAccount.getClass());
        assertTrue(message, isImplementingFriendable);
    }

    @Test(timeout=100)
    public void testImplementsLikeable() {
        facebookAccount = new FacebookAccount(3499, 4325);

        message = "Check if you are implementing the Likeable interface properly";
        boolean isImplementingLikeable = Likeable.class.isAssignableFrom(facebookAccount.getClass());
        assertTrue(message, isImplementingLikeable);
    }
}
