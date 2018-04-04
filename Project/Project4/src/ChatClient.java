import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net. Socket;
import java.net.SocketException;
import java.util.Scanner;

final class ChatClient {
    private ObjectInputStream sInput;
    private ObjectOutputStream sOutput;
    private Socket socket;

    private final String server;
    private final String username;
    private final int port;

    private TicTacToeGame ticTacToeGame = null;

    /* ChatClient constructor
     * @param server - the ip address of the server as a string
     * @param port - the port number the server is hosted on
     * @param username - the username of the user connecting
     */
    private ChatClient(String server, int port, String username) {
        this.server = server;
        this.port = port;
        this.username = username;
    }

    /**
     * Attempts to establish a connection with the server
     * @return boolean - false if any errors occur in startup, true if successful
     */
    private boolean start() {
        // Create a socket
        try {
            socket = new Socket(server, port);
        } catch (IOException e) {
            System.out.println("Error connected to server");
            return false;
        }

        // Attempt to create output stream
        try {
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Attempt to create input stream
        try {
            sInput = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Create client thread to listen from the server for incoming messages
        Runnable r = new ListenFromServer();
        Thread t = new Thread(r);
        t.start();

        // After starting, send the clients username to the server.
        try {
            sOutput.writeObject(username);
            sOutput.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }


    /*
     * Sends a string to the server
     * @param msg - the message to be sent
     */
    private void sendMessage(ChatMessage msg) {
        try {
            //System.out.println(msg.getMessage());
            if (sOutput == null){
                return;
            }
            sOutput.writeObject(msg);
            sOutput.reset();
        } catch (IOException e) {
            System.out.println("Error connected to server");
        }
    }


    /*
     * To start the Client use one of the following command
     * > java ChatClient
     * > java ChatClient username
     * > java ChatClient username portNumber
     * > java ChatClient username portNumber serverAddress
     *
     * If the portNumber is not specified 1500 should be used
     * If the serverAddress is not specified "localHost" should be used
     * If the username is not specified "Anonymous" should be used
     */
    public static void main(String[] args) {
        // Get proper arguments and override defaults
        Scanner sc = new Scanner(System.in);
        String username = "";
        String server = "localhost";
        int port = 1500;
//        if (commandSplitBySpace.length == 3){
//            username = commandSplitBySpace[2];
//        }
//        if (commandSplitBySpace.length == 4){
//            username = commandSplitBySpace[2];
//            port = Integer.parseInt(commandSplitBySpace[3]);
//        }
//        if (commandSplitBySpace.length == 5){
//            username = commandSplitBySpace[2];
//            port = Integer.parseInt(commandSplitBySpace[3]);
//            server = commandSplitBySpace[4];
//        }
        if (args.length == 1){
            username = args[0];
        }
        if (args.length == 2){
            username = args[0];
            port = Integer.parseInt(args[1]);
        }
        if (args.length == 3){
            username = args[0];
            port = Integer.parseInt(args[1]);
            server = args[2];
        }
        // Create your client and start it
        ChatClient client = new ChatClient(server, port, username);
        client.start();
        System.out.println("Connection accepted " + server + ":" + port);
        client.sendMessage(new ChatMessage(ChatMessage.MESSAGE,  "just connected", "System"));

        // Send an empty message to the server
        try {
            while (true) {
                System.out.print("> ");
            String mes = sc.nextLine();
            if (mes.equalsIgnoreCase("/logout")){
                    client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, "", ""));
                    client.sInput.close();
                    client.sInput = null;
                    client.sOutput.close();
                    client.sOutput = null;
                    client.socket.close();
                    client.socket = null;

                    break;
                }
                else if (mes.equalsIgnoreCase("/lists")){
                client.sendMessage(new ChatMessage(ChatMessage.LIST, username + " left", ""));
            }
            else if (mes.contains("/msg")){
                    String[] word = mes.split(" ");
                    String message = "";
                    for (int i = 2; i < word.length; i++) {
                        message += word[i] + " ";
                    }
                    client.sendMessage(new ChatMessage(ChatMessage.DM, message, word[1]));
            }
            else if (mes.contains("/ttt")){
                String[] word = mes.split(" ");
//                if (client.ticTacToeGame == null) {
//                    client.ticTacToeGame = new TicTacToeGame(username, word[1]);
//                }
                if (word.length == 3) {
//                    client.ticTacToeGame.takeTurn(username, Integer.parseInt(word[1]));
//                    System.out.println(client.ticTacToeGame.toString());
                    client.sendMessage(new ChatMessage(ChatMessage.TICTACTOE, word[2], word[1]));
//                    if (client.ticTacToeGame.isWon()){
//                        System.out.println(client.ticTacToeGame.winner + "won the game.");
//                        client.ticTacToeGame = null;
//                    }
                }
                if (word.length == 2) {
                    client.sendMessage(new ChatMessage(ChatMessage.TICTACTOE, "", word[1]));
//                    if (client.ticTacToeGame == null) {
//                        client.ticTacToeGame = new TicTacToeGame(username, word[1]);
//                    }
//                    else {
//                        System.out.println(client.ticTacToeGame.toString());
//                    }
                }
            }
                else {
                client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, mes, ""));
            }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
     * This is a private class inside of the ChatClient
     * It will be responsible for listening for messages from the ChatServer.
     * ie: When other clients send messages, the server will relay it to the client.
     */
    private final class ListenFromServer implements Runnable {
        public void run() {
            try {
                while (true) {
                    if (sInput == null){
                        break;
                    }
                    String msg = (String) sInput.readObject();
                    System.out.print(msg);
                    System.out.print("> ");

                }
            } catch (IOException | ClassNotFoundException e) {
                return ;
            }
        }
    }
}