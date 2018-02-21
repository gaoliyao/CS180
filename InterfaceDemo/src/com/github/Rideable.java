package com.github;

/**
 * Created by mars on 2/20/18.
 */
public interface Rideable {
    void mount();
    void dismount();
    void move(boolean forward);
    void turn(int direction);
    void setSpeed(double mph);
}
