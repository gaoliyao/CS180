package com.github;

/**
 * Created by mars on 2/27/18.
 */

public interface B {
    default void b(int x){
        System.out.println("B");
    }
}
