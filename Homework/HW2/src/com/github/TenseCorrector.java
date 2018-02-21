package com.github;

import java.util.Scanner;

/**
 * Created by mars on 1/21/18.
 */
public class TenseCorrector {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Original Sentence: ");
        String originalSentence = sc.nextLine();
        System.out.print("Corrected Sentence: ");
        String correctedSentence = originalSentence.replaceAll("is", "was");
        correctedSentence = correctedSentence.replaceAll("am", "was");
        correctedSentence = correctedSentence.replaceAll("are", "were");
        correctedSentence = correctedSentence.replaceAll("do", "did");
        System.out.print(correctedSentence + "(Corrected)");


    }
}
