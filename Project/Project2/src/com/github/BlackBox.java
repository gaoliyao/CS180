package com.github;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Sripath Mishra on 9/8/2017.
 *
 */
public class BlackBox {
    public static char box[][]; // The matrix for the game.
    public static int size;       // to store the number of rows and columns.
    public static int numball;
    public static int numlink;
    public static boolean end;
    public static int score;
    public static int high_score=-1;
    public static ArrayList<int[]> guess = new ArrayList<int[]>();

    /**
     * The default constructor which places default values to the class variables
     */
    public BlackBox()
    {
        this.box=new char[0][0];
        this.size=0;
        this.numball=0;
        this.numlink=0;
        this.end=false;
        this.score=0;
    }
    /**
     * The parameterized constructor which places values to the class variables
     */
    public BlackBox(int size, int numball, int numlink, boolean end, int score)
    {
        this.size=size;
        this.box=new char[this.size][this.size];
        this.numball=numball;
        this.numlink=numlink;
        this.end=end;
        this.score=score;
    }
    /**
     * The main function takes input for the difficulty level and call the functions initialize(int) and
     * playgame()
     */
    public static void main(String[] args) {
        //Todo:start the game print the welcome message and ask for correct difficulty level.
        //Todo: end the game if the user says quit.
        //Todo:call the functions initialize and playgame()
        // Todo: take care of high score
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the BlackBox Game! Please enter the difficulty level: (quit to exit)");
        String level = sc.nextLine();
        int size = difficultySetter(level);
        BlackBox blackBox = new BlackBox(size, 3, 0, false, 0);
        blackBox.initialize();
        blackBox.printbox();
        playgame();


    }

