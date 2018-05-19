package com.github;

/**
 * Created by mars on 2/22/18.
 */
public class Cell {

    public Cell(boolean living){
        this.living = living;
    }
    public boolean getLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    private boolean living = true;
}
