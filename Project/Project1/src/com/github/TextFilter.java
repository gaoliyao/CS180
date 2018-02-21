import java.util.Scanner;

/**
 * TODO: DESCRIBE YOUR PROJECT HERE
 *
 * @Mars (Liyao) Gao, gao463@purdue.edu
 * @1.0 02/02/2018
 */
public class TextFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print hello message
        System.out.println("Welcome to TextFilter!");

        // Value to keep track of if the user wants to keep filtering text
        boolean keepFiltering;

        do {
            // Print options for the user to select
            System.out.println("Please select one of the following filtering options: \n");
            System.out.print("1. Filter Word\n\n" +
                    "2. Find-And-Replace\n\n" +
                    "3. Censor Information\n");

            // Save their choice
            int choice = scanner.nextInt();
            scanner.nextLine();
//            System.out.println(choiceInput);
//            int choice = -1;
//            if (choiceInput.isEmpty()){
//                choice = -1;
//                keepFiltering = false;
//
//            }
//            else{
//                choice = Integer.parseInt(choiceInput);
//            }

            if (choice == 1) {

                // PART 1 - Censoring Words


                String passage = "";  // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");

                passage = scanner.nextLine();


                String word;  // The word to be censored from the text phrase
                System.out.println("Please enter the word you would like to censor: ");

                word = scanner.nextLine();


                System.out.println("Uncensored: ");
                System.out.println(passage);

                // TODO: PART 1 - Implement your parsing here

                String replaceWord = "";
                for(char c:word.toCharArray()){
                    replaceWord += "X";
                }
                passage = passage.replaceAll("\\b"+word+"\\b", replaceWord);

                System.out.println("Censored: ");
                System.out.println(passage);


            } else if (choice == 2) {

                // PART 2 - Replacing Words


                String passage = "";  // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");


                passage = scanner.nextLine();


                String replace;  // The word to be filtered from the text phrase
                System.out.println("Please enter the word you would like to replace: ");

                replace = scanner.nextLine();


                String insert;  // The word to be inserted in the text phrase
                System.out.println("Please enter word you would like to insert: ");

                insert = scanner.nextLine();


                System.out.println("Uncensored: ");
                System.out.println(passage);


                replace = " " + replace;
                insert = " " + insert;
                passage = " " + passage;
                passage = passage.replace(replace, insert);
                passage = passage.substring(1);


                System.out.println("Censored: ");
                System.out.println(passage);



            } else if (choice == 3) {

                // PART 3 - Censoring Personal Information


                /*
                 * DO NOT ALTER THIS CODE! This formatting is imperative to the completion of this task.
                 *
                 * Keep asking for input until the user enters an empty line
                 * If they enter an empty line and the phrase is empty, keep waiting for input
                 */
                String passage = "";  // String for holding text to be filtered

                System.out.println("Please enter the phrase you would like to censor information from: ");

                while (true) {

                    // Obtain a line from the user
                    String temp = scanner.nextLine();

                    if (!passage.isEmpty() && temp.isEmpty()) {
                        break;
                    } else if (passage.isEmpty() && temp.isEmpty()) {
                        continue;
                    }


                    // Add the contents of temp into the phrase
                    passage += temp;


                    // Append a newline character to each line for parsing
                    // This will separate each line the user enters
                    // To understand how input is formatted in Part 3, please refer to the handout.
                    passage += '\n';
                }

                // Print the uncensored passage
                System.out.println("Uncensored: ");
                System.out.println(passage);

                boolean changingTextMode = false;
                String revisedPassage = "";
                // TODO: PART 3 - Implement your parsing here
                int nameStartIndex = 0;
                boolean isContinous = true;
                while (isContinous) {
                    revisedPassage = "";
                    int indexName = passage.indexOf("Name: ", nameStartIndex);
                    if (indexName != -1) {
                        nameStartIndex = indexName + 1;
                        revisedPassage += passage.substring(0, indexName + 7);
                        int endIndex = passage.indexOf('\n', indexName);
                        String middleStr = passage.substring(indexName + 7, endIndex - 1);
                        String reviseMiddleStr = "";
                        for (char c : middleStr.toCharArray()) {
                            if (c != ' ') {
                                reviseMiddleStr += '*';
                            } else {
                                reviseMiddleStr += ' ';
                            }
                        }
                        revisedPassage += reviseMiddleStr;
                        revisedPassage += passage.substring(endIndex - 1);
                        passage = revisedPassage;
                    }
                    else{
                        isContinous = false;
                    }

                }

                int emailStartIndex = 0;
                boolean isCon = true;
                while (isCon) {
                    revisedPassage = "";
                    int indexEmail = passage.indexOf("Email: ", emailStartIndex);
                    if (indexEmail != -1) {
                        emailStartIndex = indexEmail + 1;
                        revisedPassage += passage.substring(0, indexEmail + 8);
                        int endIndex = passage.indexOf('.', indexEmail);
                        String middleStr = passage.substring(indexEmail + 8, endIndex);
                        String reviseMiddleStr = "*";
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
                        isCon = false;
                    }
                }



                int phoneStartIndex = 0;
                boolean is = true;
                while (is) {
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
                        is = false;
                    }
                }

                // Print the censored passage
                System.out.println("Censored: ");
                System.out.println(passage);

            } else {

                // They entered a number that was not 1, 2 or 3
                System.out.println("The option you chose was invalid!");

            }


            System.out.println("Would you like to keep filtering? Yes/No");

            String respond = "";
            boolean isGood = false;

            while (!isGood){
                respond = scanner.nextLine();
                if (!respond.isEmpty()){
                    isGood = true;
                }
            }

            if (respond.equalsIgnoreCase("yes")){
                keepFiltering = true;
            }
            else{
                keepFiltering = false;
            }

        } while (keepFiltering);

        System.out.println("Thank you for using TextFilter!");

    }

}
