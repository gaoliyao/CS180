package com.github;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SqrtEstimator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter a positive number to find the square root of: [type quit to exit]");
            String inputStr = scanner.nextLine();
            if (inputStr.equalsIgnoreCase("quit")){
                break;
            }
            int num = Integer.parseInt(inputStr);
            if (num <= 0){
                System.out.println("Enter a positive number");
                continue;
            }
            else{
                System.out.println("Enter the precision of the estimator (number of digits after decimal point):");
                String iS = "";
                int precision = -1;
                iS = scanner.nextLine();
                precision = Integer.parseInt(iS);
                if (precision <= 0){
                    System.out.println("Enter a positive number");
                    continue;
                }


                double leftNum = 0;
                double rightNum = num;
                String pattern = "#0";
                if (precision > 0) {
                    pattern += ".";
                    for (int i = 0; i < precision; i++) {
                        pattern += "0";
                    }
                }
                DecimalFormat formatter = new DecimalFormat(pattern);
                while(true) {
                    double midNum = (leftNum + rightNum) / 2;
                    double squareNum = midNum * midNum;
                    if (Double.parseDouble(formatter.format(squareNum)) == num){
                        break;
                    }
                    if (midNum * midNum > num) {
                        rightNum = midNum;
                    } else if (midNum * midNum == num) {
                        leftNum = midNum;
                        rightNum = midNum;
                        break;
                    } else {
                        leftNum = midNum;
                    }
                }

                double answer = (leftNum+rightNum)/2;
                String answerStr = formatter.format(answer);
                System.out.println("Square Root of "+inputStr+": "+answerStr);
            }
        }
    }
}

//import java.text.DecimalFormat;
//        import java.util.Scanner;
//
//public class SqrtEstimator {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (true){
//            System.out.println("Enter a positive number to find the square root of: [type quit to exit]");
//            String inputStr = scanner.nextLine();
//            if (inputStr.equalsIgnoreCase("quit")){
//                break;
//            }
//            int num = Integer.parseInt(inputStr);
//            if (num <= 0){
//                System.out.println("Enter a positive number");
//                continue;
//            }
//            else{
//                System.out.println("Enter the precision of the estimator (number of digits after decimal point):");
//                String iS = scanner.nextLine();
//                int precision = Integer.parseInt(iS);
//                double leftNum = 0;
//                double rightNum = num;
//                String pattern = "#0";
//                if (precision > 0) {
//                    pattern += ".";
//                    for (int i = 0; i < precision; i++) {
//                        pattern += "0";
//                    }
//                }
//                DecimalFormat formatter = new DecimalFormat(pattern);
//                while(true) {
//                    double midNum = (leftNum + rightNum) / 2;
//                    double squareNum = midNum * midNum;
//                    if (Double.parseDouble(formatter.format(squareNum)) == num){
//                        break;
//                    }
//                    if (midNum * midNum > num) {
//                        rightNum = midNum;
//                    } else if (midNum * midNum == num) {
//                        leftNum = midNum;
//                        rightNum = midNum;
//                        break;
//                    } else {
//                        leftNum = midNum;
//                    }
//                }
//
//                double answer = (leftNum+rightNum)/2;
//                String answerStr = formatter.format(answer);
//                System.out.println("Square Root of "+inputStr+": "+answerStr);
//            }
//        }
//    }
//}
