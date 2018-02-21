package com.github;

/**
 * Created by mars on 2/2/18.
 */
public class ReplacingWord {
    public static void main(String[] args){
        String passage = "we all scream for ice cream, I scream, you scream, we all scream for ice cream!";
        String replace = "we all scream for ice cream";
        String insert = "1234";
        replace = " " + replace;
        insert = " " + insert;
        passage = " " + passage;
        passage = passage.replace(replace, insert);
        passage = passage.substring(1);
        System.out.println(passage);
    }
}
