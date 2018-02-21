package com.github;
import java.util.Scanner;

//        Price($): ​200
//        Tip Percentage(%):​ ​15
//        Price Without Tip($): 200.00
//        Tip Amount($): 30.00
//        Total Amount($): 230.00

public class TipCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Price($): ");
        String priceInput = sc.nextLine();
        double price = Double.parseDouble(priceInput);
        System.out.print("Tip Percentage(%): ");
        String tipPercentageInput = sc.nextLine();
        int tipPercentage = Integer.parseInt(tipPercentageInput);

        System.out.println();


        System.out.print("Price Without Tip($): ");
        System.out.printf("%.2f\n", price);
        System.out.print("Tip Amount($): ");
        System.out.printf("%.2f\n", tipPercentage * price / 100);
        System.out.print("Total Amount($): ");
        System.out.printf("%.2f\n", price + tipPercentage * price / 100);

    }
}
