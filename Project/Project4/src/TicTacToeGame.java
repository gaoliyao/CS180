import java.util.Scanner;

public class TicTacToeGame {

    private static final char PLAYERX = 'X';     // Helper constant for X player
    private static final char PLAYERO = 'O';     // Helper constant for O player
    private static final char SPACE = ' ';       // Helper constant for spaces

    /*
    Sample TicTacToe Board
      0 | 1 | 2
     -----------
      3 | 4 | 5
     -----------
      6 | 7 | 8
     */
    String playerX;
    String playerO;
    String currentPlayer = "";
    int[][] gameBoard = new int[3][3];
    String winner = "";

    public boolean isFinish(){
        return !winner.isEmpty();
    }

    // TODO 4: Implement necessary methods to manage the games of Tic Tac Toe
    TicTacToeGame(String playerX, String playerO){
        this.playerX = playerX;
        this.playerO = playerO;
        currentPlayer = playerX;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                this.gameBoard[i][j] = 0;
            }
        }
    }

    public boolean isWon(){
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == gameBoard[i][1] &&  gameBoard[i][1] == gameBoard[i][2]
                    && gameBoard[i][0] != 0){
                return true;
            }
            if (gameBoard[0][i] == gameBoard[1][i] &&  gameBoard[1][i] == gameBoard[2][i]
                    && gameBoard[0][i] != 0){
                return true;
            }
        }
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] &&
                gameBoard[0][0] != 0){
            return true;
        }
        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] &&
                gameBoard[1][1] != 0){
            return true;
        }
        return false;
    }

    public boolean isUserInGame(String name){
        if (name.equals(playerX)){
            return true;
        }
        if (name.equals(playerO)){
            return true;
        }
        return false;
    }

    public boolean takeTurn(String user, int num){
        if (winner.isEmpty()) {
            int i = num / 3;
            int j = num % 3;
            if (!user.equals(currentPlayer)) {
                return false;
            }
            if (currentPlayer.equals(playerX)) {
                if (gameBoard[i][j] != 0) {
                    return false;
                }
                gameBoard[i][j] = 1;
                currentPlayer = playerO;
                if (isWon()){
                    winner = playerX;
                    System.out.println(winner + "won");
                }
                return true;
            }
            if (currentPlayer.equals(playerO)) {
                if (gameBoard[i][j] != 0) {
                    return false;
                }
                gameBoard[i][j] = 2;
                currentPlayer = playerX;
                if (isWon()){
                    winner = playerO;
                    System.out.println(winner + "won");
                }
                return true;
            }
        }
        else{
            System.out.println(winner + "won");
        }
        return false;
    }


    public String toString(){
        String output = "";
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == 0) {
                    output += " ";
                }
                if (gameBoard[i][j] == 1) {
                    output += "X";
                }
                if (gameBoard[i][j] == 2) {
                    output += "O";
                }


                if (j != 2){
                    output += " | ";
                }
            }
            output += "\n";
            if (i != 2) {
                output += "----------\n";
            }
        }
        return output;
    }
    public static void main(String[] args){
        String users[] = {"mars", "iris"};
        TicTacToeGame ticTacToeGame = new TicTacToeGame("mars", "iris");
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println(ticTacToeGame.toString());
        while (true){
            System.out.println("Time for " + users[count % 2] + ": ");
            String line = sc.nextLine();
            boolean isValid = ticTacToeGame.takeTurn(users[count % 2], Integer.parseInt(line));
            if (!isValid){
                System.out.println(ticTacToeGame.toString());
                System.out.println("Not valid!");
            }
            else{
                System.out.println(ticTacToeGame.toString());
                count++;
            }
        }
    }
}