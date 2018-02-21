package com.github;

import java.util.Scanner;

/**
 * Created by mars on 1/30/18.
 */
public class test2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int number = -1;
        int sum = 0;
        int c = 0;

        while (sc.hasNextInt()){
            number = sc.nextInt();
            c += 1;
            sum += number;
        }

        System.out.printf("sum of %d values is %d\n", c, sum);
    }
}
