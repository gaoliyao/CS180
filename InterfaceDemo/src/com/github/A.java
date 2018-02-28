package com.github;

/**
 * Created by mars on 2/27/18.
 */
public interface A {
    default void b(Integer x){
        System.out.println("A");
    }
}
