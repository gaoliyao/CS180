package com.github;

import java.util.Scanner;

/**
 * Created by mars on 2/2/18.
 */
public class CensoringWords {
    public static void main(String[] args){
        String passage = "Wow, just Wow! That was quite a wow-ing sentence! Wow.";
        String word = "Wow";
        System.out.println(passage.replaceAll("\\b"+word+"\\b", "XXX"));

    }
}
