package com.github;

import java.util.Scanner;

public class ComputerCustomizer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("CS18000's Computer Customizer");
        System.out.println();
        System.out.println("Starting Price: $4999.00");
        double price = 4999.00;

        System.out.println();
        System.out.println("Processor choices");
        System.out.println("(1) 8-core Intel Xeon W (+ $0.00)");
        System.out.println("(2) 10-core Intel Xeon W (+ $800.00)");
        System.out.println("(3) 14-core Intel Xeon W (+ $1600.00)");
        System.out.println("(4) 18-core Intel Xeon W (+ $2400.00)");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();

        switch(choice){
            case 1:
                break;
            case 2:
                price += 800;
                break;
            case 3:
                price += 1600;
                break;
            case 4:
                price += 2400;
                break;
            default:
                break;
        }

        System.out.println();
        System.out.println("Memory choices");
        System.out.println("(1) 32GB DDR4 RAM (+ $0.00)");
        System.out.println("(2) 64GB DDR4 RAM (+ $800.00)");
        System.out.println("(3) 128GB DDR4 RAM (+ $2400.00)");
        System.out.print("Your choice: ");
        choice = sc.nextInt();

        switch(choice){
            case 1:
                break;
            case 2:
                price += 800;
                break;
            case 3:
                price += 2400;
                break;
            default:
                break;
        }

        System.out.println();
        System.out.println("Storage choices");
        System.out.println("(1) 1TB SSD (+ $0.00)");
        System.out.println("(2) 2TB SSD (+ $800.00)");
        System.out.println("(3) 4TB SSD (+ $2800.00)");
        System.out.print("Your choice: ");
        choice = sc.nextInt();

        switch(choice){
            case 1:
                break;
            case 2:
                price += 800;
                break;
            case 3:
                price += 2800;
                break;
            default:
                break;
        }


        System.out.println();
        System.out.println("Graphics choices");
        System.out.println("(1) Radeon Pro Vega 56 (+ $0.00)");
        System.out.println("(2) Radeon Pro Vega 64 (+ $600.00)");
        System.out.print("Your choice: ");
        choice = sc.nextInt();

        switch(choice){
            case 1:
                break;
            case 2:
                price += 600;
                break;
            default:
                break;
        }

        System.out.println();
        System.out.println("Mouse or Trackpad");
        System.out.println("(1) Mouse (+ $0.00)");
        System.out.println("(2) Trackpad (+ $50.00)");
        System.out.println("(3) Both (+ $149.00)");
        System.out.print("Your choice: ");
        choice = sc.nextInt();

        switch(choice){
            case 1:
                break;
            case 2:
                price += 50;
                break;
            case 3:
                price += 149;
                break;
            default:
                break;
        }

        System.out.println();
        System.out.printf("Total price: $%.2f\n", price);

    }
}
