package com.github;

/**
 * Created by mars on 1/30/18.
 */
public class test {
    public static void main(String[] args){
        String s1 = "CS18000";
        String s2 = "CS18000";
        String s3 = new String("CS18000");
        String s4 = "CS00000";

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);

        System.out.println("--------------");

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));


    }
}
