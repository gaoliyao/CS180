import java.io.Serializable;

final class ChatMessage implements Serializable {
    private static final long serialVersionUID = 6898543889087L;

    // Types of messages
    static final int MESSAGE = 0, LOGOUT = 1, DM = 2, LIST = 3, TICTACTOE = 4;

    // Here is where you should implement the chat message object.
    // Variables, Constructors, Methods, etc.
    private int type = MESSAGE;
    private String message = "";
    private String recepient = "";
    public ChatMessage (int type, String message, String recipient){
        this.type = type;
        this.message = message;
        this.recepient = recipient;
    }

    private void broadcast(String message){

    }

    private boolean writeMessage(String msg){
        return false;
    }

    private void remove(int id){

    }

    public void run(){

    }

    private void close(){

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecepient() {
        return recepient;
    }

    public void setRecepient(String recepient) {
        this.recepient = recepient;
    }
}