    public static int difficultySetter(String level){
        if (level.equalsIgnoreCase("easy"))
            return 7;
        else if (level.equalsIgnoreCase("medium"))
            return 9;
        else if (level.equalsIgnoreCase("hard"))
            return 11;
        else{
            return -1;
        }
    }
    /**
     * The initialize funtion
     */
    public void initialize() {
        //Todo:initialise the Box[][]
        //Todo: place the 'X' and the '#'
        // Todo: place 3 '0''s randomly.
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                box[i][j] = ' ';
            }
        }
        for (int i=0;i<size;i++){
            box[0][i] = '#';
        }
        for (int i=0;i<size;i++){
            box[size-1][i] = '#';
        }
        for (int i=0;i<size;i++){
            box[i][size-1] = '#';
        }
        for (int i=0;i<size;i++){
            box[i][0] = '#';
        }
        box[0][0] = 'X';
        box[0][size-1] = 'X';
        box[size-1][0] = 'X';
        box[size-1][size-1] = 'X';

        Random random = new Random();
        int count = 0;
        while (count < 3){
            int x = random.nextInt(size-2)+1;
            int y = random.nextInt(size-2)+1;
            if (box[x][y] == ' ') {
                box[x][y] = '0';
                count++;
            }
        }
    }
    /**
     * The printbox funtion prints out the matrix in a particular format as given in the handout.
     */
    public static void printbox() {
        //Todo:print the box in the correct order
        // for  5*5 example
        /* 1  2  3  4  5  6  7
         ======================
        1|X |# |# |# |# |# |X |
        2|# |  |  |  |  |  |# |
        3|# |  |  |  |  |  |# |
        4|# |  |  |  |  |  |# |
        5|# |  |  |  |  |  |# |
        6|# |  |  |  |  |  |# |
        7|X |# |# |# |# |# |X |
         ======================*/
        //place the guesses as the come and print the balls when the player enter sumbit.
        System.out.print(" ");
        for (int i=0;i<size;i++){
            System.out.print(i+1);
            System.out.print("  ");
        }
        System.out.print("\n");
        System.out.print(" ");
        for (int i=0;i<size*3+1;i++){
            System.out.print("=");
        }
        System.out.print("\n");
        for (int i=0;i<size;i++){
            System.out.print(Integer.toString(i+1)+"|");
            for (int j=0;j<size;j++){
                char c = ' ';
                if (box[i][j] != '0'){
                    c = box[i][j];
                }
                for (int[] point:guess){
                    if (point[0] == i && point[1] == j){
                        c = '*';
                    }
                }
                System.out.print(c + " |");
            }
            System.out.print("\n");
        }
        System.out.print(" ");
        for (int i=0;i<size*3+1;i++){
            System.out.print("=");
        }
        System.out.print("\n");
    }
    /**
     * The playgame funtion opens the first cell and is the main controller for the game. It calls various function when needed.
     */
    public static void playgame() {
        //Todo:Take input of a guess or hint from the user.
        //Todo:Check for valid input
        //Todo:call required functions
        //Todo:keep tab on score.
        System.out.println("Choose the new coordinates (row, column) to play the next step or say submit/quit to end the game: ");
        Scanner sc = new Scanner(System.in);
        boolean isContinue = true;
        while (isContinue){
            String input = sc.nextLine();
            int mode = inputHandler(input);
            if (mode == -1){
                System.out.println("Please make sure your input is valid. (quit to exit)");
                continue;
            }
            else if (mode == 0){
                isContinue = false;
            }
            else if (mode == 1){
                printbox(2);
            }
            else if (mode == 2){
                int x = Integer.parseInt(""+input.charAt(0));
                int y = Integer.parseInt(""+input.charAt(2));
                check(x, y);
            }
            else if (mode == 3){
                int x = Integer.parseInt(""+input.charAt(0));
                int y = Integer.parseInt(""+input.charAt(2));
                boolean isValid = guess(x, y);
                if (!isValid){
                    System.out.println("You can only guess for three points!");
                }
            }
            else{
                System.err.println("Unhandled situation");
            }
        }
    }
    public static void printbox(int a){
        System.out.print(" ");
        for (int i=0;i<size;i++){
            System.out.print(i+1);
            System.out.print("  ");
        }
        System.out.print("\n");
        System.out.print(" ");
        for (int i=0;i<size*3+1;i++){
            System.out.print("=");
        }
        System.out.print("\n");
        for (int i=0;i<size;i++){
            System.out.print(Integer.toString(i+1)+"|");
            for (int j=0;j<size;j++){
                char c = box[i][j];
                System.out.print(c + " |");
            }
            System.out.print("\n");
        }
        System.out.print(" ");
        for (int i=0;i<size*3+1;i++){
            System.out.print("=");
        }
        System.out.print("\n");
    }
    private static boolean guess(int x, int y) {
        if (guess.size() == 3){
            return false;
        }
        guess.add(new int[]{x-1, y-1});
        printbox();
        return true;
    }

    /**
     * The check funtion takes in the row and column in the matrix, checks for Hit (H), Reflection (R) or Divergence(#num)
     *
     */
    public static void check(int i,int j) {
        //Todo:place a guess when the input of i and j are valid
        //Todo:Check for a Hit
        //Todo:Check for a reflection
        //Todo:Check for a bounce
        //Todo:Print the statement mentioned in the handout in case of a placing of 4th or more ball.
        if (hitcheck(i-1, j-1)){
            box[i-1][j-1] = 'H';
            printbox();
        }
        else if (reflectionCheck(i-1, j-1)){
            box[i-1][j-1] = 'R';
            printbox();
        }
        else if (deflectionCheck(i-1, j-1)){
            box[i-1][j-1] = 'D';
            printbox();
        }
        else if (straightRay(i-1, j-1)){
            box[i-1][j-1] = '1';
            printbox();
        }
        else{
            System.out.println("???");
            printbox();
        }
    }
    /**
     * The hitcheck funtion takes in the row and column in the matrix, checks for Hit (H)
     *
     */
    public static boolean hitcheck(int i, int j) {
        if (isEdge(i)){
            for (int n=1;n<size-1;n++){
                if (box[n][j] == '0'){
                    return true;
                }
            }
        }
        else if (isEdge(j)){
            for (int n=1;n<size-1;n++){
                if (box[i][n] == '0'){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isEdge(int num) {
        if (num == 0 || num == size-1){
            return true;
        }
        return false;
    }

    /**
     * The check funtion takes in the row and column in the matrix, checks for Reflection (R)
     *
     */
    public static boolean reflectionCheck(int i, int j) {
        if (isEdge(i)){
            if (i == 0){
                if (box[1][j+1] == '0' || box[1][j-1] == '0'){
                    return true;
                }
                else{
                    for (int n=1;n<size-1;n++){
                        if (box[n][j-1] == '0' && box[n][j+1] == '0'){
                            return true;
                        }
                    }
                }
            }
            if (i == size-1){
                if (box[size-2][j+1] == '0' || box[size-2][j-1] == '0'){
                    return true;
                }
                else{
                    for (int n=1;n<size-1;n++){
                        if (box[n][j-1] == '0' && box[n][j+1] == '0'){
                            return true;
                        }
                    }
                }
            }
        }
        if (isEdge(j)){
            if (j == 0){
                if (box[i+1][1] == '0' || box[i-1][1] == '0'){
                    return true;
                }
                else{
                    for (int n=1;n<size-1;n++){
                        if (box[i+1][n] == '0' && box[i-1][n] == '0'){
                            return true;
                        }
                    }
                }
            }
            if (j == size-1){
                if (box[i-1][size-2] == '0' || box[i+1][size-2] == '0'){
                    return true;
                }
                else{
                    for (int n=1;n<size-1;n++){
                        if (box[i-1][n] == '0' && box[i+1][n] == '0'){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     * The check funtion takes in the row and column in the matrix, checks for Divergence(#num)
     *
     */
    public static boolean deflectionCheck(int i, int j) {
        if (isEdge(i)){
                    for (int n=1;n<size-1;n++){
                        if (box[n][j-1] == '0' || box[n][j+1] == '0'){
                            return true;
                        }

            }
        }
        if (isEdge(j)){
                    for (int n=1;n<size-1;n++){
                        if (box[i-1][n] == '0' && box[i+1][n] == '0'){
                            return true;
                        }
            }
        }
        return false;
    }
    /**
     * The straightRay funtion takes in the row and column in the matrix, checks for Straight ray
     *
     */
    public static boolean straightRay(int i, int j){
        if (isEdge(i)){
            for (int n=1;n<size-1;n++){
                if (box[n][j] == '0'){
                    return false;
                }
            }
        }
        else if (isEdge(j)){
            for (int n=1;n<size-1;n++){
                if (box[i][n] == '0'){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * The following definitions are the getters and setter functions which have to be implemented
     *
     */
    public char[][] getbox() {
        return box;
    }
    public int getscore() {
        return score;
    }
    public int getNumball() {
        return numball;
    }
    public int getNumlink() {
        return numlink;
    }
    public boolean getend() {
        return end;
    }
    public void setbox(char box[][]) {
        this.box = box;
    }
    public void setSize(int size){
        this.size = size;
    }
    public void setNumball(int Numball) {
        this.numball = Numball;

    }
    public void setNumlink(int Numlink) {
        this.numlink = Numlink;
    }
    public void setEnd(boolean end) {
        this.end = end;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public static int inputHandler(String input){
        if (input.equalsIgnoreCase("submit")){
            return 1;
        }
        else if (input.equalsIgnoreCase("quit")){
            return 0;
        }
        else{
            if (input.length() == 3 && input.contains(",")){
                // check
                if (input.charAt(0) == '1' || input.charAt(2) == '1'
                        || input.charAt(0) == '1'+size-1 || input.charAt(2) == '1'+size-1) {
                    return 2;
                }
                // guess
                else{
                    return 3;
                }
            }
            else{
                return -1;
            }
        }
    }
}