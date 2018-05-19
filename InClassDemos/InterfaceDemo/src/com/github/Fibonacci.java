package com.github;

import java.lang.reflect.Type;
import java.util.Iterator;

/**
 * Created by mars on 2/22/18.
 */
public class Fibonacci implements Iterable<Long>, Iterator<Long> {
    private int n;
    private long i;
    private long f1, f2;
    public Fibonacci(int n){
        this.n = n;
        i = 0;
        f1 = f2 = 1;
    }
    @Override
    public Iterator iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return i<n;
    }

    @Override
    public Long next() {
        if (i == 0 || i == 1){
            i++;
            return (long)1;
        }
        long t = f1 + f2;
        f1 = f2;
        f2 = t;
        i++;
        return t;
    }

    @Override
    public void remove(){
    }
}
