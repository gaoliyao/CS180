package com.github;

/**
 * Created by mars on 2/22/18.
 */
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 *
 */

public class GameLogic {

    final static int LENGTH = 100;
    static Cell[][] grid = null;
    static Cell[][] gridUpdate = null;
    public GameLogic(){
        grid = new Cell[LENGTH][LENGTH];
        gridUpdate = new Cell[LENGTH][LENGTH];
        Random random = new Random(3);
        for (int i=0;i<LENGTH;i++){
            for (int j=0;j<LENGTH;j++){

                int num = random.nextInt(10)+1;
                if (num == 1){
                    grid[i][j] = new Cell(true);
                    gridUpdate[i][j] = new Cell(true);
                }
                else{
                    grid[i][j] = new Cell(false);
                    gridUpdate[i][j] = new Cell(false);
                }
            }
        }
    }

    public boolean liveToNext(int m, int n){
        int liveCount = 0;
        // upper left
        if (m-1>=0 & n-1 >= 0){
            if (grid[m-1][n-1].getLiving() == true){
                liveCount++;
            }
        }
        // upper
        if (m-1 >= 0){
            if (grid[m-1][n].getLiving() == true){
                liveCount++;
            }
        }
        // upper right
        if (m-1>=0 && n+1<LENGTH){
            if (grid[m-1][n+1].getLiving() == true){
                liveCount++;
            }
        }
        // right
        if (n+1<LENGTH){
            if (grid[m][n+1].getLiving() == true){
                liveCount++;
            }
        }
        // bottom right
        if (m+1<LENGTH && n+1<LENGTH){
            if (grid[m+1][n+1].getLiving() == true){
                liveCount++;
            }
        }
        // bottom
        if (m+1<LENGTH){
            if (grid[m+1][n].getLiving() == true){
                liveCount++;
            }
        }
        // bottom left
        if (m+1<LENGTH && n-1>=0){
            if (grid[m+1][n-1].getLiving() == true){
                liveCount++;
            }
        }
        // left
        if (n-1>=0){
            if (grid[m][n-1].getLiving() == true){
                liveCount++;
            }
        }
        if (grid[m][n].getLiving() && liveCount == 1){
            return false;
        }
        else if (grid[m][n].getLiving() && liveCount >= 4){
            return false;
        }
        else if (grid[m][n].getLiving()){
            if (liveCount == 2 || liveCount == 3) {
                return true;
            }
        }
        else if (!grid[m][n].getLiving() && liveCount == 3){
            return true;
        }
        else {
            return false;
        }
        return false;
    }

    /*You do not need to modify any of the below code!*/
    public void update() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (liveToNext(i, j)) {
                    gridUpdate[i][j].setLiving(true);
                } else {
                    gridUpdate[i][j].setLiving(false);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j].setLiving(gridUpdate[i][j].getLiving());
            }
        }
    }

    public static JFrame frame = new JFrame();
    public static JPanel[][] gridGUI;

    public void initGridGUI() {
        gridGUI = new JPanel[grid.length][grid[0].length]; //allocate the size of grid
        frame.setLayout(new GridLayout(grid.length, grid[0].length)); //set layout
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gridGUI[i][j] = new JPanel(); //creates new panel
                gridGUI[i][j].setBackground(Color.white);
                frame.add(gridGUI[i][j]);
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setLocationRelativeTo(null);
        frame.setTitle("Conway's Game of Life");
        frame.setVisible(true);
    }

    public void printGridGUI() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getLiving()) {
                    gridGUI[i][j].setBackground(Color.black);
                } else {
                    gridGUI[i][j].setBackground(Color.white);
                }
            }
        }
    }

    public void printGrid() {

        for (int i = 0; i < grid.length; i++) {
            if (i == 0) {
                for (int k = 0; k < grid[i].length + 1; k++) {
                    System.out.print("-");
                }
                System.out.println("-");
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                if (j == grid[i].length - 1) {
                    if (grid[i][j].getLiving()) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                    System.out.println("|");
                } else {
                    if (grid[i][j].getLiving()) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            if (i == grid.length - 1) {
                for (int k = 0; k < grid[i].length; k++) {
                    System.out.print("-");
                }
                System.out.println("-");
            }
        }
    }
}
