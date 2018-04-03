import com.sun.deploy.util.SessionState;
import com.sun.tools.example.debug.tty.TTY;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

final class ChatServer {
    private static int uniqueId = 0;
    // Data structure to hold all of the connected clients
    private final List<ClientThread> clients = new ArrayList<>();
    private final int port;			// port the server is hosted on
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    static Object obj = new Object();
    private final List<TicTacToeGame> ticTacToeGames = new ArrayList<>();

    /**
     * ChatServer constructor
     * @param port - the port the server is being hosted on
     */
    private ChatServer(int port) {
        this.port = port;
    }

    /*
     * This is what starts the ChatServer.
     * Right now it just creates the socketServer and adds a new ClientThread to a list to be handled
     */
    private void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                Runnable r = new ClientThread(socket, uniqueId++);
                Thread t = new Thread(r);
                clients.add((ClientThread) r);
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void broadcast(String message, String username){
        synchronized (obj) {
            String time = sdf.format(new Date());
            String formattedMessage = time + " " + username + " " + message + "\n";
            System.out.print(formattedMessage);

            for (ClientThread clientThread : clients) {
                clientThread.writeMessage(formattedMessage);
            }
            System.out.println("Broadcasting...");
        }
    }


    private synchronized void remove(int id){
        clients.remove(id);
    }

    private void close(){
        try {
            for (ClientThread c: clients) {
                c.sInput.close();
                c.sOutput.close();
                c.socket.close();
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *	Sample code to use as a reference for Tic Tac Toe
     *
     * directMessage - sends a message to a specific username, if connected
     * @param message - the string to be sent
     * @param username - the user the message will be sent to
     */
    private synchronized void directMessage(String message, String username, String sentUser) {
        String time = sdf.format(new Date());
        String formattedMessage = time +  " " + sentUser + " => " + username + " " + message + "\n";
        System.out.print(formattedMessage);

        for (ClientThread clientThread : clients) {
            if (clientThread.username.equalsIgnoreCase(username)) {
                clientThread.writeMessage(formattedMessage);
            }
        }
    }


    /*
     *  > java ChatServer
     *  > java ChatServer portNumber
     *  If the port number is not specified 1500 is used
     */
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String command = sc.nextLine();
        if (args.length == 0){
            ChatServer server = new ChatServer(1500);
            server.start();
        }
        if (args.length == 1) {
            ChatServer server = new ChatServer(Integer.parseInt(args[0]));
            server.start();
        }
    }


    /*
     * This is a private class inside of the ChatServer
     * A new thread will be created to run this every time a new client connects.
     */
    private final class ClientThread implements Runnable {
        Socket socket;                  // The socket the client is connected to
        ObjectInputStream sInput;       // Input stream to the server from the client
        ObjectOutputStream sOutput;     // Output stream to the client from the server
        String username;                // Username of the connected client
        ChatMessage cm;                 // Helper variable to manage messages
        int id;

        /*
         * socket - the socket the client is connected to
         * id - id of the connection
         */
        private ClientThread(Socket socket, int id) {
            this.id = id;
            this.socket = socket;
            try {
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                sInput = new ObjectInputStream(socket.getInputStream());
                username = (String) sInput.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        /*
         * This is what the client thread actually runs.
         */
        @Override
        public void run() {
            // Read the username sent to you by client
            while (true) {
                try {
                    cm = (ChatMessage) sInput.readObject();
                    if (cm == null){
                        continue;
                    }
                    System.out.println(cm.getType());
                    System.out.println(cm.getMessage());
                    System.out.println(cm.getRecepient());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

                if (cm.getType() == ChatMessage.MESSAGE) {
                    broadcast(cm.getMessage(), username);
                } else if (cm.getType() == ChatMessage.LOGOUT) {
                    broadcast("LOGOUT " + username + ": " + cm.getMessage(), username);
                    try {
                        sInput.close();
                        sOutput.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                    //break;
                } else if (cm.getType() == ChatMessage.DM) {
                    directMessage(cm.getMessage(), cm.getRecepient(), username);
//                for (ClientThread c: clients){
//                    if (c.username.equalsIgnoreCase(cm.getRecepient())){
//                        c.writeMessage(cm.getMessage());
//                    }
//                }
                } else if (cm.getType() == ChatMessage.LIST) {
                    String output = "";
                    for (ClientThread c : clients) {
                        output += c.username + " ";
                    }
                    for (ClientThread c : clients) {
                        if (c.username.equalsIgnoreCase(username)) {
                            c.writeMessage(output+"\n");
                        }
                    }
                } else if (cm.getType() == ChatMessage.TICTACTOE) {
                    boolean isInGame = false;
                    boolean isFinish = false;
                    TicTacToeGame curTTT = null;
                    for (TicTacToeGame t: ticTacToeGames){
                        if (t.isUserInGame(username) && t.isUserInGame(cm.getRecepient())){
                            isInGame = true;
                            boolean isValidTurn = t.takeTurn(username, Integer.parseInt(cm.getMessage()));
                            if (isValidTurn){
                                directMessage("\n"+t.toString(), username, "System");
                                directMessage("\n"+t.toString(), cm.getRecepient(), username);
                            }
                            else{
                                directMessage("Invalid operation!", username, "System");
                            }
                            if (t.isFinish()){
                                directMessage(t.winner + "won!", username, "System");
                                directMessage(t.winner + "won!", cm.getRecepient(), "System");
                                isFinish = true;
                                curTTT = t;
                            }
                        }
                    }
                    if (isFinish) {
                        ticTacToeGames.remove(curTTT);
                    }
                    if (!isInGame){
                        curTTT = new TicTacToeGame(username, cm.getRecepient());
                        directMessage( "Game Start!", username, "System");
                        directMessage( "\n"+curTTT.toString(), username,  "System");
                        directMessage( "Game Start!", cm.getRecepient(),  username);
                        directMessage( "\n"+curTTT.toString(), cm.getRecepient(),  username);
                        if (!cm.getMessage().isEmpty()){
                            boolean isValidTurn = curTTT.takeTurn(username, Integer.parseInt(cm.getMessage()));
                            if (isValidTurn){
                                directMessage("\n"+curTTT.toString(), username, "System");
                                directMessage("\n"+curTTT.toString(), cm.getRecepient(), username);
                            }
                            else{
                                directMessage("Invalid operation!", username, "System");
                            }
                        }
                        ticTacToeGames.add(curTTT);
                    }
                }


                // Send message back to the client
//            try {
//                sOutput.writeObject("Pong");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
                //broadcast(username + ": " + cm.getMessage());
            }
        }
        private synchronized boolean writeMessage(String msg){
            try {
                sOutput.writeObject(msg);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }
}