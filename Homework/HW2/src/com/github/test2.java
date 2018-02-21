package com.github;

import java.text.DecimalFormat;

/**
 * Created by mars on 2/10/18.
 */
public class test2 {
    public static void main(String[] args){

        int pre = 9;
        String a = "#0.";
        for (int i=0;i<pre;i++){
            a += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(a);

        System.out.println(decimalFormat.format(9));
    }
}
