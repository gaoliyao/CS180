package com.github;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
    	Fibonacci fibonacci = new Fibonacci(100);
    	for (Object i:fibonacci){
			System.out.println(i);
		}
    }


}
