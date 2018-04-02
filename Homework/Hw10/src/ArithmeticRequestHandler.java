import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * A request handler for a server that performs simple arithmetic operations.
 *
 * <p>CS18000 -- Spring 2018 -- External Communication -- Homework</p>
 */
public final class ArithmeticRequestHandler implements Runnable {
    /**
     * The client socket of this request handler.
     */
    private Socket clientSocket;
    Scanner inServer = null;
    PrintWriter outServer = null;

    /*
     * Error message constants.
     */

    private static final String ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE;

    private static final String ILLEGAL_OPERATION_NAME_ERROR_MESSAGE;

    private static final String ILLEGAL_FIRST_OPERAND_ERROR_MESSAGE;

    private static final String ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE;

    static {
        ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE = String.format("%s: requests must include an operation name, and two operands all separated by spaces\n", ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_OPERATION_NAME_ERROR_MESSAGE = String.format("%s: the operation name must be part of the protocol\n", ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_FIRST_OPERAND_ERROR_MESSAGE = String.format("%s: the first operand must be a valid integer\n", ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE = String.format("%s: the second operand must be a valid integer\n", ArithmeticProtocol.ILLEGAL_REQUEST);
    } //static

    /**
     * Constructs a newly allocated {@code ArithmeticRequestHandler} object with the specified client socket.
     *
     * @param clientSocket the client socket of this request handler
     * @throws IllegalArgumentException if the {@code clientSocket} argument is {@code null}
     */
    public ArithmeticRequestHandler(Socket clientSocket) throws IllegalArgumentException {
        if (clientSocket == null) {
            throw new IllegalArgumentException("clientSocket argument is null");
        } else {
            this.clientSocket = clientSocket;
            try {
                inServer = new Scanner(clientSocket.getInputStream());
                outServer = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } //end if
    } //ArithmeticRequestHandler

    /**
     * Communicates with the client, and processes their requests until they disconnect.
     */
    @Override
    public void run() {
        //TODO implement run() method
        String sentence = "";
        while (inServer.hasNextLine()) {
            sentence = inServer.nextLine();

            String[] splitSentence = sentence.split(" ");
            System.out.printf(sentence);
            if (splitSentence.length != 3) {
                outServer.printf(ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE);
            } else if (!splitSentence[0].equals("ADD") && !splitSentence[0].equals("SUBTRACT")
                    && !splitSentence[0].equals("MULTIPLY") && !splitSentence[0].equals("DIVIDE")
                    ) {
                outServer.printf(ILLEGAL_OPERATION_NAME_ERROR_MESSAGE);
            } else if (!isNum(splitSentence[1])) {
                outServer.printf(ILLEGAL_FIRST_OPERAND_ERROR_MESSAGE);
            } else if (!isNum(splitSentence[2])) {
                outServer.printf(ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE);
            } else {
                if (splitSentence[0].equals("ADD")) {
                    outServer.println(Integer.parseInt(splitSentence[1]) + Integer.parseInt(splitSentence[2]));
                }
                if (splitSentence[0].equals("SUBTRACT")) {
                    outServer.println(Integer.parseInt(splitSentence[1]) - Integer.parseInt(splitSentence[2]));
                }
                if (splitSentence[0].equals("MULTIPLY")) {
                    outServer.println(Integer.parseInt(splitSentence[1]) * Integer.parseInt(splitSentence[2]));
                }
                if (splitSentence[0].equals("DIVIDE")) {
                    outServer.println(Integer.parseInt(splitSentence[1]) / Integer.parseInt(splitSentence[2]));
                }

            }
            //outServer.println(sentence);

        }


    } //run

    private boolean isNum(String str){
        for (char c: str.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}