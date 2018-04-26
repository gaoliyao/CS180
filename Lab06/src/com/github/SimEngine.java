package com.github;

/**
 * Created by mars on 2/22/18.
 */
public class SimEngine {



    public static void main(String[] args){
        GameLogic gameLogic = new GameLogic();
        gameLogic.initGridGUI();
        gameLogic.printGridGUI();
        boolean isContinue = true;
        sleepMethod(5000);
        while (isContinue){
            gameLogic.update();
            gameLogic.printGridGUI();
            sleepMethod(5000);
        }
    }


	/*You do not need to modify any of the below code!*/

    public static void sleepMethod(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }


}