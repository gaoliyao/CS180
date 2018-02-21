package com.github;

import java.util.Scanner;

/**
 * Created by mars on 2/2/18.
 */
public class CensoringPersonalInformation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // PART 3 - Censoring Personal Information


                /*
                 * DO NOT ALTER THIS CODE! This formatting is imperative to the completion of this task.
                 *
                 * Keep asking for input until the user enters an empty line
                 * If they enter an empty line and the phrase is empty, keep waiting for input
                 */
        String passage = "Crew Report: August 24, 2559 \n" +
                "Captain: \n" +
                "Name: Andrew DelRio \n" +
                "Email: rioo@infinity.unsc \n" +
                "Phone: 333-444-1117 \n" +
                "Chief Officer: \n" +
                "Name: Master Chief \n" +
                "Call Sign: Sierra 117 \n" +
                "Phone: 000-000-0117 \n" +
                "Role: Classified \n" +
                "Deck Master: \n" +
                "Name: Amanda Holiday \n" +
                "Email: holiday@infinity.unsc \n" +
                "Email: holidayAmanda@gmail.com\n";  // String for holding text to be filtered


        // Print the uncensored passage
        System.out.println("Uncensored: ");
        System.out.println(passage);

        String revisedPassage = "";
        int nameStartIndex = 0;
        while (true) {
            revisedPassage = "";
            int indexName = passage.indexOf("Name: ", nameStartIndex);
            if (indexName != -1) {
                nameStartIndex = indexName + 1;
                revisedPassage += passage.substring(0, indexName + 7);
                int endIndex = passage.indexOf('\n', indexName);
                String middleStr = passage.substring(indexName + 7, endIndex - 2);
                String reviseMiddleStr = "";
                for (char c : middleStr.toCharArray()) {
                    if (c != ' ') {
                        reviseMiddleStr += '*';
                    } else {
                        reviseMiddleStr += ' ';
                    }
                }
                revisedPassage += reviseMiddleStr;
                revisedPassage += passage.substring(endIndex - 2);
                passage = revisedPassage;
            }
            else{
                break;
            }

        }

        int emailStartIndex = 0;
        while (true) {
            revisedPassage = "";
            int indexEmail = passage.indexOf("Email: ", emailStartIndex);
            if (indexEmail != -1) {
                emailStartIndex = indexEmail + 1;
                revisedPassage += passage.substring(0, indexEmail + 8);
                int endIndex = passage.indexOf('.', indexEmail);
                String middleStr = passage.substring(indexEmail + 8, endIndex);
                String reviseMiddleStr = "";
                for (int i = 1; i < middleStr.length(); i++) {
                    if (i == 0 && middleStr.charAt(0) != '@') {
                        reviseMiddleStr += '*';
                    } else if (middleStr.charAt(0) == '@') {
                        reviseMiddleStr += '@';
                    } else {
                        if (middleStr.charAt(i) != '@' && middleStr.charAt(i - 1) != '@') {
                            reviseMiddleStr += '*';
                        } else {
                            reviseMiddleStr += middleStr.charAt(i);
                        }
                    }
                }
                revisedPassage += reviseMiddleStr;
                revisedPassage += passage.substring(endIndex);
                passage = revisedPassage;
            }
            else{
                break;
            }
        }



        int phoneStartIndex = 0;
        while (true) {
            revisedPassage = "";
            int indexPhone = passage.indexOf("Phone: ", phoneStartIndex);
            if (indexPhone != -1) {
                phoneStartIndex = indexPhone + 1;
                revisedPassage += passage.substring(0, indexPhone + 7);
                int endIndex = passage.indexOf('\n', indexPhone);
                String middleStr = passage.substring(indexPhone + 7, endIndex);
                String reviseMiddleStr = "";
                boolean changeMode = true;
                for (int i = 0; i < middleStr.length(); i++) {
                    if (i > 4) {
                        if (middleStr.charAt(i - 1) == '-' && middleStr.charAt(i - 5) == '-') {
                            changeMode = false;
                        }
                    }
                    if (changeMode) {
                        if (middleStr.charAt(i) == '-') {
                            reviseMiddleStr += '-';
                        } else {
                            reviseMiddleStr += "*";
                        }
                    } else {
                        reviseMiddleStr += middleStr.charAt(i);
                    }
                }
                revisedPassage += reviseMiddleStr;
                revisedPassage += passage.substring(endIndex);
                passage = revisedPassage;
            }
            else{
                break;
            }
        }



        // Print the censored passage
        System.out.println("Censored: ");
        System.out.println(passage);
    }
}
