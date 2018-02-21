package com.github;

/**
 * Created by mars on 1/30/18.
 */
public class Palindrome {
    boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1){
            return true;
        }

        while (s.length() > 1){
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            if (first != last){
                return false;
            }
            s = s.substring(1, s.length()-1);
        }
        return true;
    }
}
